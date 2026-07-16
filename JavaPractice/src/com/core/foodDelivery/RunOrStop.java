package com.core.foodDelivery;

import java.util.Scanner;

public class RunOrStop {

    public int runOrStop(Scanner scanner) {
        System.out.println();
        System.out.println("1) Run the program");
        System.out.println("2) Stop the program");
        System.out.print("Please enter 1 or 2 : ");
        return scanner.nextInt();
    }

}
