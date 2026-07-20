package com.core.pizzaEnum;

public class PizzaStore {

    public Pizza orderPizza(PizzaType type, PizzaSize size, Topping ... toppings) {

        Pizza pizza = new Pizza(type.name() + " Pizza", type, size);

        for(Topping topping : toppings) {
            pizza.addTopping(topping);
        }

        pizza.prepare();

        return pizza;

    }

}