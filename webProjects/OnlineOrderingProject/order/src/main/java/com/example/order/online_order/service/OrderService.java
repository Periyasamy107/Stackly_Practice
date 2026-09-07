package com.example.order.online_order.service;

import com.example.order.online_order.dto.request.CreateOrderRequest;
import com.example.order.online_order.dto.response.OrderResponse;
import com.example.order.online_order.entity.OrderStatus;
import com.example.order.online_order.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    OrderResponse placeOrder(CreateOrderRequest request);

//    OrderResponse createOrder(CreateOrderRequest request);

    OrderResponse getOrderById(Long orderId);

    List<OrderResponse> getOrdersByCustomerId(Long customerId);

    Page<OrderResponse> getOrdersByCustomerId(Long customerId, Pageable pageable);

    Page<OrderResponse> getOrdersByStatus(OrderStatus status, Pageable pageable);

    Page<OrderResponse> getOrdersByCustomerAndStatus(Long customerId, OrderStatus status, Pageable pageable);

    Page<OrderResponse> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    Page<OrderResponse> getCustomerOrdersNative(Long customerId, String status, Pageable pageable);

}
