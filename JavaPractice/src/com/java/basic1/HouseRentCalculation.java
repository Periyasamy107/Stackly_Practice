package com.java.basic1;

import java.util.Scanner;

public class HouseRentCalculation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("      HOUSE RENT CALCULATION PROGRAM      ");
        System.out.println("==========================================");
        System.out.println();


        System.out.print("Number of bhk : ");
        int bhk = scanner.nextInt();
        System.out.print("Number of months : ");
        int months = scanner.nextInt();
        System.out.println();

        int[][] readings = new int[bhk][months];

        for(int i=0; i<bhk; i++) {
            for(int j=0; j<months; j++) {
                System.out.print("House "+(i+1)+" Month "+(j+1)+" reading is : ");
                int dailyReading = scanner.nextInt();
                readings[i][j] = dailyReading;
            }
            System.out.println();
        }

        for(int i=0; i<bhk; i++) {
            System.out.print("House "+(i+1)+" Readings : ");
            for(int j=0; j<months; j++) {
                System.out.print(readings[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        int[] totalReadings = new int[bhk];

        for(int i=0; i<bhk; i++) {
            int minimumRent = readings[i][0];
            int maximumRent = readings[i][0];
            int temp = 0;

            for(int j=0; j<readings[0].length; j++) {
                temp += readings[i][j];
                if(readings[i][j] > maximumRent) {
                    maximumRent = readings[i][j];
                }
                if(readings[i][j] < minimumRent) {
                    minimumRent = readings[i][j];
                }
            }

            totalReadings[i] = temp;

            System.out.println("House "+(i+1)+" Minimum Rent is : "+minimumRent);
            System.out.println("House "+(i+1)+" Maximum Rent is : "+maximumRent);
            System.out.println("House "+(i+1)+" Total Rent is : "+temp);
            System.out.println();
        }

        int overallCostlyHouse = 0;
        int overallCostlyPrice = 0;

        for(int i=0; i<totalReadings.length; i++) {
            if(totalReadings[i] > overallCostlyPrice) {
                overallCostlyPrice = totalReadings[i];
                overallCostlyHouse = i;
            }
        }

        System.out.println();
        System.out.println("House "+(overallCostlyHouse+1)+" is the costly house");
        System.out.println("---------------------------------------");

        scanner.close();

    }
}
