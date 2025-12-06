package com.craccify.ecommerce.Service;

import com.craccify.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    public  Product getProductById(Long id);
    public Product createProduct(Product product);
    public String deleteProduct(Long id);

}
