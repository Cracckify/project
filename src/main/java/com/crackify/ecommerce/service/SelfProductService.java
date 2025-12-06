package com.crackify.ecommerce.service;

import com.crackify.ecommerce.entitties.Product;
import com.crackify.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfProductService implements ProductService{

    @Autowired
    ProductRepository pr;

    @Override
    public Product getProduct(long id) {
        return pr.getProductById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return pr.createProduct(product);

    }

    @Override
    public String deleteproduct(long id) {
       return pr.deleteProduct(id);
    }
}
