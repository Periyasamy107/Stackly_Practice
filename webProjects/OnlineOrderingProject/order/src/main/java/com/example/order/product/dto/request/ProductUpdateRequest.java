package com.example.order.product.dto.request;

import com.example.order.product.entity.ProductCategory;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductUpdateRequest (

        @NotBlank(message = "product name is required for update.")
        @Size(min=3, max=100, message = "Characters between 3 to 100 only allowed.")
        String name,

        @Size(max=1000, message = "Should not exceed 1000 chars.")
        String description,

        @NotNull(message = "Product price is required for update")
        @DecimalMin(value = "0.01", message = "Product price should be greater than zero for update.")
        BigDecimal price,

        @NotNull(message = "Product category is required for update.")
        ProductCategory category,

        @NotNull(message = "Product active status is required for update.")
        Boolean active

){}
