package com.example.order.cart.mapper;

import com.example.order.cart.dto.response.CartItemResponse;
import com.example.order.cart.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "productPrice", source = "product.price")
    @Mapping(
            target = "totalPrice",
            expression = "java(cartItem.getProduct().getPrice().multiply(java.math.BigDecimal.valueOf(cartItem.getQuantity())))"
    )
    CartItemResponse toCartItemResponse(CartItem cartItem);

}
