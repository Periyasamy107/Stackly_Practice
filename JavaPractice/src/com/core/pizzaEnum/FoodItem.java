package com.core.pizzaEnum;

public abstract class FoodItem implements Billable {

    public String itemName;

    public FoodItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void displayItem() {
        System.out.println("Item : " + itemName);
    }

    public abstract void prepare();

    @Override
    public abstract double calculatePrice();
}

