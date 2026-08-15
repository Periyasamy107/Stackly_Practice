package com.demo.lombokExample1.service;

import com.demo.lombokExample1.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void displayOrder(Order order) {
        System.out.println("\n========== ORDER DETAILS =============");
        System.out.println("\nOrder ID : " + order.getOrderId());
        System.out.println("Food Item : " + order.getFoodItem());
        System.out.println("Amount : " + order.getAmount());

        System.out.println("\n========== CUSTOMER DETAILS =============");
        System.out.println("\nCustomer ID : " + order.getCustomer().getCustomerId());
        System.out.println("Customer Name : " + order.getCustomer().getCustomerName());
        System.out.println("Customer City : " + order.getCustomer().getCity());

        System.out.println("\n========== RESTAURANT DETAILS =============");
        System.out.println("\nRestaurant ID : " + order.getRestaurant().getRestaurantId());
        System.out.println("Restaurant Name : " + order.getRestaurant().getRestaurantName());
        System.out.println("Restaurant Location : " + order.getRestaurant().getLocation());
        System.out.println();
    }
}
