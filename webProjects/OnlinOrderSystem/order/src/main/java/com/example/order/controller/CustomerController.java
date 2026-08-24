package com.example.order.controller;

import com.example.order.model.Customer;
import com.example.order.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/singleCustomer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@Valid @PathVariable Integer customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<String> updateCustomer(@Valid @RequestBody Customer customer, @PathVariable Integer customerId) {
        return ResponseEntity.ok(customerService.updateCustomer(customerId, customer));
    }

    @DeleteMapping("/removeCustomer/{customerId}")
    public ResponseEntity<String> removeCustomer(@PathVariable Integer customerId) {
        return ResponseEntity.ok(customerService.removeCustomer(customerId));
    }

}
