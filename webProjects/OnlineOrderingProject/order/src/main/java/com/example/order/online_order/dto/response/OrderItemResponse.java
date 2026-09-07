package com.example.order.online_order.dto.response;

import java.math.BigDecimal;

public record OrderItemResponse (

        Long id,
        Long productId,
        String productName,
        Integer quantity,
        BigDecimal productPrice,
        BigDecimal totalPrice

) {}
