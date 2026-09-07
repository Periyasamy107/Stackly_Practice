package com.example.order.payment.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PaymentRequest (
        @NotNull(message = "order id is required")
        @Positive(message = "order id cannot be negative")
        Long orderId
) {}
