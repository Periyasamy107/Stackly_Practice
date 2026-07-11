package com.java.basic1;

import java.util.Scanner;

public class HospitalTempReading {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("      PATIENT FEVER READING PROGRAM       ");
        System.out.println("==========================================");
        System.out.println();


        System.out.print("Number of patients : ");
        int patients = scanner.nextInt();
        System.out.print("Number of days : ");
        int days = scanner.nextInt();
        System.out.println();

        int[][] readings = new int[patients][days];
        String[][] markings = new String[patients][days];

        for(int i=0; i<patients; i++) {
            for(int j=0; j<days; j++) {
                System.out.print("Patient "+(i+1)+" Day "+(j+1)+" reading is : ");
                int dailyReading = scanner.nextInt();
                readings[i][j] = dailyReading;

                if(dailyReading >= 97 && dailyReading < 99) {
                    markings[i][j] = "normal";
                } else if (dailyReading >= 99 && dailyReading < 101) {
                    markings[i][j] = "high";
                } else if (dailyReading >= 101 && dailyReading <= 105) {
                    markings[i][j] = "veryHigh";
                } else {
                    markings[i][j] = "Normal";
                }

            }
            System.out.println();
        }

        for(int i=0; i<patients; i++) {
            System.out.print("Patient "+(i+1)+" Readings : ");
            for(int j=0; j<days; j++) {
                System.out.print(readings[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
        for(int i=0; i<patients; i++) {
            System.out.print("Patient "+(i+1)+" Readings : ");
            for(int j=0; j<days; j++) {
                System.out.print(markings[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
        for(int i=0; i<patients; i++) {
            int normalCount = 0;
            int highCount = 0;
            int veryHighCount = 0;

            for(int j=0; j<days; j++) {
                if(markings[i][j].equals("normal")) normalCount++;
                else if(markings[i][j].equals("high")) highCount++;
                else if(markings[i][j].equals("veryHigh")) veryHighCount++;
            }

            if(normalCount == days) System.out.println("Patient "+(i+1)+" is normal and he/she can discharge");
            else if(veryHighCount == days) System.out.println("Patient "+(i+1)+" is the emergency patient, need hospitalization");
            else System.out.println("Patient "+(i+1)+" needs frequent medical checkup");

        }

        System.out.println();
        System.out.println("-----------------------------------------------------------");

        scanner.close();

    }
}