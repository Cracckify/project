package com.craccify.ecommerce.service;

import com.craccify.ecommerce.model.Product;

import java.util.List;

public interface ProductService {

    public Product createProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product updateProduct(Long id, Product product);
    public  Boolean deleteProduct(Long id);
}
