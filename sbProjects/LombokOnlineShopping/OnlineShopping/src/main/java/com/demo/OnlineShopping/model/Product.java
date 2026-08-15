package com.demo.OnlineShopping.model;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String productName;
    private String category;
    private double price;
}
