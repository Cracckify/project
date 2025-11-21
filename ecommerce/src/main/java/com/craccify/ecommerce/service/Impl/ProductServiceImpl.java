package com.craccify.ecommerce.service.Impl;

import com.craccify.ecommerce.model.Product;
import com.craccify.ecommerce.repository.ProductRepository;
import com.craccify.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.addProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.updateProduct(id, product);
    }

    @Override
    public Boolean deleteProduct(Long id) {
        return productRepository.deleteProduct(id);
    }
}
