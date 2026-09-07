package com.example.order.payment.dto.response;

import com.example.order.payment.entity.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResponse (

        Long id,
        Long orderId,
        BigDecimal amount,
        PaymentStatus status,
        String transactionReference,
        String failureReason,
        LocalDateTime createdDate,
        String createdBy,
        LocalDateTime lastModifiedDate,
        String lastModifiedBy,
        Long version

) {}
