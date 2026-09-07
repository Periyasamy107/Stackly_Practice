package com.example.order.customer.service;

import com.example.order.customer.dto.request.CustomerLoginRequest;
import com.example.order.customer.dto.request.CustomerRegistrationRequest;
import com.example.order.customer.dto.request.CustomerUpdateRequest;
import com.example.order.customer.dto.response.CustomerResponse;
import com.example.order.customer.entity.CustomerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    CustomerResponse registerCustomer(CustomerRegistrationRequest request);

    CustomerResponse login(CustomerLoginRequest loginRequest);

    CustomerResponse getCustomerById(Long customerId);

    List<CustomerResponse> getAllCustomers();

    Page<CustomerResponse> getCustomersByStatus(CustomerStatus status, Pageable pageable);

    CustomerResponse updateCustomer(Long customerId, CustomerUpdateRequest request);

    CustomerResponse updateCustomerStatus(Long customerId, CustomerStatus status);

}
