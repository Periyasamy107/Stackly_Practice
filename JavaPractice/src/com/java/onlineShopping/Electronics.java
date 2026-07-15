package com.java.onlineShopping;

public class Electronics extends Product {
    int warrenty;

    Electronics(int id, String name, double price, int warrenty) {
        super(id, name, price);
        this.warrenty = warrenty;
    }

    void display(){
        super.display();
        System.out.println("Warrenty : " + warrenty);
    }
}
