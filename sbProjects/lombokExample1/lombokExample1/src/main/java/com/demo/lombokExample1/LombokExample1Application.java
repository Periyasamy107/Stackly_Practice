package com.demo.lombokExample1;

import com.demo.lombokExample1.model.Customer;
import com.demo.lombokExample1.model.Order;
import com.demo.lombokExample1.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.demo.lombokExample1.service.OrderService;

@SpringBootApplication
public class LombokExample1Application implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

	public static void main(String[] args) {
        SpringApplication.run(LombokExample1Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Customer customer = Customer.builder()
                .customerId(10)
                .customerName("Sam")
                .city("Dharmapuri")
                .build();

        Restaurant restaurant = Restaurant.builder()
                .restaurantId(20)
                .restaurantName("Samuel Veg and Non Veg Hotel")
                .location("Salem")
                .build();

        Order order = Order.builder()
                .orderId(30)
                .foodItem("Non-Veg Biriyani")
                .amount(300)
                .customer(customer)
                .restaurant(restaurant)
                .build();

        orderService.displayOrder(order);

    }
}
