package com.example.order.online_order.dto.response;

import com.example.order.online_order.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse (

        Long id,
        Long customerId,
        String customerUserName,
        OrderStatus status,
        List<OrderItemResponse> items,
        Integer totalItems,
        BigDecimal totalAmount,
        LocalDateTime createdDate,
        String createdBy,
        LocalDateTime lastModifiedDate,
        String lastModifiedBy,
        Long version

) {}
