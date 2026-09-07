package com.example.order.payment.repository;

import com.example.order.payment.entity.Payment;
import com.example.order.payment.entity.PaymentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByOrderId(Long orderId);

    Optional<Payment> findByTransactionReference(String transactionReference);

    boolean existsByOrderId(Long orderId);

    Page<Payment> findByStatus(PaymentStatus status, Pageable pageable);

}
