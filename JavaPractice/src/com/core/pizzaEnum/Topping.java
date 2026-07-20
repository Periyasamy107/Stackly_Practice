package com.core.pizzaEnum;

public enum Topping {

    CHEESE("Extra Cheese", 40),
    MUSHROOM("Mushroom", 30),
    ONION("Onion", 20),
    OLIVES("Olives", 35),
    PANEER("Paneer", 50),
    CHICKEN("Chicken", 70);

    private String displayName;
    private double price;

    Topping(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return displayName + " ( Rs. " + price  + " )";
    }
}
