package com.example.order.cart.dto.response;

import java.math.BigDecimal;

public record CartItemResponse (

        Long id,
        Long productId,
        String productName,
        BigDecimal productPrice,
        Integer quantity,
        BigDecimal totalPrice

) {}
