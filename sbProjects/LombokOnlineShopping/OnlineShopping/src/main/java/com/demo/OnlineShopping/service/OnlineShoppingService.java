package com.demo.OnlineShopping.service;

import com.demo.OnlineShopping.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OnlineShoppingService {

    public void displayOrders(Order order) {

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("     CUSTOMER DETAILS : ");
        System.out.println("--------------------------------");
        System.out.println("Customer ID : " + order.getCustomer().getCustomerId());
        System.out.println("Customer Name : " + order.getCustomer().getCustomerName());
        System.out.println("Customer City : " + order.getCustomer().getCity());
        System.out.println();

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("     PRODUCT DETAILS : ");
        System.out.println("--------------------------------");
        System.out.println("Product ID : " + order.getProduct().getProductId());
        System.out.println("Product Name : " + order.getProduct().getProductName());
        System.out.println("Product Category : " + order.getProduct().getCategory());
        System.out.println("Product Rate : " + order.getProduct().getPrice());
        System.out.println();

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("     ORDER DETAILS : ");
        System.out.println("--------------------------------");
        System.out.println("Order ID : " + order.getOrderId());
        System.out.println("Customer Name : " + order.getCustomer().getCustomerName());
        System.out.println("Product Name : " + order.getProduct().getProductName());
        System.out.println("Quantity : " + order.getQuantity());
        System.out.println("Total Amount : " + order.getTotalAmount());
        System.out.println();

    }

}
