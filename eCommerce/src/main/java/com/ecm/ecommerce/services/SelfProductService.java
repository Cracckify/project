package com.ecm.ecommerce.services;

import com.ecm.ecommerce.models.Product;
import com.ecm.ecommerce.repositories.SelfProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class SelfProductService implements ProductService{

    @Autowired
    SelfProductRepository selfProductRepository;

    @Override
    public Product getProductById(Integer id) {
        return selfProductRepository.getProductById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return selfProductRepository.createProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product updateProduct(Integer id, Product newData) {

        Product existing=selfProductRepository.getProductById(id);

        if (existing == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found");
        }


        if (newData.getDescription() != null) {
            existing.setDescription(newData.getDescription());
        }

        return selfProductRepository.update(id, existing);
    }


    @Override
    public Product deleteProduct(Integer id) {
        return selfProductRepository.delete(id);
    }
}
