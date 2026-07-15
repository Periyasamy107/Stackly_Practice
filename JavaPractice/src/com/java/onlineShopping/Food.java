package com.java.onlineShopping;

public class Food extends Product {
    String expiryDate;

    Food(int id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    void display(){
        super.display();
        System.out.println("Expiry Date : " + expiryDate);
    }
}