package com.core.pizzaEnum;

public final class BillPrinter {

    private BillPrinter() {}

    public static void printBill(Pizza pizza) {

        System.out.println();
        System.out.println("============ BILL ============");
        System.out.println("Pizza Name : " + pizza.getItemName());
        System.out.println("Pizza Type : " + pizza.getType());
        System.out.println("Pizza description : " + pizza.getType().description());
        System.out.println("Size : " + pizza.getSize());
        System.out.println();

        System.out.println("Toppings : ");
        for(Topping topping : pizza.getToppings()) {
            System.out.println(" " + topping);
        }
        System.out.println();

        System.out.printf("Total : Rs.%.2f%n", pizza.calculatePrice());
        System.out.println();

    }

}
