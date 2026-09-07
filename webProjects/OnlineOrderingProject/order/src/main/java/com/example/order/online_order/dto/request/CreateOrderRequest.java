package com.example.order.online_order.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOrderRequest (

        @NotNull(message = "customer id is required")
        @Positive(message = "customer id must be greater than zero")
        Long customerId

) {}
