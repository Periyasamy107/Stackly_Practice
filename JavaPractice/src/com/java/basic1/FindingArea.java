package com.java.basic1;

import java.util.Scanner;

public class FindingArea {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("==================================================");
        System.out.println("       FINDING AREA FOR DIFFERENT OBJECTS         ");
        System.out.println("==================================================");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        FindingArea area = new FindingArea();

        boolean isRunning = true;

        do {
            System.out.println("1) Circle ");
            System.out.println("2) Triangle ");
            System.out.println("3) Rectangle ");
            System.out.println("4) Ellipse");
            System.out.println("5) Square");
            System.out.println("6) Exit");
            System.out.println();
            System.out.print("Please enter from the options : ");
            int options = scanner.nextInt();

            switch(options) {
                case 1 -> {
                    System.out.println();
                    area.circle(scanner);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println();
                    area.triangle(scanner);
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    area.rectangle(scanner);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println();
                    area.ellipse(scanner);
                    System.out.println();
                }
                case 5 -> {
                    System.out.println();
                    area.square(scanner);
                    System.out.println();
                }
                case 6 -> {
                    System.out.println();
                    System.out.println("--------------------------------------------------");
                    isRunning = false;
                    System.out.println("Exiting the program");
                }
                default -> {
                    System.out.println();
                    System.out.println("Please enter either 1 or 2 or 3 or 4.");
                }
            }
            System.out.println("--------------------------------------------------");
        } while(isRunning);
        scanner.close();
    }

    public void circle(Scanner scanner) {
        System.out.print("Enter the radius : ");
        int radius = scanner.nextInt();
        double area = 0.0;
        area = Math.PI * radius * radius;
        System.out.printf("Area of the circle is : %.2f",area);
    }

    public void triangle(Scanner scanner) {
        System.out.print("Enter the breath : ");
        int breath = scanner.nextInt();
        System.out.print("Enter the height : ");
        int height = scanner.nextInt();
        double area = 0.0;
        area = 0.5 * breath * height;
        System.out.printf("Area of the triangle is : %.2f",area);
    }

    public void rectangle(Scanner scanner) {
        System.out.print("Enter the length : ");
        int length = scanner.nextInt();
        System.out.print("Enter the width : ");
        int width = scanner.nextInt();
        double area = 0.0;
        area = length * width;
        System.out.printf("Area of the rectangle is : %.2f",area);
    }

    public void ellipse(Scanner scanner) {
        System.out.print("Enter the a axis : ");
        int aAxis = scanner.nextInt();
        System.out.print("Enter the b axis : ");
        int bAxis = scanner.nextInt();
        double area = 0.0;
        area = Math.PI * aAxis * bAxis;
        System.out.printf("Area of the ellipse is : %.2f",area);
    }

    public void square(Scanner scanner) {
        System.out.print("Enter the a value : ");
        int aValue = scanner.nextInt();
        double area = 0.0;
        area = aValue * aValue;
        System.out.printf("Area of the square is : %.2f",area);
    }

}
