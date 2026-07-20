package com.core.pizzaEnum;

public enum PizzaSize {

    SMALL("Small",6,150),
    MEDIUM("Medium",9,250),
    LARGE("Large",12,400);

    private String displayName;
    private int inches;
    private double basePrice;

    PizzaSize(String displayName, int inches, double basePrice) {
        this.displayName = displayName;
        this.inches = inches;
        this.basePrice = basePrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getInches() {
        return inches;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public static PizzaSize fromString(String text) {
        for(PizzaSize size : values()) {
            if(size.name().equalsIgnoreCase(text)) {
                return size;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return displayName + " ( " + inches + " inch )";
    }
}

