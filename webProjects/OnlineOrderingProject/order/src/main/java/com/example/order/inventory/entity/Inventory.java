package com.example.order.inventory.entity;

import com.example.order.common.entity.BaseEntity;
import com.example.order.product.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventory", uniqueConstraints = {@UniqueConstraint(name = "uk_inventory_product", columnNames = "product_id")})
@Getter
@Setter
@NoArgsConstructor
public class Inventory extends BaseEntity {

    @NotNull(message = "Product is required")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    @NotNull(message = "Available quantity is required")
    @Min(value = 0, message = "Available quantity cannot be negative")
    @Column(nullable = false)
    private Integer availableQuantity = 0;

}
