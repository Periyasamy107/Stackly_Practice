package com.example.order.service;

import com.example.order.exception.CustomerNotFoundException;
import com.example.order.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Sam", "sam@gmail.com", "phone", 15000d),
            new Customer(2, "Tom", "tom@gmail.com", "watch", 3000d)
    ));

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(Integer customerId) {
        return customers.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with the id : " + customerId));
    }

    public String addCustomer(Customer customer) {
        customers.add(new Customer(
                customer.getCustomerId(), customer.getCustomerName(), customer.getEmail(), customer.getProductName(), customer.getPrice()
        ));
        return "Customer added successfully.";
    }

    public String updateCustomer(Integer customerId, Customer customer) {
        Customer existingCustomer = customers.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found for update : " + customerId));
        existingCustomer.setCustomerId(customerId);
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setProductName(customer.getProductName());
        existingCustomer.setPrice(customer.getPrice());
        return "Customer updated Successfully.";
    }

    public String removeCustomer(Integer customerId) {
        Customer customer = customers.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found for delete : " + customerId));
        customers.remove(customer);
        return "Customer removed Successfully.";
    }

}
