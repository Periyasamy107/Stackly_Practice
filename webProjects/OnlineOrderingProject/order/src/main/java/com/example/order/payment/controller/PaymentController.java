package com.example.order.payment.controller;

import com.example.order.common.response.ApiResponse;
import com.example.order.payment.dto.request.PaymentRequest;
import com.example.order.payment.dto.response.PaymentResponse;
import com.example.order.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@Validated
@Tag(name = "Payment Service", description = "Payment service include processing payment and various types of retrieving endpoints")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @Operation(summary = "Process payment", description = "Process the payment by getting the necessary details")
    public ResponseEntity<ApiResponse<PaymentResponse>> processPayment(@Valid @RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(ApiResponse.success("Payment processed successfully", response));
    }

    @GetMapping("/{paymentId}")
    @Operation(summary = "get payment", description = "get payment by payment id")
    public ResponseEntity<ApiResponse<PaymentResponse>> getPaymentById(
            @PathVariable
            @Positive(message = "payment id must be > 0")
            Long paymentId
    ) {
        PaymentResponse response = paymentService.getPaymentById(paymentId);
        return ResponseEntity.ok(ApiResponse.success("payment retrieved successfully", response));
    }

    @GetMapping("/order/{orderId}")
    @Operation(summary = "Get payment", description = "Get payment by order id")
    public ResponseEntity<ApiResponse<PaymentResponse>> getPaymentByOrderId(
            @PathVariable
            @Positive(message = "Order ID must be greater than zero")
            Long orderId
    ) {
        PaymentResponse response = paymentService.getPaymentByOrderId(orderId);
        return ResponseEntity.ok(ApiResponse.success("Payement retrieved successfully", response));
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Get payments", description = "Get payments by their status")
    public ResponseEntity<ApiResponse<Page<PaymentResponse>>> getPaymentsByStatus(
            @PathVariable String status,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "1")
            @Positive(message = "page size cannot be zero")
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PaymentResponse> responses = paymentService.getPaymentsByStatus(status, pageable);
        return ResponseEntity.ok(ApiResponse.success("Payment retrieved successfully.", responses));
    }

}
