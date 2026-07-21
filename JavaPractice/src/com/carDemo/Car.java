package com.carDemo;

public class Car {
    int carId;
    String brand;
    double rentPerDay;
    boolean isAvailable;

    public Car(int carId, String brand, double rentPerDay) {
        this.carId = carId;
        this.brand = brand;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
    }
}

