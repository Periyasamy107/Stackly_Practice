package com.example.order.customer.dto.request;

import com.example.order.validation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerRegistrationRequest (

        @NotBlank(message = "UserName is required")
        @Size(min=3, max=50, message = "UserName must contain between 3 to 50 characters")
        String userName,

        @NotBlank(message = "Password is required")
        @ValidPassword
        String password,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "FullName is required")
        @Size(min=3, max=50, message = "FullName must contain between 3 to 50 characters")
        String fullName

) {}
