package com.example.order.online_order.service.impl;

import com.example.order.cart.entity.Cart;
import com.example.order.cart.entity.CartItem;
import com.example.order.cart.repository.CartRepository;
import com.example.order.common.exception.InvalidOrderException;
import com.example.order.common.exception.ResourceNotFoundException;
import com.example.order.customer.entity.Customer;
import com.example.order.customer.entity.CustomerStatus;
import com.example.order.customer.repository.CustomerRepository;
import com.example.order.file.service.InvoiceService;
import com.example.order.inventory.service.InventoryService;
import com.example.order.online_order.dto.request.CreateOrderRequest;
import com.example.order.online_order.dto.response.OrderItemResponse;
import com.example.order.online_order.dto.response.OrderResponse;
import com.example.order.online_order.entity.Order;
import com.example.order.online_order.entity.OrderItem;
import com.example.order.online_order.entity.OrderStatus;
import com.example.order.online_order.event.OrderConfirmedEvent;
import com.example.order.online_order.mapper.OrderMapper;
import com.example.order.online_order.repository.OrderRepository;
import com.example.order.online_order.service.OrderService;
import com.example.order.payment.dto.response.PaymentResponse;
import com.example.order.payment.entity.PaymentStatus;
import com.example.order.payment.service.PaymentService;
import com.example.order.product.entity.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final InventoryService invertoryService;
    private final PaymentService paymentService;
    private final OrderMapper orderMapper;

    private final InvoiceService invoiceService;
    private final ApplicationEventPublisher applicationEventPublisher;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderResponse placeOrder(CreateOrderRequest request) {
        Customer customer = validateCustomer(request.customerId());
        Cart cart = validateCart(customer.getId());
        validateProducts(cart);
        validateInventory(cart);

        Order order = createOrderForTrans(customer, cart);
        Order savedOrder = orderRepository.save(order);

        reduceInventory(cart);
        savedOrder.setStatus(OrderStatus.PAYMENT_PROCESSING);
        orderRepository.saveAndFlush(savedOrder);

        PaymentResponse paymentResponse = paymentService.processPaymentForTransaction(savedOrder);
        if(paymentResponse.status() != PaymentStatus.SUCCESS) {
            throw new InvalidOrderException("Payment failed for Order ID : " + savedOrder.getId());
        }

        savedOrder.setStatus(OrderStatus.CONFIRMED);

        Order confirmedOrder = orderRepository.save(savedOrder);

        cart.clearItems();

//        cartRepository.save(cart);

        applicationEventPublisher.publishEvent(new OrderConfirmedEvent(this, confirmedOrder.getId()));

        log.info("Order {} completed successfully", confirmedOrder.getId());

        return buildOrderResponse(confirmedOrder);

    }


//    @Override
//    @Transactional
//    public OrderResponse createOrder(CreateOrderRequest request) {
//
//        Customer customer = validateActiveCustomer(request.customerId());
//
//        Cart cart = cartRepository.findByCustomerId(customer.getId())
//                .orElseThrow(() -> new InvalidOrderException("Cart not found for Customer ID : " + customer.getId()));
//        if(cart.getItems()==null || cart.getItems().isEmpty()) {
//            throw new InvalidOrderException("Cannot create order because the cart is empty");
//        }
//        validateCartItems(cart);
//
//        Order order = new Order();
//        order.setCustomer(customer);
//        order.setStatus(OrderStatus.PENDING);
//
//        BigDecimal totalAmount = BigDecimal.ZERO;
//
//        for(CartItem cartItem : cart.getItems()) {
//            OrderItem orderItem = new OrderItem();
//            orderItem.setProduct(cartItem.getProduct());
//            orderItem.setQuantity(cartItem.getQuantity());
//
//            BigDecimal productPrice = cartItem.getProduct().getPrice();
//            BigDecimal totalPrice = productPrice.multiply(BigDecimal.valueOf(cartItem.getQuantity()));
//
//            orderItem.setProductPrice(productPrice);
//            orderItem.setTotalPrice(totalPrice);
//
//            order.addOrderItem(orderItem);
//            totalAmount = totalAmount.add(totalPrice);
//        }
//
//        order.setTotalAmount(totalAmount);
//
//        Order savedOrder = orderRepository.save(order);
//
//        log.info("Order created successfully with ID : {} for the Customer ID : {}", savedOrder.getId(), customer.getId());
//
//        return buildOrderResponse(savedOrder);
//    }

    @Override
    public OrderResponse getOrderById(Long orderId) {
        Order order = findOrderById(orderId);
        return buildOrderResponse(order);
    }

    @Override
    public List<OrderResponse> getOrdersByCustomerId(Long customerId) {
        validateCustomerExists(customerId);
        return orderRepository.findByCustomerId(customerId).stream().map(this::buildOrderResponse).toList();
    }

    @Override
    public Page<OrderResponse> getOrdersByCustomerId(Long customerId, Pageable pageable) {
        validateCustomerExists(customerId);
        return orderRepository.findByCustomerId(customerId, pageable).map(this::buildOrderResponse);
    }

    @Override
    public Page<OrderResponse> getOrdersByStatus(OrderStatus status, Pageable pageable) {
        return orderRepository.findByStatus(status, pageable).map(this::buildOrderResponse);
    }

    @Override
    public Page<OrderResponse> getOrdersByCustomerAndStatus(Long customerId, OrderStatus status, Pageable pageable) {
        validateCustomerExists(customerId);
        return orderRepository.findByCustomerAndStatus(customerId, status, pageable).map(this::buildOrderResponse);
    }

    @Override
    public Page<OrderResponse> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        if(startDate==null || endDate==null) {
            throw new IllegalArgumentException("Start date and End date are required");
        }
        if(startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after End date");
        }
        return orderRepository.findOrdersByDateRange(startDate, endDate, pageable).map(this::buildOrderResponse);
    }

    @Override
    public Page<OrderResponse> getCustomerOrdersNative(Long customerId, String status, Pageable pageable) {
        validateCustomerExists(customerId);
        return orderRepository.findCustomersOrdersNative(customerId, status, pageable).map(this::buildOrderResponse);
    }

    private Customer validateCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found ID : " + customerId));
        if(customer.getStatus() != CustomerStatus.ACTIVE) {
            throw new InvalidOrderException("Invalid customer cannot place an order");
        }
        return customer;
    }

    private Cart validateCart(Long customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new InvalidOrderException("Cart not found for Customer ID : " + customerId));
        if(cart.getItems()==null || cart.getItems().isEmpty()) {
            throw new InvalidOrderException("Cannot place order because cart is empty");
        }
        return cart;
    }

    public void validateProducts(Cart cart) {
        for(CartItem cartItem : cart.getItems()) {
            Product product = cartItem.getProduct();
            if(product==null) {
                throw new InvalidOrderException("Cart contains invalid product");
            }
            if(!product.isActive()) {
                throw new InvalidOrderException("Product is inactive : " + product.getName());
            }
            if(cartItem.getQuantity()==null || cartItem.getQuantity()<=0) {
                throw new InvalidOrderException("Invalid quantity for product : " + product.getName());
            }
            if(product.getPrice()==null || product.getPrice().compareTo(BigDecimal.ZERO)<=0) {
                throw new InvalidOrderException("Invalid price for product : " + product.getName());
            }
        }
    }

    private void validateInventory(Cart cart) {
        for(CartItem cartItem : cart.getItems()) {
            invertoryService.validateInventoryAvailability(
                    cartItem.getProduct().getId(), cartItem.getQuantity()
            );
        }
    }

    private Order createOrderForTrans(Customer customer, Cart cart) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.PROCESSING);
        BigDecimal totalAmount = BigDecimal.ZERO;

        for(CartItem cartItem: cart.getItems()) {
            Product product = cartItem.getProduct();
            BigDecimal productPrice = product.getPrice();
            BigDecimal totalPrice = productPrice.multiply(BigDecimal.valueOf(cartItem.getQuantity()));

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setProductPrice(productPrice);
            orderItem.setTotalPrice(totalPrice);

            order.addOrderItem(orderItem);
            totalAmount = totalAmount.add(totalPrice);
        }

        order.setTotalAmount(totalAmount);
        return order;
    }

    private void reduceInventory(Cart cart) {
        for(CartItem cartItem : cart.getItems()) {
            invertoryService.reduceInventory(cartItem.getProduct().getId(), cartItem.getQuantity());
        }
    }

//    private Customer validateActiveCustomer(Long customerId) {
//        Customer customer = customerRepository.findById(customerId)
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID : " + customerId));
//        if(customer.getStatus() != CustomerStatus.ACTIVE) {
//            throw new InvalidOrderException("Inactive customer cannot create an order");
//        }
//        return customer;
//    }

    private void validateCustomerExists(Long customerId) {
        if(!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException("Customer not found with ID : " + customerId);
        }
    }

//    private void validateCartItems(Cart cart) {
//        for(CartItem cartItem : cart.getItems()) {
//            if(cartItem.getProduct()==null) {
//                throw new InvalidOrderException("Cart contains an invalid product");
//            }
//            if(!cartItem.getProduct().isActive()) {
//                throw new InvalidOrderException("Cart contains an inactive product : " + cartItem.getProduct().getName());
//            }
//            if(cartItem.getQuantity()==null || cartItem.getQuantity()<=0) {
//                throw new InvalidOrderException("Cart contains an invalid product quantity");
//            }
//            if(cartItem.getProduct().getPrice()==null || cartItem.getProduct().getPrice().compareTo(BigDecimal.ZERO)<=0) {
//                throw new InvalidOrderException("Cart contains a product with invalid price");
//            }
//        }
//    }

    private Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found with ID : " + orderId));
    }

    private OrderResponse buildOrderResponse(Order order) {

        List<OrderItemResponse> items = order.getOrderItems().stream().map(orderMapper::toOrderItemResponse).toList();
        int totalItems = items.stream().mapToInt(OrderItemResponse::quantity).sum();

        return new OrderResponse(
                order.getId(),
                order.getCustomer().getId(),
                order.getCustomer().getUserName(),
                order.getStatus(),
                items,
                totalItems,
                order.getTotalAmount(),
                order.getCreatedDate(),
                order.getCreatedBy(),
                order.getLastModifiedDate(),
                order.getLastModifiedBy(),
                order.getVersion()
        );
    }

}
