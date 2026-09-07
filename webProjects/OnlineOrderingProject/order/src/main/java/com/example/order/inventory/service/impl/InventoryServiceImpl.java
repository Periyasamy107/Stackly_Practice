package com.example.order.inventory.service.impl;

import com.example.order.common.exception.DuplicateResourceException;
import com.example.order.common.exception.InsufficientStockException;
import com.example.order.common.exception.InvalidOrderException;
import com.example.order.common.exception.ResourceNotFoundException;
import com.example.order.inventory.dto.request.InventoryCreateRequest;
import com.example.order.inventory.dto.request.InventoryUpdateRequest;
import com.example.order.inventory.dto.response.InventoryResponse;
import com.example.order.inventory.entity.Inventory;
import com.example.order.inventory.mapper.InventoryMapper;
import com.example.order.inventory.repository.InventoryRepository;
import com.example.order.inventory.service.InventoryService;
import com.example.order.product.entity.Product;
import com.example.order.product.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;
    private final InventoryMapper inventoryMapper;

    @Value("${app.inventory.low-stock-threshold:50}")
    private Integer lowStockThreshold;

    @Override
    @Transactional
    public InventoryResponse createInventory( InventoryCreateRequest request) {

        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID : " + request.productId()));

        if(inventoryRepository.existsByProductId(product.getId())) {
            throw new DuplicateResourceException("Inventory already exists for the product ID : " + product.getId());
        }

        if(!product.isActive()) {
            throw new IllegalArgumentException("Cannot create inventory for an inactive product");
        }

        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setAvailableQuantity(request.availableQuantity());

        Inventory savedInventory = inventoryRepository.save(inventory);

        log.info("Inventory created successfully for the product ID : {}", product.getId());

        return inventoryMapper.toResponse(savedInventory);

    }

    @Override
    public InventoryResponse getInventoryById(Long inventoryId) {
        Inventory inventory = findInventoryById(inventoryId);
        return inventoryMapper.toResponse(inventory);
    }

    @Override
    public InventoryResponse getInventoryByProductId(Long productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for the product ID : " + productId));
        return inventoryMapper.toResponse(inventory);
    }

    @Override
    public List<InventoryResponse> getAllInventories() {
        return inventoryRepository.findAll()
                .stream()
                .map(inventoryMapper::toResponse)
                .toList();
    }

    @Override
    public Page<InventoryResponse> getAllAvailableInventories(Pageable pageable) {
        return inventoryRepository.findByAvailableQuantityGreaterThan(0, pageable).map(inventoryMapper::toResponse);
    }


    @Override
    public Page<InventoryResponse> getLowStockInventories(Integer quantity, Pageable pageable) {
        return inventoryRepository.findLowStockInventories(quantity, pageable).map(inventoryMapper::toResponse);
    }

    @Override
    @Transactional
    public InventoryResponse updateInventory(Long inventoryId, InventoryUpdateRequest request) {

        Inventory inventory = findInventoryById(inventoryId);
        inventory.setAvailableQuantity(request.availableQuantity());
        Inventory updatedInventory = inventoryRepository.save(inventory);
        log.info("Inventory updated successfully with the ID : {}", updatedInventory.getId());
        return inventoryMapper.toResponse(updatedInventory);

    }

    @Override
    @Transactional
    public InventoryResponse addStock(Long inventoryId, Integer quantity) {

        if(quantity==null || quantity<=0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }

        Inventory inventory = findInventoryById(inventoryId);
        inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
        Inventory updatedInventory = inventoryRepository.save(inventory);

        log.info("Stock added successfully. Inventory ID : {}, Quantity : {}", updatedInventory.getId(), quantity);

        return inventoryMapper.toResponse(updatedInventory);

    }

    @Override
    @Transactional
    public InventoryResponse reduceStock(Long productId, Integer quantity) {

        if(quantity==null || quantity<=0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }

        Inventory inventory = inventoryRepository.findByProductIdForUpdate(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for product ID : " + productId));

        if(inventory.getAvailableQuantity() < quantity) {
            throw new InsufficientStockException("Insufficient stock for product ID : " + productId
                    + ". Available Quantity : " + inventory.getAvailableQuantity());
        }

        inventory.setAvailableQuantity(inventory.getAvailableQuantity() - quantity);
        Inventory updatedInventory = inventoryRepository.save(inventory);

        log.info("Stock reduced successfully. Product ID : {}, Quantity : {}", productId, quantity);

        return inventoryMapper.toResponse(updatedInventory);

    }

    @Override
    @Transactional
    public void validateInventoryAvailability(Long productId, Integer requestedQuantity) {

        if(requestedQuantity==null || requestedQuantity<=0) {
            throw new InvalidOrderException("Requested quantity must be greater than zero");
        }

        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Inventory not found for product ID : " + productId
                        ));

        if(inventory.getAvailableQuantity()<requestedQuantity) {
            throw new InvalidOrderException(
                    "Insufficient inventory for product : "
                    + inventory.getProduct().getName()
                    + ". Available Quantity : "
                    + inventory.getAvailableQuantity()
                    + ", Requested Quantity : "
                    + requestedQuantity
            );
        }
    }

    @Override
    @Transactional
    public void reduceInventory(Long productId, Integer requestedQuantity) {
        Inventory inventory = inventoryRepository.findByProductIdForUpdate(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for Product ID : " + productId));
        if(requestedQuantity==null || requestedQuantity<=0) {
            throw new InvalidOrderException("Requested quantity must be > 0");
        }
        if(inventory.getAvailableQuantity()<requestedQuantity) {
            throw new InvalidOrderException(
                    "Insufficient inventory for product : "
                            + inventory.getProduct().getName()
                            + ". Available Quantity : "
                            + inventory.getAvailableQuantity()
                            + ", Requested Quantity : "
                            + requestedQuantity
            );
        }
        inventory.setAvailableQuantity(inventory.getAvailableQuantity()-requestedQuantity);
        inventoryRepository.save(inventory);
        log.info("Inventory reduced for Product ID {} by quantity {}", productId, requestedQuantity);
    }

    private Inventory findInventoryById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId).orElseThrow(() -> new ResourceNotFoundException("Inventory not found with ID : " + inventoryId));
    }

    @Override
    public void checkLowStock() {

        log.info("Starting low-stock check. Threshold : {}", lowStockThreshold);
        List<Inventory> lowStockInventories = inventoryRepository.findByAvailableQuantityLessThanEqual(lowStockThreshold);

        if(lowStockInventories.isEmpty()) {
            log.info("Low-stock check completed. No low-stock products found.");
            return;
        }

        for(Inventory inventory : lowStockInventories) {
            Product product = inventory.getProduct();
            if(!product.isActive()) {
                continue;
            }
            log.warn(
                    "LOW STOCK WARNING - Product : {}, Product ID : {}, Available Quantity : {}, Threshold : {}",
                    product.getName(), product.getId(), inventory.getAvailableQuantity(), lowStockThreshold
            );
        }

        log.info("Low-stock check completed. {} product(s) require attention.", lowStockInventories.size());
    }


}
