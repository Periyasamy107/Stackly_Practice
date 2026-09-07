package com.example.order.inventory.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record InventoryCreateRequest (

        @NotNull(message = "Product ID is required")
        @Positive(message = "Product ID must be > 0")
        Long productId,

        @NotNull(message = "Available quantity is required")
        @Min(value = 0, message = "Available quantity cannot be negative")
        Integer availableQuantity

){}
