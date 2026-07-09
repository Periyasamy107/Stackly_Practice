package com.java.basic1;

import java.util.Scanner;

public class OddEvenNumberInAnArray {
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
        int[] odd = new int[size];
        int[] even = new int[size];
        int oddCount = 0;
        int evenCount = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] % 2 == 0) {
                evenCount++;
                even[i] = arr[i];
            } else {
                oddCount++;
                odd[i] = arr[i];
            }
        }

        System.out.print("Odd Numbers Are : ");
        for(int number : odd) {
            if(number != 0) System.out.print(number + ", ");
        }
        System.out.println();
        System.out.println("Odd Numbers Count : " + oddCount);

        System.out.println();
        System.out.print("Even Numbers Are : ");
        for(int number : even) {
            if(number!=0) System.out.print(number + ", ");
        }
        System.out.println();
        System.out.println("Even Numbers Count : " + evenCount);
        System.out.println("---------------------------");

        scanner.close();

    }
}
