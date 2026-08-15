package com.demo.OnlineShopping.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private String orderId;
    private Customer customer;
    private Product product;
    private int quantity;
    private double totalAmount;
}
