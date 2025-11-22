package com.cracckify.ecommerce.repositories;


import com.cracckify.ecommerce.models.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class SelfProductRepository {

    HashMap<Long, Product> productDB = new HashMap<>();

    public Product createProduct(Product product){
        productDB.put(product.getId(), product);
        return product;
    }

    public Product getProductById(Long id){

        return productDB.get(id);
    }
}

