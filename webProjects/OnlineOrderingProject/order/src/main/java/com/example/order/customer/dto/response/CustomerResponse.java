package com.example.order.customer.dto.response;

import com.example.order.common.entity.BaseEntity;
import com.example.order.customer.entity.CustomerStatus;

import java.time.LocalDateTime;

public record CustomerResponse (

        Long id,
        String userName,
        String email,
        String fullName,
        CustomerStatus status,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        Long version

){}
