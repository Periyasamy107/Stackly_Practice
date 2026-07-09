package com.java.basic1;

import java.util.Scanner;

public class SearchInArray {
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
        System.out.print("Enter the target element : ");
        int target = scanner.nextInt();
        int index = -1;

        for(int i=0; i<size; i++) {
            if(arr[i] == target) {
                index = i;
            }
        }

        System.out.println();
        if(index!=-1) {
            System.out.println("Searching element index is at : " + index);
        } else {
            System.out.println("Searching element index is not found....");
        }
        System.out.println("----------------------------------------");

        scanner.close();

    }
}
