package com.example.order.cart.entity;

import com.example.order.common.entity.BaseEntity;
import com.example.order.product.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cart_items", uniqueConstraints = {@UniqueConstraint(name = "uk_cart_product", columnNames = {"cart_id", "product_id"})})
@Getter
@Setter
@NoArgsConstructor
public class CartItem extends BaseEntity {

    @NotNull(message = "Cart is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @NotNull(message = "Product is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be > 0")
    @Column(nullable = false)
    private Integer quantity;

}
