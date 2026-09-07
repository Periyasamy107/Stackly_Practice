package com.example.order.payment.entity;

import com.example.order.common.entity.BaseEntity;
import com.example.order.online_order.entity.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "payments",
    uniqueConstraints = {@UniqueConstraint(
       name = "uk_payment_order",
       columnNames = "order_id"
    )})
@Getter
@Setter
@NoArgsConstructor
public class Payment extends BaseEntity {

    @NotNull(message = "Order is required")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Payment cannot be negative")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @NotNull(message = "Payment status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private PaymentStatus status;

    @Column(name = "transaction_reference", nullable = false, unique = true, length = 100)
    private String transactionReference;

    @Column(length = 500)
    private String failureReason;


}
