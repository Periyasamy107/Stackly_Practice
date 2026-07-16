package com.core.foodDelivery;

import java.util.Scanner;

public class FoodHelper {
    public int choiceGetting(Scanner scanner) {
        System.out.println();
        System.out.println("1) Veg Biriyani");
        System.out.println("2) Veg Rice");
        System.out.println("3) Non-Veg Biriyani");
        System.out.println("4) Non-Veg Rice");
        System.out.print("Please select 1/2/3/4 : ");
        return scanner.nextInt();
    }

    public double distanceGetting(Scanner scanner) {
        System.out.println();
        System.out.println("1) One KM");
        System.out.println("2) Two KM");
        System.out.println("3) Three KM");
        System.out.println("4) Four KM");
        System.out.println("5) Five KM");
        System.out.print("Please select 1/2/3/4/5 : ");
        return scanner.nextDouble();
    }

    public int quantityGetting(Scanner scanner) {
        System.out.println();
        System.out.print("Please enter the quantity : ");
        return scanner.nextInt();
    }
}
