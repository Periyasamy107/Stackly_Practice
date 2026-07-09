package com.java.basic1;

import java.util.Scanner;

public class FactorialUsingDoWhile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int number = scanner.nextInt();
        int temp = number;

        System.out.println();

        System.out.println("factorial * number = result");
        int factorial = 1;
        do{
            System.out.println(factorial+" * "+temp+" = "+(temp*factorial));
            factorial = factorial * temp;
            temp--;
        } while (temp > 0);

        System.out.println();
        System.out.println("Factorial of " + number + " is : " + factorial);
        System.out.println("------------------------------");

    }
}
