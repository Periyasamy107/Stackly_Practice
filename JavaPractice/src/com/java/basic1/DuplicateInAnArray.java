package com.java.basic1;

import java.util.Scanner;

public class DuplicateInAnArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array size : ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        for(int i=0; i<size; i++) {
            System.out.print("Enter the " + (i+1) + " number : ");
            int number = scanner.nextInt();
            arr[i] = number;
        }

        System.out.println();
        boolean isDuplicate = true;

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    System.out.println("Duplicate Number is  : " + arr[i]);
                    isDuplicate = false;
                }
            }
        }

        if(isDuplicate) {
            System.out.println("No duplicates found.");
        }
        System.out.println("---------------------------");

        scanner.close();

    }
}
