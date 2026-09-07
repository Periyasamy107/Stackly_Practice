package com.example.order.inventory.repository;

import com.example.order.inventory.entity.Inventory;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByProductId(Long productId);

    boolean existsByProductId(Long productId);

    Page<Inventory> findByAvailableQuantityGreaterThan(Integer quantity, Pageable pageable);

    @Query("select i from Inventory i where i.availableQuantity <= :quantity")
    Page<Inventory> findLowStockInventories(@Param("quantity") Integer quantity, Pageable pageable);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select i from Inventory i where i.product.id = :productId")
    Optional<Inventory> findByProductIdForUpdate(@Param("productId") Long productId);

    List<Inventory> findByAvailableQuantityLessThanEqual(Integer quantity);

}
