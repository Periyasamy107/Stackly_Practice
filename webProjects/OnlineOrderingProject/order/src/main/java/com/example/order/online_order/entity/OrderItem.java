package com.example.order.online_order.entity;

import com.example.order.common.entity.BaseEntity;
import com.example.order.product.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items",
       uniqueConstraints = { @UniqueConstraint(
               name = "uk_order_payment",
               columnNames = {"order_id", "product_id"}
       )})
@Getter
@Setter
@NoArgsConstructor
public class OrderItem extends BaseEntity {

    @NotNull(message = "Order is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @NotNull(message = "Product is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than zero")
    @Column(nullable = false)
    private Integer quantity;

    @NotNull(message = "product price is required")
    @DecimalMin(value = "0.01", message = "product price must be > 0")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal productPrice;

    @NotNull(message = "total price is required")
    @DecimalMin(value = "0.01", message = "total price must be > 0")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal totalPrice;

}
