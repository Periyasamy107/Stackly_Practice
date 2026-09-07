package com.example.order.customer.service.impl;

import com.example.order.common.exception.BusinessException;
import com.example.order.common.exception.DuplicateResourceException;
import com.example.order.common.exception.ResourceNotFoundException;
import com.example.order.customer.dto.request.CustomerLoginRequest;
import com.example.order.customer.dto.request.CustomerRegistrationRequest;
import com.example.order.customer.dto.request.CustomerUpdateRequest;
import com.example.order.customer.dto.response.CustomerResponse;
import com.example.order.customer.entity.Customer;
import com.example.order.customer.entity.CustomerStatus;
import com.example.order.customer.mapper.CustomerMapper;
import com.example.order.customer.repository.CustomerRepository;
import com.example.order.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;
    private final CustomerMapper mapper;

    @Override
    @Transactional
    public CustomerResponse registerCustomer( CustomerRegistrationRequest request) {

        String userName = request.userName().trim();
        String email = request.email().trim().toLowerCase();

        if(repo.existsByUserName(userName)) {
            throw new DuplicateResourceException("UserName already exists");
        }
        if(repo.existsByEmail(email)) {
            throw new DuplicateResourceException("Email already exists");
        }

        Customer customer = mapper.toEntity(request);

        customer.setUserName(userName);
        customer.setEmail(email);
        customer.setFullName(request.fullName().trim());
        customer.setStatus(CustomerStatus.ACTIVE);

        Customer savedCustomer = repo.save(customer);

        log.info("Customer registered successfully with the ID : {}", savedCustomer.getId());

        return mapper.toResponse(savedCustomer);

    }

    @Override
    public CustomerResponse login( CustomerLoginRequest loginRequest) {

        Customer customer = repo.findByUserName(loginRequest.userName().trim())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid username or password"));

        if(!customer.getPassword().equals(loginRequest.password())) {
            throw new BusinessException("INVALID_LOGIN", "Invalid username or password");
        }

        if(customer.getStatus() != CustomerStatus.ACTIVE) {
            throw new BusinessException("CUSTOMER_INACTIVE","Customer account is inactive");
        }

        log.info("Customer login successful for ID : {}", customer.getId());

        return mapper.toResponse(customer);

    }

    @Override
    public CustomerResponse getCustomerById(Long customerId) {
        Customer customer = findCustomerById(customerId);
        return mapper.toResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return repo.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public Page<CustomerResponse> getCustomersByStatus(CustomerStatus status, Pageable pageable) {
        return repo.findByStatus(status,pageable).map(mapper::toResponse);
    }

    @Override
    @Transactional
    public CustomerResponse updateCustomer(Long customerId, CustomerUpdateRequest request) {

        Customer customer = findCustomerById(customerId);
        String email = request.email().trim().toLowerCase();

        repo.findByEmail(email)
                .ifPresent(existingCustomer -> {
                    if(!existingCustomer.getId().equals(customerId)){
                        throw new DuplicateResourceException("Email already exists");
                    }
                });

        customer.setEmail(email);
        customer.setFullName(request.fullName().trim());

        Customer updatedCustomer = repo.save(customer);

        log.info("Customer updated successfully with the ID : {}", updatedCustomer.getId());

        return mapper.toResponse(updatedCustomer);

    }

    @Override
    @Transactional
    public CustomerResponse updateCustomerStatus(Long customerId, CustomerStatus status) {
        Customer customer = findCustomerById(customerId);
        customer.setStatus(status);
        Customer updatedCustomer = repo.save(customer);
        log.info("Customer status updated for the Customer ID : {}", updatedCustomer.getId());
        return mapper.toResponse(updatedCustomer);
    }

    private Customer findCustomerById(Long customerId) {
        return repo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID : {}" + customerId));
    }
}
