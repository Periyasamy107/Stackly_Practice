package com.core.pizzaEnum;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends FoodItem {

    private PizzaType type;
    private PizzaSize size;
    private List<Topping> toppings;

    public Pizza ( String name, PizzaType type, PizzaSize size ) {
        super(name);
        this.type = type;
        this.size = size;
        toppings = new ArrayList<>();
    }

    public PizzaType getType() {
        return type;
    }

    public PizzaSize getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getItemName());
    }

    @Override
    public double calculatePrice() {
        double total = size.getBasePrice();
        for(Topping topping: toppings) {
            total += topping.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return getItemName() + " | " + type + " | " + size;
    }
}

