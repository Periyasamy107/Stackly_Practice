package com.example.order.payment.service.impl;

import com.example.order.common.exception.InvalidOrderException;
import com.example.order.common.exception.ResourceNotFoundException;
import com.example.order.online_order.entity.Order;
import com.example.order.online_order.repository.OrderRepository;
import com.example.order.payment.dto.request.PaymentRequest;
import com.example.order.payment.dto.response.PaymentResponse;
import com.example.order.payment.entity.Payment;
import com.example.order.payment.entity.PaymentStatus;
import com.example.order.payment.mapper.PaymentMapper;
import com.example.order.payment.repository.PaymentRepository;
import com.example.order.payment.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final PaymentMapper paymentMapper;

    @Override
//    @Transactional
    public PaymentResponse processPayment(PaymentRequest request) {

        Order order = orderRepository.findById(request.orderId())
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id : " + request.orderId()));

        return processPaymentForTransaction(order);

    }

    @Override
    public PaymentResponse getPaymentById(Long paymentId) {
        Payment payment = findPaymentById(paymentId);
        return paymentMapper.toResponse(payment);
    }

    @Override
    public PaymentResponse getPaymentByOrderId(Long orderId) {
        Payment payment = paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found for Order ID : " + orderId));
        return paymentMapper.toResponse(payment);
    }

    @Override
    public Page<PaymentResponse> getPaymentsByStatus(String status, Pageable pageable) {
        PaymentStatus paymentStatus;
        try{
            paymentStatus = PaymentStatus.valueOf(status.trim().toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new InvalidOrderException("Invalid payment status : " + status);
        }
        return paymentRepository.findByStatus(paymentStatus, pageable).map(paymentMapper::toResponse);
    }

    @Override
    @Transactional
    public PaymentResponse processPaymentForTransaction(Order order) {
        if(order==null || order.getId()==null) {
            throw new InvalidOrderException("Invalid order for payment");
        }
        if(order.getTotalAmount()==null || order.getTotalAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidOrderException("Order amount must be greater than zero");
        }
        if(paymentRepository.existsByOrderId(order.getId())) {
            throw new InvalidOrderException("Payment already exists for Order ID : " + order.getId());
        }

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(order.getTotalAmount());
        payment.setStatus(PaymentStatus.PROCESSING);
        payment.setTransactionReference(generateTransactionReference());

        payment = paymentRepository.save(payment);

        boolean paymentSuccessful = processDummyPayment(order);
        if(!paymentSuccessful) {
            throw new InvalidOrderException("Dummy payment failed for Order ID : " + order.getId());
        }

        payment.setStatus(PaymentStatus.SUCCESS);
        payment.setFailureReason(null);

        Payment successfulPayment = paymentRepository.saveAndFlush(payment);

        log.info("Dummy payment success for Order ID " + order.getId());

        return paymentMapper.toResponse(successfulPayment);
    }

    private Payment findPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with payment id : " + paymentId));
    }

    private boolean processDummyPayment(Order order) {
        log.info("Process dummy payment for Order ID : {}, amount : {}", order.getId(), order.getTotalAmount());
        return true;
    }

    private String generateTransactionReference() {
        return "TXN-" + UUID.randomUUID().toString().replace("-","").substring(0,16).toUpperCase();
    }


}
