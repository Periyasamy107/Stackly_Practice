package com.example.order.product.repository;

import com.example.order.product.entity.Product;
import com.example.order.product.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

    List<Product> findByActiveTrue();

    Page<Product> findByActiveTrue(Pageable pageable);

    Page<Product> findByCategoryAndActiveTrue(ProductCategory category, Pageable pageable);

    @Query("select p from Product p where p.active = true and lower(p.name) like lower(concat('%', :name, '%'))")
    Page<Product> searchActiveProductsByName(@Param("name") String name, Pageable pageable);

    @Query("select p from Product p where lower(p.name) like lower(concat('%', :name, '%'))")
    Page<Product> searchAllProductsByName(@Param("name") String name, Pageable pageable);

    @Query("select p from Product p where p.active=true and p.price between :minPrice and :maxPrice")
    Page<Product> findActiveProductsByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice, Pageable pageable);

    @Query(value = "select * from products where active = true and category = :category",
        countQuery = "select count(*) from products where active = true and category = :category", nativeQuery = true)
    Page<Product> findActiveProductsByCategoryNative(@Param("category") String category, Pageable pageable);

}
