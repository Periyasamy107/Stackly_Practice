package com.example.order.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @NotNull(message = "customer id should not be null")
    private Integer customerId;

    @NotBlank(message = "customer name should not be blank")
    private String customerName;

    @Email(message = "email field should have the correct format")
    private String email;

    @NotEmpty(message = "product field should not be empty")
    private String productName;

    @NotNull(message = "price field should not be null")
    private Double price;

}
