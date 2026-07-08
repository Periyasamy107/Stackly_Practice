package com.java.basic;

import java.util.Scanner;

public class PalindromeUsingWhileLoop {
    public static void main(String[] args) {

        /** ==================================================
         *     PALINDROME NUMBER FINDING USING WHILE LOOP
         *  ==================================================
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("================================");
        System.out.println("    PALINDROME NUMBER OR NOT");
        System.out.println("================================");

        System.out.print("Please enter the number : ");
        int number = scanner.nextInt();

        int originalNumber = number;
        int reversedNumber = 0;
        while(number>0) {
            int digit = number % 10;
            reversedNumber = (reversedNumber * 10) + digit;
            number = number / 10;
        }

        System.out.println();
        System.out.println("--------------------------------");
        if(originalNumber == reversedNumber) {
            System.out.println(originalNumber + " is a Palindrome Number");
        } else {
            System.out.println(originalNumber + " is not a Palindrome Number");
        }

        System.out.println("--------------------------------");
        scanner.close();

    }
}
