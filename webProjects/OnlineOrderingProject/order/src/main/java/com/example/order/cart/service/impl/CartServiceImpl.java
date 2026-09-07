package com.example.order.cart.service.impl;

import com.example.order.cart.dto.request.AddCartItemRequest;
import com.example.order.cart.dto.request.UpdateCartItemRequest;
import com.example.order.cart.dto.response.CartItemResponse;
import com.example.order.cart.dto.response.CartResponse;
import com.example.order.cart.entity.Cart;
import com.example.order.cart.entity.CartItem;
import com.example.order.cart.mapper.CartMapper;
import com.example.order.cart.repository.CartItemRepository;
import com.example.order.cart.repository.CartRepository;
import com.example.order.cart.service.CartService;
import com.example.order.common.exception.InvalidOrderException;
import com.example.order.common.exception.ResourceNotFoundException;
import com.example.order.customer.entity.Customer;
import com.example.order.customer.entity.CustomerStatus;
import com.example.order.customer.repository.CustomerRepository;
import com.example.order.product.entity.Product;
import com.example.order.product.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    @Override
    @Transactional
    public CartResponse getCartByCustomerId(Long customerId) {
        Customer customer = validateActiveCustomer(customerId);
        Cart cart = cartRepository.findByCustomerId(customerId).orElseGet(() -> createCart(customer));
        return buildCartResponse(cart);
    }

    @Override
    @Transactional
    public CartResponse addItem(Long customerId, AddCartItemRequest request) {
        Customer customer = validateActiveCustomer(customerId);

        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID : " + request.productId()));

        if(!product.isActive()) {
            throw new InvalidOrderException("Inactive product cannot be added to the cart");
        }

        Cart cart = cartRepository.findByCustomerId(customerId).orElseGet(() -> createCart(customer));
        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), product.getId()).orElse(null);

        if(cartItem==null) {
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(request.quantity());
            cart.addItem(cartItem);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + request.quantity());
        }

        cartRepository.save(cart);

        log.info("Product ID {} added to the cart for the customer id {}", product.getId(), customerId);

        return buildCartResponse(cart);
    }

    @Override
    @Transactional
    public CartResponse updateItem(Long customerId, Long cartItemId, UpdateCartItemRequest request) {

        validateActiveCustomer(customerId);

        Cart cart = findCartByCustomerId(customerId);
        CartItem cartItem = cartItemRepository.findByIdAndCartId(cartItemId, cart.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found with id : " + cartItemId));

        if(!cartItem.getProduct().isActive()) {
            throw new InvalidOrderException("Inactive product cannot remain in the cart");
        }

        cartItem.setQuantity(request.quantity());
        cartItemRepository.save(cartItem);

        log.info("Cart item id {} updated for customer id {}", cartItemId, customerId);

        return buildCartResponse(cart);
    }

    @Override
    @Transactional
    public CartResponse removeItem(Long customerId, Long cartItemId) {

        validateActiveCustomer(customerId);
        Cart cart = findCartByCustomerId(customerId);
        CartItem cartItem = cartItemRepository.findByIdAndCartId(cartItemId, cart.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cart item cannot found with ID : " + cartItemId));
        cart.removeItem(cartItem);
        cartItemRepository.delete(cartItem);
        log.info("Cart item id {} removed for customer id {}", cartItemId, customerId);
        return buildCartResponse(cart);

    }

    @Override
    @Transactional
    public CartResponse clearCart(Long customerId) {
        validateActiveCustomer(customerId);
        Cart cart = findCartByCustomerId(customerId);
        cart.clearItems();
        cartRepository.save(cart);
        log.info("Cart cleared for customer id : ", customerId);
        return buildCartResponse(cart);
    }

    private Customer validateActiveCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id : " + customerId));
        if(customer.getStatus() != CustomerStatus.ACTIVE) {
            throw new InvalidOrderException("Inactive customer cannot access cart");
        }
        return customer;
    }

    private Cart findCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found for customer id : " + customerId));
    }

    private Cart createCart(Customer customer) {
        Cart cart = new Cart();
        cart.setCustomer(customer);
        Cart savedCart = cartRepository.save(cart);
        log.info("New cart created for customer id : {}", customer.getId());
        return savedCart;
    }

    private CartResponse buildCartResponse(Cart cart) {

        List<CartItemResponse> items = cart.getItems().stream().map(cartMapper::toCartItemResponse).toList();
        int totalItems = items.stream().mapToInt(CartItemResponse::quantity).sum();
        BigDecimal totalAmount = items.stream().map(CartItemResponse::totalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        return new CartResponse(
                cart.getId(),
                cart.getCustomer().getId(),
                cart.getCustomer().getUserName(),
                items,
                totalItems,
                totalAmount,
                cart.getCreatedDate(),
                cart.getLastModifiedDate(),
                cart.getVersion()
        );

    }

}
