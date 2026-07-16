package com.core.foodDelivery;

public class CommonShopLogic extends FoodBookingStatus implements FoodBooking, Foods, Distance {
    double tax;
    String shopName;

    CommonShopLogic(double tax, String shopName) {
        this.tax = tax;
        this.shopName = shopName;
    }

    public void bookFood() {
        System.out.println("\n------------------------------------------------------------");
        System.out.println(shopName + " shop food booking...");
    }

    public void bill(int quantity, double distance, int choice){
        double totalBill = 0.0;
        for(int i=0; i<=distances.length; i++) {
            if( (i+1) == distance ) {
                totalBill += (distance * distances[i]);
                System.out.println( "\n" + (i+1) + "KM distance = " + (distance * distances[i]));
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
        System.out.println("\n" + shopName + " shop Food Delivered successfully.");
    }

}

