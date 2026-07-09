package com.java.basic1;

import java.util.Scanner;

public class FibonacciUsingDoWhileAndSwitch {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        do {
            System.out.println("\n ----- Main Menu -----");
            System.out.println("1. Run Fibonacci Generator");
            System.out.println("2. Quit Program");
            System.out.print("Choose an option 1 or 2 : ");
            int mainOption = scanner.nextInt();

            switch (mainOption) {
                case 1 -> {
                    System.out.print("Start from 0 or 1 ? (Enter either 0 or 1) : ");
                    int option = scanner.nextInt();

                    System.out.print("Enter the no of terms to generate : ");
                    int iterations = scanner.nextInt();

                    int first;
                    int second;

                    System.out.println();
                    switch(option) {
                        case 0 -> {
                            first = 0;
                            second = 1;
                            for(int i=0; i<iterations; i++) {
                                System.out.print(first + " ");
                                int temp = first + second;
                                first = second;
                                second = temp;
                            }
                        }

                        case 1 -> {
                            first = 1;
                            second = 1;
                            for(int i=0; i<iterations; i++) {
                                System.out.print(first + " ");
                                int temp = first + second;
                                first = second;
                                second = temp;
                            }
                        }
                    }

                }
                case 2 -> {
                    System.out.println();
                    System.out.println("Exiting Program");
                    keepRunning = false;
                }

                default -> {
                    System.out.println();
                    System.out.println("Invalid Choice");
                }
            }
            System.out.println();
        } while(keepRunning);

        scanner.close();

    }
}
