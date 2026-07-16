package com.core.foodDelivery;

public class SamyBhavan extends FoodBookingStatus implements FoodBooking, Foods, Distance {
    public static final double tax = 0.10;

    public void bookFood() {
        System.out.println("\n------------------------------------------------------------");
        System.out.println("Samy bhavan food booking...");
    }

    public void bill(int quantity, double distance, int choice){
        double totalBill = 0.0;
        for(int i=0; i<distances.length; i++) {
            if( (i+1) == distance ) {
                totalBill += (distance * distances[i]);
                System.out.println(i+"KM distance = " + (distance * distances[i]));
            }
        }

        for(int i=0; i< foods.length; i++) {
            if( (i+1) == choice ) {
                totalBill += (choice * foods[i]);
                System.out.println("Food charge = " + (choice * foods[i]));
            }
        }

        System.out.println("Overall Total Bill = " + (totalBill + tax));
    }

    @Override
    public void status() {
        System.out.println("\nSamy Bhavan Food Delivered successfully.");
    }
}
