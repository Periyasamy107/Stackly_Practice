package com.core.cabBooking;

public class CabBookingMain {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("        CAB BOOKING SYSTEM          ");
        System.out.println("====================================");

        System.out.println("Mini Cab : ");
        System.out.println("----------");
        MiniCab miniCab = new MiniCab();
        miniCab.bookRide();
        miniCab.calculateFair(3.5);
        miniCab.bookingStatus();

        System.out.println();

        System.out.println("Auto Cab : ");
        System.out.println("----------");
        AutoCab autoCab = new AutoCab();
        autoCab.bookRide();
        autoCab.calculateFair(3.5);
        autoCab.bookingStatus();

        System.out.println();

        System.out.println("Sedan Cab : ");
        System.out.println("-----------");
        SedanCab sedanCab = new SedanCab();
        sedanCab.bookRide();
        sedanCab.calculateFair(3.5);
        sedanCab.bookingStatus();

        System.out.println("------------------------------------");

        System.out.println();

    }

}
