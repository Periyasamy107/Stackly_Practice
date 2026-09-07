package com.example.order.product.dto.response;

import com.example.order.product.entity.ProductCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponse (

        Long id,
        String name,
        String description,
        BigDecimal price,
        ProductCategory category,
        boolean active,
        LocalDateTime createdDate,
        String createdBy,
        LocalDateTime lastModifiedDate,
        String lastModifiedBy,
        Long version

) {}
