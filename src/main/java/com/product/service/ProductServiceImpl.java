package com.product.service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final static String PRODUCT_EXISTS = "Product Already Exists!";
    private final static String PRODUCT_NOT_EXISTS = "Product Not Exists!";
    private final static String PRODUCT_ADDED = "Product Added successfully";
    private final static String PRODUCT_DELETED = "Product deleted successfully!";
    private final static String PRODUCT_UPDATED = "Product updated successfully!";

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product getProduct(final String productId) {
        return productRepository.findByPid(productId);
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String createProduct(final Product product) {
        String saveProductMsg = PRODUCT_EXISTS;
        if (!productRepository.existsByPid(product.getPid())) {
            productRepository.save(product);
            saveProductMsg = PRODUCT_ADDED;
        }
        return saveProductMsg;
    }


    @Override
    @Transactional()
    public String deleteProduct(final String productId) {
        String productDeleteMsg = PRODUCT_NOT_EXISTS;
        if (productRepository.existsByPid(productId)) {
            productRepository.deleteByPid(productId);
            productDeleteMsg = PRODUCT_DELETED;
        }
        return productDeleteMsg;
    }

    @Override
    public String updateProduct(final Product productUpdate) {
        String productUpdateMsg = PRODUCT_NOT_EXISTS;
        if (productRepository.existsByPid(productUpdate.getPid())) {
            Product product = productRepository.findByPid(productUpdate.getPid());
            productRepository.save(product);
            productUpdateMsg = PRODUCT_UPDATED;
        }
        return productUpdateMsg;
    }
}
