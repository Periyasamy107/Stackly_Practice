package com.core.pizzaEnum;

public class PizzaDemo {

    public static void main(String[] args) {
        System.out.println("========== Pizza sizes ==========");

        for(PizzaSize size : PizzaSize.values()) {
            System.out.println(size.ordinal() + " -> " + size.name() + " -> " + size);
        }
        System.out.println();

        PizzaSize size = PizzaSize.valueOf("LARGE");

        System.out.println("Selected size : " + size);

        System.out.println();

        PizzaType type = PizzaType.CHEESE_BURST;

        switch (type) {
            case VEG:
                System.out.println("Vegetarian Pizza");
                break;
            case NON_VEG:
                System.out.println("Non-Veg Pizza");
                break;
            case CHEESE_BURST:
                System.out.println("Cheese Burst Pizza");
                break;
        }

        PizzaStore store = new PizzaStore();

        Pizza pizza = store.orderPizza(type, size, Topping.CHEESE, Topping.OLIVES, Topping.PANEER);

        BillPrinter.printBill(pizza);

        System.out.println("=================================");

    }

}

