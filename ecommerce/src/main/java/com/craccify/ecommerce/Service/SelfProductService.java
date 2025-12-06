package com.craccify.ecommerce.Service;

import com.craccify.ecommerce.Repository.SelfProductRepository;
import com.craccify.ecommerce.model.Product;
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

    @Override
    public Product createProduct(Product product) {
       return  selfProductRepository.createProduct(product);
    }

    @Override
    public String deleteProduct(Long id) {
        return selfProductRepository.deleteProduct(id);
    }

}
