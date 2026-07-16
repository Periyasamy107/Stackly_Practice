package com.core.foodDelivery;

import java.util.Scanner;

public class ShopChoice {

    public int localShopChoice(Scanner scanner) {
        System.out.println();
        System.out.println("1) Samy Shop");
        System.out.println("2) Deva Shop");
        System.out.print("Please enter 1 or 2 : ");
        return scanner.nextInt();
    }

    public int cityShopChoice(Scanner scanner) {
        System.out.println();
        System.out.println("1) Lena Veg and Non-Veg");
        System.out.println("2) Yuvish All Foods");
        System.out.print("Please enter 1 or 2 : ");
        return scanner.nextInt();
    }

}
