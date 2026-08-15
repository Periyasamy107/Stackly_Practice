package com.demo.lombokExample1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private int customerId;
    private String customerName;
    private String city;
}
