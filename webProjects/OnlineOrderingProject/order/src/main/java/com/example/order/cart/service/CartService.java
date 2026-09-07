package com.example.order.cart.service;

import com.example.order.cart.dto.request.AddCartItemRequest;
import com.example.order.cart.dto.request.UpdateCartItemRequest;
import com.example.order.cart.dto.response.CartItemResponse;
import com.example.order.cart.dto.response.CartResponse;

public interface CartService {

    CartResponse getCartByCustomerId(Long customerId);

    CartResponse addItem(Long customerId, AddCartItemRequest request);

    CartResponse updateItem(Long customerId, Long cartItemId, UpdateCartItemRequest request);

    CartResponse removeItem(Long customerId, Long cartItemId);

    CartResponse clearCart(Long customerId);

}
