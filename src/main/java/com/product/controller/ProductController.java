package com.product.controller;

import com.product.entity.Product;
import com.product.service.ProductService;
import com.product.utils.constants.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.PRODUCTS)
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(ApiConstants.PATH_VARIABLE_PRODUCT_ID)
    public ResponseEntity<Product> getProduct(@PathVariable final String productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProducts());
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
