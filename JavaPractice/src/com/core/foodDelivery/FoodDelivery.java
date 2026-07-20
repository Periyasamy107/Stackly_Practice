package com.core.foodDelivery;

import java.util.Scanner;

public class FoodDelivery {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RunOrStop control = new RunOrStop();

        FoodDeliveryLocalOrCity localOrCity = new FoodDeliveryLocalOrCity();

        ShopChoice shopChoice = new ShopChoice();

        FoodHelper helper = new FoodHelper();

        FoodDeliveryMainLogic mainLogic = new FoodDeliveryMainLogic();

        boolean isRunning = true;
        while(isRunning) {
            int runOrStop = control.runOrStop(scanner);
            switch (runOrStop) {
                case 1 -> {
                    mainLogic.programLogic(scanner, shopChoice, helper, localOrCity);
                }
                case 2 -> {
                    isRunning = false;
                    System.out.println("Exit the Program.");
                }
                default -> {
                    System.out.println();
                    System.out.println("Invalid Input");
                }
            }
        }
        scanner.close();
    }

}
