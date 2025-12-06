package com.cracckify.ecommerce.services;


import com.cracckify.ecommerce.models.Product;
import com.cracckify.ecommerce.repositories.SelfProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService{

    @Autowired
    SelfProductRepository selfProductRepository;

    @Override
    public Product getProductById(Long id) {
        return selfProductRepository.getProductById(id);
    }

    public Product createProduct(Product product) {

        return selfProductRepository.createProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
