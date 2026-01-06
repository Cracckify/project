package com.ecm.ecommerce.services;

import com.ecm.ecommerce.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductService {
    public Product getProductById(Integer id);
    public Product createProduct(Product product);
    public List<Product> getAllProduct();
    public Product updateProduct(Integer id,Product product);
    public Product deleteProduct(Integer id);
}
