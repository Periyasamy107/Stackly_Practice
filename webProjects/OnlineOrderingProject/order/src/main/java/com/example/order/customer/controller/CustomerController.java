package com.example.order.customer.controller;

import com.example.order.common.response.ApiResponse;
import com.example.order.customer.dto.request.CustomerLoginRequest;
import com.example.order.customer.dto.request.CustomerRegistrationRequest;
import com.example.order.customer.dto.request.CustomerUpdateRequest;
import com.example.order.customer.dto.response.CustomerResponse;
import com.example.order.customer.entity.CustomerStatus;
import com.example.order.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Validated
@Tag(name = "Customer Service", description = "Customer Service include the CRUD operations for the customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    @Operation(summary = "Register customer", description = "Add a new customer by getting the required details")
    public ResponseEntity<ApiResponse<CustomerResponse>> registerCustomer(@Valid @RequestBody CustomerRegistrationRequest request){
        CustomerResponse response = customerService.registerCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Customer registered successfully", response));
    }

    @PostMapping("/login")
    @Operation(summary = "login", description = "customer login by getting the username and password")
    public ResponseEntity<ApiResponse<CustomerResponse>> login(@Valid @RequestBody CustomerLoginRequest loginRequest) {
        CustomerResponse response = customerService.login(loginRequest);
        return ResponseEntity.ok(ApiResponse.success("Customer login successful", response));
    }

    @GetMapping("/{customerId}")
    @Operation(summary = "Get a customer", description = "Get a single customer by their customer id")
    public ResponseEntity<ApiResponse<CustomerResponse>> getCustomerById(@PathVariable @Positive(message = "Customer ID must be greater than zero") Long customerId) {
        CustomerResponse response = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(ApiResponse.success("Customer retrieved successfully", response));
    }

    @GetMapping
    @Operation(summary = "All customers", description = "Get all the customers")
    public ResponseEntity<ApiResponse<List<CustomerResponse>>> getAllCustomers() {
        List<CustomerResponse> response = customerService.getAllCustomers();
        return ResponseEntity.ok(ApiResponse.success("Customers retrieved successfully", response));
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Customer by status", description = "Getting a customers based on the status")
    public ResponseEntity<ApiResponse<Page<CustomerResponse>>> getCustomersByStatus(
            @PathVariable CustomerStatus status,

            @RequestParam(defaultValue = "0")
            @PositiveOrZero(message = "Page number cannot be negative")
            int page,

            @RequestParam(defaultValue = "5")
            @Positive(message = "Page size must be greater than zero")
            int size

            ) {

        Pageable pageable = PageRequest.of(page, size);
        Page<CustomerResponse> response = customerService.getCustomersByStatus(status, pageable);
        return ResponseEntity.ok(ApiResponse.success("Customers retrieved successfully", response));

    }

    @PutMapping("/{customerId}")
    @Operation(summary = "Update a customer", description = "Update a single customer")
    public ResponseEntity<ApiResponse<CustomerResponse>> updateCustomer(
            @PathVariable
            @Positive(message = "Customer ID must be greater than zero")
            Long customerId,

            @Valid @RequestBody
            CustomerUpdateRequest request
    ) {

        CustomerResponse response = customerService.updateCustomer(customerId, request);
        return ResponseEntity.ok(ApiResponse.success("Customer updated successfully", response));
    }

    @PatchMapping("/{customerId}/status")
    @Operation(summary = "Partial customer update", description = "Update the customer status by getting the customer id")
    public ResponseEntity<ApiResponse<CustomerResponse>> updateCustomerStatus(
            @PathVariable
            @Positive(message = "Customer ID must be greater than zero")
            Long customerId,

            @RequestParam CustomerStatus status
    ) {

        CustomerResponse response = customerService.updateCustomerStatus(customerId, status);
        return ResponseEntity.ok(ApiResponse.success("Customer status updated successfully", response));

    }


}
