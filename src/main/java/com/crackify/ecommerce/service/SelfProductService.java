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
        return pr.getById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return pr.save(product);

    }

    @Override
    public String deleteproduct(long id) {
        pr.deleteById(id);
        return "product deleted  with id :"+ id;
    }
}
