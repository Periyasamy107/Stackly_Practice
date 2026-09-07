package com.example.order.customer.dto.request;

import com.example.order.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;

public record CustomerLoginRequest (

        @NotBlank(message = "UserName is required")
        String userName,

        @NotBlank(message = "Password is required")
        String password

) { }
