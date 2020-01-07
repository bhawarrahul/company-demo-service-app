package com.product.repository;

import com.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByPid(String productId);

    boolean existsByPid(String productId);

    void deleteByPid(String productId);
}
