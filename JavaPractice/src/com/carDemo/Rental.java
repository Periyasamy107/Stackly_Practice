package com.carDemo;

public class Rental {
    Car car;
    Customer customer;
    int days;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }
}

