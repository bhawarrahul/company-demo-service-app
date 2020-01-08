package com.product.repository;

import com.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findByName(String categoryName);

    boolean existsByName(String categoryName);

    void deleteByName(String categoryName);
}
