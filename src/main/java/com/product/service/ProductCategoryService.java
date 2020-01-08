package com.product.service;

import com.product.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory getProductCategory(final String categoryName);

    List<ProductCategory> getAllProductCategory();

    String createProductCategory(final ProductCategory productCategory);

    String deleteProductCategory(final String categoryName);

}
