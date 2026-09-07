package com.example.order.customer.entity;

import com.example.order.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer extends BaseEntity {

    @NotBlank(message = "UserName is required")
    @Size(min=3, max = 50, message = "username must contains letter between 3 to 50")
    @Column(nullable = false, unique = true, length = 50)
    private String userName;

    @NotBlank(message = "Password is required")
    @Size(min=6, max=50, message = "password must contain between 6 to 50 characters")
    @Column(nullable = false, length = 50)
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = false, length = 100)
    private String email;

    @NotBlank(message = "Full name is required")
    @Size(min=3, max = 50, message = "full name must contains between 3 to 50 characters")
    @Column(nullable = false, length = 50)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CustomerStatus status = CustomerStatus.ACTIVE;

}
