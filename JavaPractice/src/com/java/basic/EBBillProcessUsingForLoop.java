package com.java.basic;

import java.util.Scanner;

public class EBBillProcessUsingForLoop {

	public static void main(String[] args) {
		
		/** ==============================================================
         *        ELECTRICITY BILL PROCESSING SYSTEM USING FOR LOOP
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
        
        for(int i=1; i<=6; i++) {
        	
        	/** =======================================
             *  COLLECT CUSTOMER DETAILS
             *  =======================================
             */

            System.out.println("Month " + i + " enter the details :");
            System.out.println("************************************");            
            System.out.print("Enter your name      : ");
            String name = scanner.nextLine();

            System.out.print("Enter your EB number : ");
            int number = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Please either enter c or d : "); // c -> commercial use   d -> domestic use
            String useType = scanner.nextLine();

            /** =======================================
             *  TAKE THE READINGS
             *  =======================================
             */

            System.out.print("New units consumption    : ");
            int newUnitsConsumption = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Old units consumption    : ");
            int oldUnitsConsumption = scanner.nextInt();
            scanner.nextLine();


            /** =======================================
             *  TOTAL UNITS CONSUMPTION
             *  =======================================
             */

            int totalUnitsConsumed = newUnitsConsumption - oldUnitsConsumption;

            /** =======================================
             *  EB BILL PROCESSING
             *  =======================================
             */
            double ebBill = 0.0;
            
            if(useType.equals("d")) {
            	if (totalUnitsConsumed >= 1 && totalUnitsConsumed <= 100) {
            		ebBill = totalUnitsConsumed * 1.50;
            	} else if (totalUnitsConsumed >= 101 && totalUnitsConsumed <= 200) {
                    ebBill = totalUnitsConsumed * 2.35;
                } else if (totalUnitsConsumed >= 201 && totalUnitsConsumed <= 400) {
                    ebBill = (100 * 2.35) + ((totalUnitsConsumed - 100) * 4.70);
                } else {
                    ebBill = (100 * 2.35) + (200 * 4.70) + ((totalUnitsConsumed - 300) * 6.30);
                }
            } else if(useType.equals("c")){
            	if (totalUnitsConsumed >= 1 && totalUnitsConsumed <= 100) {
            		ebBill = totalUnitsConsumed * 1.85;
            	} else if (totalUnitsConsumed >= 101 && totalUnitsConsumed <= 200) {
                    ebBill = totalUnitsConsumed * 3.50;
                } else if (totalUnitsConsumed >= 201 && totalUnitsConsumed <= 400) {
                    ebBill = (100 * 3.50) + ((totalUnitsConsumed - 100) * 6.25);
                } else {
                    ebBill = (100 * 3.50) + (200 * 6.25) + ((totalUnitsConsumed - 300) * 8.50);
                }
            } else {
            	System.out.println("Please enter c or d in order to process the eb bill.");
            }
            
            System.out.println();
            
            System.out.println("Total Units Consumed    : " + totalUnitsConsumed);
            System.out.println("Total Amount To Be Paid : Rs." +  Math.round(ebBill));

            System.out.println("====================================");
            System.out.println();
            System.out.println();
            
        }
        
        System.out.println();
        System.out.println("====================================");
        System.out.println("            THANK YOU               ");
        System.out.println("====================================");
        
        
        scanner.close();


	}

}
