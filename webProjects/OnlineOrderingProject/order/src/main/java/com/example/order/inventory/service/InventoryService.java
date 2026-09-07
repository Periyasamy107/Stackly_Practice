package com.example.order.inventory.service;

import com.example.order.inventory.dto.request.InventoryCreateRequest;
import com.example.order.inventory.dto.request.InventoryUpdateRequest;
import com.example.order.inventory.dto.response.InventoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InventoryService {

    InventoryResponse createInventory(InventoryCreateRequest request);

    InventoryResponse getInventoryById(Long inventoryId);

    InventoryResponse getInventoryByProductId(Long productId);

    List<InventoryResponse> getAllInventories();

    Page<InventoryResponse> getAllAvailableInventories(Pageable pageable);

    Page<InventoryResponse> getLowStockInventories(Integer quantity, Pageable pageable);

    InventoryResponse updateInventory(Long inventoryId, InventoryUpdateRequest request);

    InventoryResponse addStock(Long inventoryId, Integer quantity);

    InventoryResponse reduceStock(Long productId, Integer quantity);

    void validateInventoryAvailability(Long productId, Integer requestedQuantity);

    void reduceInventory(Long productId, Integer requestedQuantity);

    void checkLowStock();

}
