package com.crackify.ecommerce.repository;

import com.crackify.ecommerce.entitties.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository {

    private HashMap<Long, Product> productDb = new HashMap<>();

    public Product getProductById(long id){
        return productDb.get(id);
    }

    public Product createProduct(Product product){
         productDb.put(product.getId(),product);
         return product;
    }

    public String deleteProduct(long id){
        return String.valueOf(productDb.remove(id));
    }
}
