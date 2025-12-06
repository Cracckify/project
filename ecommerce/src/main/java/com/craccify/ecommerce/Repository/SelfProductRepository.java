package com.craccify.ecommerce.Repository;

import com.craccify.ecommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class SelfProductRepository {
    HashMap<Long, Product> productDb = new HashMap<>();
    public Product createProduct(Product product){
        productDb.put(product.getId(),product);
        return  product;
    }
    public Product getProductById(Long id){
        return productDb.get(id);
    }

    public String deleteProduct(Long id){
       return String.valueOf(productDb.remove(id));
    }

}
