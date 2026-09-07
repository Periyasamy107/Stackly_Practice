package com.example.order.payment.service;

import com.example.order.online_order.entity.Order;
import com.example.order.payment.dto.request.PaymentRequest;
import com.example.order.payment.dto.response.PaymentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface PaymentService {

    PaymentResponse processPayment(PaymentRequest request);

    PaymentResponse getPaymentById(Long paymentId);

    PaymentResponse getPaymentByOrderId(Long orderId);

    Page<PaymentResponse> getPaymentsByStatus(String status, Pageable pageable);

    PaymentResponse processPaymentForTransaction(Order order);

}
