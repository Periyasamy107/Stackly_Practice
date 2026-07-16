package com.core.foodDelivery;

import java.util.Scanner;

public class FoodDeliveryLocalOrCity {

    public int locationChoice(Scanner scanner) {
        System.out.println();
        System.out.println("1) Local Location");
        System.out.println("2) City Location");
        System.out.print("Please enter 1 or 2 : ");
        return scanner.nextInt();
    }

}
