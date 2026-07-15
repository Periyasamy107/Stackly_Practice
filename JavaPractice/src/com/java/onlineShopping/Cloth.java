package com.java.onlineShopping;

public class Cloth extends Product {
    int size;

    Cloth(int id, String name, double price, char size) {
        super(id, name, price);
        this.size = size;
    }

    void display(){
        super.display();
        System.out.println("Cloth Size : " + (char) size);
    }
}