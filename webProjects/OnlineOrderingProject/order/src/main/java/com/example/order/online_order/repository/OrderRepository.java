package com.example.order.online_order.repository;

import com.example.order.online_order.entity.Order;
import com.example.order.online_order.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);

    Page<Order> findByCustomerId(Long customerId, Pageable pageable);

    Page<Order> findByStatus(OrderStatus status, Pageable pageable);

    @Query("select o from Order o where o.customer.id = :customerId and o.status = :status")
    Page<Order> findByCustomerAndStatus(@Param("customerId") Long customerId, @Param("status") OrderStatus status, Pageable pageable);

    @Query("select o from Order o where o.createdDate between :startDate and :endDate")
    Page<Order> findOrdersByDateRange(@Param("startDate")LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, Pageable pageable);

    @Query(
            value = "select * from orders where customer_id = :customerId and status = :status",
            countQuery = "select count(*) from orders where customer_id = :customerId and status = :status",
            nativeQuery = true
    )
    Page<Order> findCustomersOrdersNative(@Param("customerId") Long customerId, @Param("status") String status, Pageable pageable);

}
