package com.java.basic1;

import java.util.Scanner;

public class LargetElementInArray {
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

        int largest = arr[0];

        for(int i=0; i<size; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println();
        System.out.println("Largest element in an array is : " + largest);
        System.out.println("----------------------------------------");

        scanner.close();

    }
}
