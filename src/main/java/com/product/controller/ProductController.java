package com.product.controller;

import com.product.entity.Product;
import com.product.service.ProductService;
import com.product.utils.constants.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.PRODUCTS)
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(ApiConstants.PATH_VARIABLE_PRODUCT_ID)
    public Product get(@PathVariable final String productId) {
        return productService.getProduct(productId);
    }

    @GetMapping()
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @PostMapping()
    public String create(@RequestBody final Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping(ApiConstants.PATH_VARIABLE_PRODUCT_ID)
    public String delete(@PathVariable final String name) {
        return productService.deleteProduct(name);
    }

    @PutMapping()
    public String update(@RequestBody final Product product) {
        return productService.updateProduct(product);
    }

}
