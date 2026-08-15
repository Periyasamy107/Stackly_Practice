package com.demo.lombokExample1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private int orderId;
    private String foodItem;
    private double amount;

    private Customer customer;
    private Restaurant restaurant;
}
