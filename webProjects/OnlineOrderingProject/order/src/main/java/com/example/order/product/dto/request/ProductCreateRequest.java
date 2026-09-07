package com.example.order.product.dto.request;

import com.example.order.product.entity.ProductCategory;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductCreateRequest (

        @NotBlank(message = "Product name is required")
        @Size(min=3, max=100, message = "Product name must contain between 3 to 100 characters")
        String name,

        @Size(max = 1000, message = "Product description cannot exceed 1000 characters")
        String description,

        @NotNull(message = "Product price is required")
        @DecimalMin(value = "0.01", message = "Product price must be greater than zero")
        BigDecimal price,

        @NotNull(message = "Product category is required")
        ProductCategory category

) {}
