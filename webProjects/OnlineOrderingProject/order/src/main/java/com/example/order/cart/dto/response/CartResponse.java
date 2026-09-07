package com.example.order.cart.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record CartResponse (

        Long id,
        Long customerId,
        String customerUserName,
        List<CartItemResponse> items,
        Integer totalItems,
        BigDecimal totalAmount,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        Long version

) {}
