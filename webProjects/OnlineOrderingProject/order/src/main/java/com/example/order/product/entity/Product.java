package com.example.order.product.entity;

import com.example.order.common.entity.BaseEntity;
import com.example.order.inventory.entity.Inventory;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.nio.channels.FileLock;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity {

    @NotBlank(message = "Product name is required")
    @Size(min=3, max=100, message = "Product name must contain between 3 to 100 characters")
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Size(max=1000, message = "Product description cannot exceed 1000 characters")
    @Column(length = 1000)
    private String description;

    @NotNull(message = "Product price is required")
    @DecimalMin(value = "0.01", message = "Product price must be greater than zero")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    @NotNull(message = "Product category is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private ProductCategory category;

    @Column(nullable = false)
    private boolean active = true;

    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Inventory inventory;

}
