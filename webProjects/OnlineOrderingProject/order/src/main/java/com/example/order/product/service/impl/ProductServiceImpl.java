package com.example.order.product.service.impl;

import com.example.order.common.exception.DuplicateResourceException;
import com.example.order.common.exception.ResourceNotFoundException;
import com.example.order.product.dto.request.ProductCreateRequest;
import com.example.order.product.dto.request.ProductUpdateRequest;
import com.example.order.product.dto.response.ProductResponse;
import com.example.order.product.entity.Product;
import com.example.order.product.entity.ProductCategory;
import com.example.order.product.mapper.ProductMapper;
import com.example.order.product.repository.ProductRepository;
import com.example.order.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;


    @Override
    @Transactional
    public ProductResponse createProduct(ProductCreateRequest request) {

        String productName = request.name().trim();

        if(repository.existsByNameIgnoreCase(productName)) {
            throw new DuplicateResourceException("Product with the same name already exists");
        }

        Product product = mapper.toEntity(request);

        product.setName(productName);
        product.setDescription(request.description()==null ? null : request.description().trim());
        product.setPrice(request.price());
        product.setCategory(request.category());
        product.setActive(true);

        Product savedProduct = repository.save(product);

        log.info("Product created successfully with the ID : {}", savedProduct.getId());

        return mapper.toResponse(savedProduct);

    }

    @Override
    public ProductResponse getProductById(Long productId) {
        Product product = findProductById(productId);
        return mapper.toResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> getAllActiveProducts() {
        return repository.findByActiveTrue().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(Long productId, ProductUpdateRequest request) {

        Product product = findProductById(productId);

        String productName = request.name().trim();

        repository.findByNameIgnoreCase(productName)
                .ifPresent(existingProduct -> {
                    if(!existingProduct.getId().equals(productId)){
                        throw new DuplicateResourceException("Product with the same name already exists");
                    }
                });

        product.setName(productName);
        product.setDescription(request.description()!=null ? request.description().trim() : null);
        product.setCategory(request.category());
        product.setPrice(request.price());
        product.setActive(request.active());

        Product updatedProduct = repository.save(product);

        log.info("Product updated successfully with the ID : {}", updatedProduct.getId());

        return mapper.toResponse(updatedProduct);

    }

    @Override
    @Transactional
    public ProductResponse updateProductStatus(Long productId, boolean active) {
        Product product = findProductById(productId);
        product.setActive(active);
        Product updateProduct = repository.save(product);
        log.info("Product status updated successfully for the ID : {}", updateProduct.getId());
        return mapper.toResponse(updateProduct);
    }

    @Override
    public Page<ProductResponse> getActiveProducts(Pageable pageable) {
        return repository.findByActiveTrue(pageable).map(mapper::toResponse);
    }

    @Override
    public Page<ProductResponse> searchProductsByName(String name, Pageable pageable) {
        return repository.searchActiveProductsByName(name.trim(), pageable).map(mapper::toResponse);
    }

    @Override
    public Page<ProductResponse> searchAllProductsByName(String name, Pageable pageable) {
        return repository.searchAllProductsByName(name.trim(), pageable).map(mapper::toResponse);
    }

    @Override
    public Page<ProductResponse> getProductsByCategory(ProductCategory category, Pageable pageable) {
        return repository.findByCategoryAndActiveTrue(category,pageable).map(mapper::toResponse);
    }

    @Override
    public Page<ProductResponse> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable) {
        if(minPrice.compareTo(maxPrice) > 0) {
            throw new IllegalArgumentException("Minimum price cannot be greater than maximum price");
        }
        return repository.findActiveProductsByPriceRange(minPrice, maxPrice, pageable).map(mapper::toResponse);
    }

    @Override
    public Page<ProductResponse> getProductsByCategoryNative(ProductCategory category, Pageable pageable) {
        return repository.findActiveProductsByCategoryNative(category.name(), pageable).map(mapper::toResponse);
    }

    private Product findProductById(Long productId) {
        return repository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found with the ID: " + productId));
    }
}
