package com.example.order.product.service;

import com.example.order.product.dto.request.ProductCreateRequest;
import com.example.order.product.dto.request.ProductUpdateRequest;
import com.example.order.product.dto.response.ProductResponse;
import com.example.order.product.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductCreateRequest request);

    ProductResponse getProductById(Long productId);

    List<ProductResponse> getAllProducts();

    List<ProductResponse> getAllActiveProducts();

    ProductResponse updateProduct(Long productId, ProductUpdateRequest request);

    ProductResponse updateProductStatus(Long productId, boolean active);

    Page<ProductResponse> getActiveProducts(Pageable pageable);

    Page<ProductResponse> searchProductsByName(String name, Pageable pageable);

    Page<ProductResponse> searchAllProductsByName(String name, Pageable pageable);

    Page<ProductResponse> getProductsByCategory(ProductCategory category, Pageable pageable);

    Page<ProductResponse> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);

    Page<ProductResponse> getProductsByCategoryNative(ProductCategory category, Pageable pageable);

}
