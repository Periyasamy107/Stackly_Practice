package com.example.order.customer.mapper;

import com.example.order.customer.dto.request.CustomerRegistrationRequest;
import com.example.order.customer.dto.response.CustomerResponse;
import com.example.order.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    Customer toEntity(CustomerRegistrationRequest request);

    CustomerResponse toResponse(Customer customer);

}
