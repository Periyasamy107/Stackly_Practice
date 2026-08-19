package com.example.order.service;

import com.example.order.annotation.TransactionalOperation;
import com.example.order.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @TransactionalOperation
    public Order placeOrder(Order order) {
        System.out.println("[ORDER] Validating order");
        validateOrder(order);
        System.out.println("[ORDER] Checking product stock");
        checkStock(order);
        System.out.println("[ORDER] Deducting stock");
        deductStock(order);
        System.out.println("[ORDER] Processing payment");
        processPayment(order);
        System.out.println("[ORDER] Order placed");
        createOrder(order);
        return order;
    }

    private void validateOrder(Order order) {
        if(order.getQuantity()<=0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if(order.getAmount()<=0) {
            throw new IllegalArgumentException("Order amount must be greater than zero");
        }
    }

    private void checkStock(Order order) {
        int availableStock = 10;
        if(order.getQuantity() > availableStock) {
            throw new IllegalArgumentException("Insufficient stock");
        }
    }

    private void deductStock(Order order) {
        System.out.println("[ORDER] Stock deducted : " + order.getQuantity());
    }

    private void processPayment(Order order) {
        if(order.getAmount() > 100000) {
            throw new IllegalArgumentException("Payment failed");
        }
        System.out.println("[ORDER] Payment successful.");
    }

    private void createOrder(Order order) {
        System.out.println("[ORDER] Order created : " + order.getOrderId());
    }

}
