package com.example.order.product.controller;

import com.example.order.common.response.ApiResponse;
import com.example.order.product.dto.request.ProductCreateRequest;
import com.example.order.product.dto.request.ProductUpdateRequest;
import com.example.order.product.dto.response.ProductResponse;
import com.example.order.product.entity.ProductCategory;
import com.example.order.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Validated
@Tag(name = "Product Service", description = "Product service contain CRUD operations")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @Operation(summary = "Add new Product", description = "Add new product by getting the necessary details")
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@Valid @RequestBody ProductCreateRequest request) {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Product created Successfully.", response));
    }

    @GetMapping("/{productId}")
    @Operation(summary = "Get product", description = "Get product by their id")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(@PathVariable @Positive(message = "Product ID must be greater than zero") Long productId) {
        ProductResponse response = productService.getProductById(productId);
        return ResponseEntity.ok(ApiResponse.success("Product retrieved successfully.", response));
    }

    @GetMapping
    @Operation(summary = "Get Products", description = "Get all products without checking any condition")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts() {
        List<ProductResponse> responses = productService.getAllProducts();
        return ResponseEntity.ok(ApiResponse.success("Products retrieved successfully.", responses));
    }

    @GetMapping("/active")
    @Operation(summary = "Get Products (active)", description = "Get all active products only.")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllActiveProducts() {
        List<ProductResponse> responses = productService.getAllActiveProducts();
        return ResponseEntity.ok(ApiResponse.success("Active Products Retrieved Successfully.", responses));
    }

    @PutMapping("/{productId}")
    @Operation(summary = "Update an product", description = "Update an old product with new details")
    public ResponseEntity<ApiResponse<ProductResponse>> updateProduct(
            @PathVariable
            @Positive(message = "Product ID must be greater than zero")
            Long productId,

            @Valid @RequestBody ProductUpdateRequest request
            ) {

        ProductResponse response = productService.updateProduct(productId, request);
        return ResponseEntity.ok(ApiResponse.success("Product updated successfully.", response));
    }

    @PatchMapping("/{productId}/status")
    @Operation(summary = "Update Product (status)", description = "Update the product status alone (partial)")
    public ResponseEntity<ApiResponse<ProductResponse>> updateProductStatus(
            @PathVariable @Positive(message = "Product ID must be greater than zero") Long productId,
            @RequestParam boolean active
    ) {

        ProductResponse response = productService.updateProductStatus(productId, active);
        return ResponseEntity.ok(ApiResponse.success("Product status updated successfully.", response));

    }

    @GetMapping("/page")
    @Operation(summary = "Active products", description = "Get all active products with pagination")
    public ResponseEntity<ApiResponse<Page<ProductResponse>>> getActiveProductsWithPaging(
            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "5")
            @Positive(message = "Page size must be greater than zero")
            int size,

            @RequestParam(defaultValue = "id")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction
    ) {

        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

        Page<ProductResponse> responses = productService.getActiveProducts(pageable);
        return ResponseEntity.ok(ApiResponse.success("Products retrieved successfully.", responses));

    }

    @GetMapping("/search")
    @Operation(summary = "search product", description = "Searching the product based on the product name")
    public ResponseEntity<ApiResponse<Page<ProductResponse>>> searchProducts(
            @RequestParam
            @NotBlank(message = "Product name cannot be blank")
            String name,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "5")
            @Positive(message = "Page size must be greater than zero")
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ProductResponse> responses = productService.searchProductsByName(name, pageable);
        return ResponseEntity.ok(ApiResponse.success("Products retrieved successfully", responses));

    }

    @GetMapping("/category/{category}")
    @Operation(summary = "Get products", description = "Get products based on the category filter")
    public ResponseEntity<ApiResponse<Page<ProductResponse>>> getProductsByCategory(
            @PathVariable ProductCategory category,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "5")
            @Positive(message = "Page size must be greater than zero")
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ProductResponse> responses = productService.getProductsByCategory(category, pageable);
        return ResponseEntity.ok(ApiResponse.success("Products retrieved successfully.", responses));

    }

    @GetMapping("/price-range")
    @Operation(summary = "get products", description = "Get all products for a specific price range")
    public ResponseEntity<ApiResponse<Page<ProductResponse>>> getProductsByPriceRange(
            @RequestParam
            @DecimalMin(value = "0.00", message = "Minimum price cannot be negative")
            BigDecimal minPrice,

            @RequestParam
            @DecimalMin(value = "0.01", message = "Maximum price must be greater than zero")
            BigDecimal maxPrice,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "5")
            @Positive(message = "Page size must be greater than zero")
            int size,

            @RequestParam(defaultValue = "price")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction
    ) {

        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        Page<ProductResponse> responses = productService.getProductsByPriceRange(minPrice, maxPrice, pageable);
        return ResponseEntity.ok(ApiResponse.success("Products retrieved successfully.", responses));

    }

    @GetMapping("/native/category/{category}")
    @Operation(summary = "Get products", description = "Get all products by category filter based")
    public ResponseEntity<ApiResponse<Page<ProductResponse>>> getProductsByCategoryNative(
            @PathVariable ProductCategory category,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "5")
            @Positive(message = "page number must be > 0")
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ProductResponse> responses = productService.getProductsByCategoryNative(category, pageable);
        return ResponseEntity.ok(ApiResponse.success("Products Retrieved Successfully", responses));

    }



}
