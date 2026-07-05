package com.java.basic;

import java.util.Scanner;

public class EBBillProcessingSystem {

	public static void main(String[] args) {

		/** ==============================================================
         *            ELECTRICITY BILL PROCESSING SYSTEM
         *  ==============================================================
         *
         *  Objective:
         *  -------------
         *
         *  1. Collect customer details
         *  2. Take the reading
         *  3. Total units consumption
         *  4. EB bill processing
         *
         */

        Scanner scanner = new Scanner(System.in);

        /** =======================================
         *  COLLECT CUSTOMER DETAILS
         *  =======================================
         */

        System.out.println();
        System.out.print("Enter your name      : ");
        String name = scanner.nextLine();

        System.out.print("Enter your EB number : ");
        int number = scanner.nextInt();

        /** =======================================
         *  TAKE THE READINGS
         *  =======================================
         */

        System.out.println();
        System.out.print("Enter your new units consumption    : ");
        int newUnitsConsumption = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your old units consumption    : ");
        int oldUnitsConsumption = scanner.nextInt();
        scanner.nextLine();

        scanner.close();

        /** =======================================
         *  TOTAL UNITS CONSUMPTION
         *  =======================================
         */

        int totalUnitsConsumed = newUnitsConsumption - oldUnitsConsumption;
        totalUnitsConsumed -= 100;

        /** =======================================
         *  EB BILL PROCESSING
         *  =======================================
         */
        double ebBill = 0.0;

        if (totalUnitsConsumed >= 101 && totalUnitsConsumed <= 200) {
            ebBill = totalUnitsConsumed * 2.35;
        } else if (totalUnitsConsumed >= 201 && totalUnitsConsumed <= 400) {
            ebBill = (100 * 2.35) + ((totalUnitsConsumed - 100) * 4.70);
        } else if (totalUnitsConsumed >= 401 && totalUnitsConsumed >= 500){
            ebBill = (100 * 2.35) + (200 * 4.70) + ((totalUnitsConsumed - 300) * 6.30);
        }


        System.out.println();
        System.out.println("==============================================================");
        System.out.println("          ELECTRICITY BILL PROCESSING SYSTEM");
        System.out.println("==============================================================");


        System.out.println();
        System.out.println("Customer Details:");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Customer Name : " + name);
        System.out.println("EB Number     : " + number);


        System.out.println();
        System.out.println("EB Bill Processing:");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Total Units Consumed    : " + totalUnitsConsumed);
        System.out.println("Total Amount To Be Paid : Rs." +  Math.round(ebBill));

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                        THANK YOU                             ");
        System.out.println("==============================================================");

		
	}

}
