package com.example.order;

import com.example.order.model.Customer;
import com.example.order.model.Order;
import com.example.order.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerOnlineOrderAopApplication implements CommandLineRunner {

    private OrderService orderService;

    public CustomerOnlineOrderAopApplication(OrderService orderService) {
        this.orderService = orderService;
    }

	public static void main(String[] args) {
        SpringApplication.run(CustomerOnlineOrderAopApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer("customer01", "Sam");
        System.out.println("==============================");
        System.out.println("CUSTOMER ONLINE ORDER SYSTEM");
        System.out.println("==============================");

        System.out.println("\n1. SUCCESSFUL ORDER");
        System.out.println("------------------------------");
        Order successfulOrder = new Order("order01", customer, "Laptop", 1, 75000);
        try{
            Order result = orderService.placeOrder(successfulOrder);
            System.out.println("Order : " + result);
        } catch (Exception e) {
            System.out.println("Order Failed : " + e.getMessage());
        }

        System.out.println("\n2. FAILED ORDER");
        System.out.println("------------------------------");
        Order failureOrder = new Order("order02", customer, "Gaming Server", 1, 150000);
        try{
            orderService.placeOrder(failureOrder);
        } catch (Exception e) {
            System.out.println("Order Failed : " + e.getMessage());
        }

    }
}
