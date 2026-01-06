package com.ecm.ecommerce.repositories;

import com.ecm.ecommerce.models.Product;
import com.ecm.ecommerce.services.ProductService;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class SelfProductRepository {

    HashMap<Integer, Product> productDb =new HashMap<>();

    public Product createProduct(Product product){
        productDb.put(product.getID(),product);
        return product;
    }

    public Product getProductById(Integer id) {
        return productDb.get(id);
    }

    public Product delete(Integer id) {
        productDb.remove(id);
        return null;
    }

    public Product Update(Integer id, Product product) {
        if (!productDb.containsKey(id)) {
            throw new RuntimeException("Product not found");
        }

        productDb.put(id,product);
        return product;

    }

    public boolean exists(Integer id) {
        return productDb.containsKey(id);
    }


    public Product update(Integer id, Product product) {
        productDb.put(id,product);
        return product;
    }


}
