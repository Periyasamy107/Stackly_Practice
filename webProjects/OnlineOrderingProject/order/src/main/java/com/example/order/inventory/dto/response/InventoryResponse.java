package com.example.order.inventory.dto.response;

import java.time.LocalDateTime;

public record InventoryResponse (

        Long id,
        Long productId,
        String productName,
        Integer availableQuantity,
        LocalDateTime createdDate,
        String createdBy,
        LocalDateTime lastModifiedDate,
        String lastModifiedBy,
        Long version

) {}
