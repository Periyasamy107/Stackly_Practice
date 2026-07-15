package com.java.oops;

class CarRent {
    public void rent(int hour) {
        System.out.println(hour + " hour rent is : " + (hour * 20));
    }

    public void rent(long days) {
        System.out.println(days + " days rent is : " + (days * 60 * 20));
    }

    public void rent(int days, boolean driver){
        if(driver) {
            System.out.println("Driver need");
        } else {
            System.out.println("No need the driver");
        }
        System.out.println(days + " days rent is : " + (days * 60 * 20));
    }
}

public class CarRentForMethodOverloading {
    public static void main(String[] args) {

        CarRent carRent = new CarRent();

        System.out.println("==============================================");
        System.out.println("CAR RENT PROGRAM BASED ON METHOD OVERLOADING");
        System.out.println("==============================================");
        System.out.println();

        System.out.println("Hour based rent calculation : ");
        carRent.rent(4);
        System.out.println();

        System.out.println("Days based rent calculation : ");
        carRent.rent(2L);
        System.out.println();

        System.out.println("Driver + Days based rent calculation : ");
        carRent.rent(5,true);
        System.out.println();

        System.out.println("----------------------------------------------");

    }
}
