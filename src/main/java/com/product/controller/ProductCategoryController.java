package com.product.controller;

import com.product.entity.ProductCategory;
import com.product.service.ProductCategoryService;
import com.product.utils.constants.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.PRODUCTS_CATEGORY)
public class ProductCategoryController {


        @Autowired
        ProductCategoryService  productCategoryService;

        @GetMapping(ApiConstants.PATH_VARIABLE_CATEGORY_NAME)
        public ProductCategory getProductCategory(@PathVariable final String categoryName) {
            return productCategoryService.getProductCategory(categoryName);
        }

        @GetMapping()
        public List<ProductCategory> getAllProductCategory() {
            return productCategoryService.getAllProductCategory();
        }

        @PostMapping()
        public String create(@RequestBody final ProductCategory productCategory) {
            return productCategoryService.createProductCategory(productCategory);
        }

        @DeleteMapping(ApiConstants.PATH_VARIABLE_CATEGORY_NAME)
        public String delete(@PathVariable final String categoryName) {
            return productCategoryService.deleteProductCategory(categoryName);
        }
}
