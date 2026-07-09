package com.java.basic1;

import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array size : ");
        int size = scanner.nextInt();

        int sum = 0;
        for(int i=1; i<=size; i++) {
            System.out.print("Enter the " + i + " number : ");
            int number = scanner.nextInt();
            sum += number;
        }

        System.out.println();
        System.out.println("Sum of the array is : " + sum);
        System.out.println("----------------------------");

        scanner.close();

    }
}
