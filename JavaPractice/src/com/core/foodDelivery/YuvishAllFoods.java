package com.core.foodDelivery;

public class YuvishAllFoods extends FoodBookingStatus implements FoodBooking, Foods, Distance {

    public static final double tax = 0.35;

    public void bookFood() {
        System.out.println("\n------------------------------------------------------------");
        System.out.println("Yuvish All Foods shop food booking...");
    }

    public void bill(int quantity, double distance, int choice){
        double totalBill = 0.0;
        for(int i=0; i<=distances.length; i++) {
            if( (i+1) == distance ) {
                totalBill += (distance * distances[i]);
                System.out.println( (i+1) + "KM distance = " + (distance * distances[i]));
            }
        }

        for(int i=0; i<=foods.length; i++) {
            if( (i+1) == choice ) {
                totalBill += (choice * foods[i]);
                System.out.println("Food charge = " + (choice * foods[i]));
            }
        }

        System.out.println("Overall Total Bill = " + (totalBill + (totalBill*tax)));
    }

    @Override
    public void status() {
        System.out.println("\nYuvish all Foods shop Food Delivered successfully.");
    }

}
