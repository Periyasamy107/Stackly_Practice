package com.core.cabBooking;

public class MiniCab extends CabBookingStatus implements CabBooking {

    public static final int oneKM = 50;
    public static final int onePointFiveKM = 80;
    public static final int twoKM = oneKM * 2;
    public static final int twoPointFiveKM = oneKM + onePointFiveKM;
    public static final int threeKM = 3 * oneKM;
    public static final int threePointFiveKM = twoPointFiveKM + oneKM;
    public static final int fourKM = 4 * oneKM;
    public static final int fourPointFiveKM = threePointFiveKM + oneKM;
    public static final int fiveKM = 5 * oneKM;

    public void bookRide(){
        System.out.println("Mini Cab booking...");
    }

    public void calculateFair(double distance) {
        if (distance > 0 && distance <= 1) {
            System.out.println("1 KM distance fair : " + (distance * oneKM));
        } else if (distance <= 1.5) {
            System.out.println("1.5 KM distance fair : " + (distance * onePointFiveKM));
        } else if (distance <= 2) {
            System.out.println("2 KM distance fair : " + (distance * twoKM));
        } else if (distance <= 2.5) {
            System.out.println("2.5 KM distance fair : " + (distance * twoPointFiveKM));
        } else if (distance <= 3) {
            System.out.println("3 KM distance fair : " + (distance * threeKM));
        } else if (distance <= 3.5) {
            System.out.println("3.5 KM distance fair : " + (distance * threePointFiveKM));
        } else if (distance <= 4) {
            System.out.println("4 KM distance fair : " + (distance * fourKM));
        } else if (distance <= 4.5) {
            System.out.println("4.5 KM distance fair : " + (distance * fourPointFiveKM));
        } else if (distance <= 5) {
            System.out.println("5 KM distance fair : " + (distance * fiveKM));
        }
    }

    @Override
    public void bookingStatus() {
        System.out.println("Mini Cab Booked Successfully.");
    }

}
