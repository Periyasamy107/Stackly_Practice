package com.example.order.cart.controller;

import com.example.order.cart.dto.request.AddCartItemRequest;
import com.example.order.cart.dto.request.UpdateCartItemRequest;
import com.example.order.cart.dto.response.CartResponse;
import com.example.order.cart.service.CartService;
import com.example.order.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers/{customerId}/cart")
@RequiredArgsConstructor
@Validated
@Tag(name = "Cart Service", description = "Cart service include carts and cart_items")
public class CartController {

    private final CartService cartService;

    @GetMapping
    @Operation(summary = "Get a single cart", description = "Get a single cart based on the customer id")
    public ResponseEntity<ApiResponse<CartResponse>> getCart(
            @PathVariable
            @Positive(message = "Customer ID must be > 0")
            Long customerId
    ) {
        CartResponse response = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok(ApiResponse.success("Cart retrieved successfully.", response));
    }

    @PostMapping("/items")
    @Operation(summary = "Add a new item", description = "Adding a new product in a cart by using customer id")
    public ResponseEntity<ApiResponse<CartResponse>> addItem(
            @PathVariable
            @Positive(message = "Customer Id must be > 0")
            Long customerId,

            @Valid @RequestBody AddCartItemRequest request
    ) {
        CartResponse response = cartService.addItem(customerId, request);
        return ResponseEntity.ok(ApiResponse.success("Product added to the cart successfully", response));
    }

    @PutMapping("/items/{cartItemId}")
    @Operation(summary = "Update a cart", description = "Update a cart item based on customer id")
    public ResponseEntity<ApiResponse<CartResponse>> updateItem(
            @PathVariable
            @Positive(message = "Customer ID must be > 0")
            Long customerId,

            @PathVariable
            @Positive(message = "Cart Item ID must be > 0")
            Long cartItemId,

            @Valid @RequestBody UpdateCartItemRequest request
    ) {
        CartResponse response = cartService.updateItem(customerId, cartItemId, request);
        return ResponseEntity.ok(ApiResponse.success("cart item updated success", response));
    }

    @DeleteMapping("/items/{cartItemId}")
    @Operation(summary = "Remove a cart", description = "Remove a cart by using the customer id")
    public ResponseEntity<ApiResponse<CartResponse>> removeItem(
            @PathVariable
            @Positive(message = "Customer id must be > 0")
            Long customerId,

            @PathVariable
            @Positive(message = "Cart Item ID must be > 0")
            Long cartItemId
    ) {
        CartResponse response = cartService.removeItem(customerId, cartItemId);
        return ResponseEntity.ok(ApiResponse.success("Cart item removed success", response));
    }

    @DeleteMapping
    @Operation(summary = "Complete cart clear", description = "Remove all the cart products by getting customer id")
    public ResponseEntity<ApiResponse<CartResponse>> clearCart(
            @PathVariable
            @Positive(message = "Customer id must be > 0")
            Long customerId
    ) {
        CartResponse response = cartService.clearCart(customerId);
        return ResponseEntity.ok(ApiResponse.success("Cart cleared successfully.", response));
    }

}
