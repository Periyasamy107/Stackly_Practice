package com.demo.OnlineShopping;

import com.demo.OnlineShopping.model.Customer;
import com.demo.OnlineShopping.model.Order;
import com.demo.OnlineShopping.model.Product;
import com.demo.OnlineShopping.service.OnlineShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShoppingApplication implements CommandLineRunner {

    @Autowired
    private OnlineShoppingService service;

	public static void main(String[] args) {
        SpringApplication.run(OnlineShoppingApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId("Customer01");
        customer.setCustomerName("Lina");
        customer.setCity("Chennai");

        Product product = new Product();
        product.setProductId("Product01");
        product.setProductName("Mobile");
        product.setCategory("Electronics");
        product.setPrice(20000);

        Order order = Order.builder()
                .orderId("Order01")
                .customer(customer)
                .product(product)
                .quantity(5)
                .totalAmount(5 * product.getPrice())
                .build();

        service.displayOrders(order);
    }
}
