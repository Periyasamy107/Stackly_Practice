package com.java.onlineShopping;

public class OnlineShopping {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       ONLINE SHOPPING PROGRAM");
        System.out.println("========================================");

        System.out.println("Food : ");
        System.out.println("----------------------------------------");
        Food food = new Food(5, "Dosa", 105.50, "16-07-2026");
        food.display();
        System.out.println();

        System.out.println("Cloth : ");
        System.out.println("----------------------------------------");
        Cloth cloth = new Cloth(7, "Shirt", 450.50, 'M');
        cloth.display();
        System.out.println();

        System.out.println("Electronics : ");
        System.out.println("----------------------------------------");
        Electronics electronics = new Electronics(10, "Laptop", 15000, 3);
        electronics.display();

        System.out.println("----------------------------------------");

    }
}
