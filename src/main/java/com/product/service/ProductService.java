package com.product.service;

import com.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(final String productId);

    List<Product> getAllProducts();

    String createProduct(final Product product);

    String deleteProduct(final String productId);

    String updateProduct(final Product product);

}
