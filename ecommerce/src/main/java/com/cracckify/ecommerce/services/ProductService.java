package com.cracckify.ecommerce.services;

import com.cracckify.ecommerce.models.Product;
import java.util.List;


public interface ProductService {
    public Product getProductById(Long id);
    public Product createProduct(Product product);
    public List<Product> getAllProducts();
}