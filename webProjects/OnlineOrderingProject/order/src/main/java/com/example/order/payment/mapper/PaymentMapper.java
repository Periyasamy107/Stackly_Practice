package com.example.order.payment.mapper;

import com.example.order.payment.dto.response.PaymentResponse;
import com.example.order.payment.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "orderId", source = "order.id")
    PaymentResponse toResponse(Payment payment);

}
