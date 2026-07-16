package com.core.foodDelivery;

import java.util.Scanner;

public class FoodDeliveryMainLogic {

    public void programLogic(
            Scanner scanner,
            ShopChoice shopChoice,
            FoodHelper helper,
            FoodDeliveryLocalOrCity localOrCity
    ) {
        int location = localOrCity.locationChoice(scanner);

        switch(location) {
            case 1 -> {
                int shop = shopChoice.localShopChoice(scanner);
                switch (shop) {
                    case 1 -> {
                        CommonShopLogic samyBhavan = new CommonShopLogic(0.10, "Samy Bhavan");

                        samyBhavan.bookFood();
                        int choice = helper.choiceGetting(scanner);
                        int quantity = helper.quantityGetting(scanner);
                        double distance = helper.distanceGetting(scanner);
                        samyBhavan.bill(quantity, distance, choice);
                        samyBhavan.status();
                    }
                    case 2 -> {
                        CommonShopLogic devaBhavan = new CommonShopLogic(0.15, "Deva Bhavan");

                        devaBhavan.bookFood();
                        int choice = helper.choiceGetting(scanner);
                        int quantity = helper.quantityGetting(scanner);
                        double distance = helper.distanceGetting(scanner);
                        devaBhavan.bill(quantity, distance, choice);
                        devaBhavan.status();
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Please select the local shop choice 1 or 2");
                    }
                }
            }

            case 2 -> {
                int shop = shopChoice.cityShopChoice(scanner);
                switch (shop) {
                    case 1 -> {
                        CommonShopLogic linaVegAndNonVeg = new CommonShopLogic(0.30, "Lina Veg And Non Veg");

                        linaVegAndNonVeg.bookFood();
                        int choice = helper.choiceGetting(scanner);
                        int quantity = helper.quantityGetting(scanner);
                        double distance = helper.distanceGetting(scanner);
                        linaVegAndNonVeg.bill(quantity, distance, choice);
                        linaVegAndNonVeg.status();
                    }
                    case 2 -> {
                        CommonShopLogic yuvishAllFoods = new CommonShopLogic(0.35, "Yuvish All Foods");

                        yuvishAllFoods.bookFood();
                        int choice = helper.choiceGetting(scanner);
                        int quantity = helper.quantityGetting(scanner);
                        double distance = helper.distanceGetting(scanner);
                        yuvishAllFoods.bill(quantity, distance, choice);
                        yuvishAllFoods.status();
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Please select the city shop choice 1 or 2");
                    }
                }
            }

            default -> {
                System.out.println();
                System.out.println("Please select location either 1 or 2.");
            }
        }
    }

}
