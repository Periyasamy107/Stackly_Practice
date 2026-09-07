package com.example.order.online_order.controller;

import com.example.order.common.response.ApiResponse;
import com.example.order.online_order.dto.request.CreateOrderRequest;
import com.example.order.online_order.dto.response.OrderResponse;
import com.example.order.online_order.entity.OrderStatus;
import com.example.order.online_order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Validated
@Tag(name = "Order Service", description = "This is the main service which coordinates all other services")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @Operation(summary = "Place Order", description = "Placing an order by getting the necessary details")
    public ResponseEntity<ApiResponse<OrderResponse>> placeOrder(
            @Valid @RequestBody
            CreateOrderRequest request
    ) {

        OrderResponse response = orderService.placeOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Order placed and confirmed successfully", response));
    }

//    @PostMapping
//    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@Valid @RequestBody CreateOrderRequest request) {
//        OrderResponse response = orderService.createOrder(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Order created successfully", response));
//    }

    @GetMapping("/{orderId}")
    @Operation(summary = "Get order", description = "Single order retrieving by getting the order id as an input")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrderById(
            @PathVariable
            @Positive(message = "Order ID must be > 0")
            Long orderId
    ) {
        OrderResponse response = orderService.getOrderById(orderId);
        return ResponseEntity.ok(ApiResponse.success("Order retrieved successfully", response));
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Get orders", description = "Get orders by customer id")
    public ResponseEntity<ApiResponse<List<OrderResponse>>> getOrdersByCustomerId(
            @PathVariable
            @Positive(message = "Customer ID must be greater than zero")
            Long customerId
    ) {
        List<OrderResponse> responses = orderService.getOrdersByCustomerId(customerId);
        return ResponseEntity.ok(ApiResponse.success("Customer orders retrieved successfully", responses));
    }

    @GetMapping("/customer/{customerId}/page")
    @Operation(summary = "Get orders", description = "Get orders by customer id with pagination")
    public ResponseEntity<ApiResponse<Page<OrderResponse>>> getOrdersByCustomerIdWithPaging(
            @PathVariable
            @Positive(message = "Customer ID must be > 0")
            Long customerId,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "3")
            @Positive(message = "Page size must be > 0")
            int size,

            @RequestParam(defaultValue = "createdDate")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction
    ) {
        Pageable pageable = createPageable(page, size, sortBy, direction);
        Page<OrderResponse> responses = orderService.getOrdersByCustomerId(customerId, pageable);
        return ResponseEntity.ok(ApiResponse.success("Customer orders retrieved success.", responses));
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Get Orders", description = "Get orders by the status")
    public ResponseEntity<ApiResponse<Page<OrderResponse>>> getOrdersByStatus(
            @PathVariable
            OrderStatus status,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "2")
            @Positive(message = "page size must be greater than zero")
            int size,

            @RequestParam(defaultValue = "createdDate")
            String sortBy,

            @RequestParam(defaultValue = "desc")
            String direction
    ) {
        Pageable pageable = createPageable(page, size, sortBy, direction);
        Page<OrderResponse> responses = orderService.getOrdersByStatus(status, pageable);
        return ResponseEntity.ok(ApiResponse.success("Orders retrieved by status successfully.", responses));
    }

    @GetMapping("/customer/{customerId}/status/{status}")
    @Operation(summary = "Get orders", description = "get orders by customer and status")
    public ResponseEntity<ApiResponse<Page<OrderResponse>>> getOrdersByCustomerAndStatus(
            @PathVariable
            @Positive(message = "CustomerId cannot be negative")
            Long customerId,

            @PathVariable OrderStatus status,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "7")
            @Positive(message = "Page size must be > 0")
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<OrderResponse> responses = orderService.getOrdersByCustomerAndStatus(customerId, status, pageable);
        return ResponseEntity.ok(ApiResponse.success("Orders retrieved by customer and status successfully.", responses));
    }

    @GetMapping("/date-range")
    @Operation(summary = "date range based orders", description = "get all orders based on the date range")
    public ResponseEntity<ApiResponse<Page<OrderResponse>>> getOrdersByDateRange(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime startDate,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endDate,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "6")
            @Positive(message = "page size must be > 0")
            int size,

            @RequestParam(defaultValue = "createdDate")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction
    ) {
        Pageable pageable = createPageable(page, size, sortBy, direction);
        Page<OrderResponse> responses = orderService.getOrdersByDateRange(startDate, endDate, pageable);
        return ResponseEntity.ok(ApiResponse.success("Orders retrieved by date range success", responses));
    }

    @GetMapping("/native/customer/{customerId}/status/{status}")
    @Operation(summary = "Get orders by native", description = "Get orders by customer using native query")
    public ResponseEntity<ApiResponse<Page<OrderResponse>>> getCustomerOrdersNative(
            @PathVariable
            @Positive(message = "customer id cannot be negative")
            Long customerId,

            @PathVariable String status,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be zero")
            int page,

            @RequestParam(defaultValue = "2")
            @Positive(message = "page size must be > 0")
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<OrderResponse> responses = orderService.getCustomerOrdersNative(customerId, status, pageable);
        return ResponseEntity.ok(ApiResponse.success("Orders retrieved successfully", responses));
    }

    private Pageable createPageable(int page, int size, String sortBy, String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
    }

}
