package com.example.order.customer.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerUpdateRequest (

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "FullName is required")
        @Size(min=3, max=50, message = "Full Name must contain 3 to 50 characters")
        String fullName

){}
