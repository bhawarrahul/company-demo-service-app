package com.product.service;

import com.product.entity.ProductCategory;
import com.product.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final static String PRODUCT_CATEGORY_EXISTS = "Product Category Already Exists!";
    private final static String PRODUCT_CATEGORY_NOT_EXISTS = "Product Category Not Exists!";
    private final static String PRODUCT_CATEGORY_ADDED = "Product Category Added successfully";
    private final static String PRODUCT_CATEGORY_DELETED = "Product Category deleted successfully!";

    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Override
    public ProductCategory getProductCategory(final String categoryName) {
        return productCategoryRepository.findByName(categoryName);
    }


    @Override
    public List<ProductCategory> getAllProductCategory() {
        return productCategoryRepository.findAll();
    }

    @Override
    public String createProductCategory(final ProductCategory productCategory) {
        String saveProductMsg = PRODUCT_CATEGORY_EXISTS;
        if (!productCategoryRepository.existsByName(productCategory.getName())) {
            productCategoryRepository.save(productCategory);
            saveProductMsg = PRODUCT_CATEGORY_ADDED;
        }
        return saveProductMsg;
    }

    @Override
    @Transactional()
    public String deleteProductCategory(final String categoryName) {
        String productDeleteMsg = PRODUCT_CATEGORY_NOT_EXISTS;
        if (productCategoryRepository.existsByName(categoryName)) {
            productCategoryRepository.deleteByName(categoryName);
            productDeleteMsg = PRODUCT_CATEGORY_DELETED;
        }
        return productDeleteMsg;
    }
}
