package com.demo.LombokBankAccount.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private String customerId;
    private String customerName;
    private String city;
}
