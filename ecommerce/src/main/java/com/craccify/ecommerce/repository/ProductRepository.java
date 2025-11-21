package com.craccify.ecommerce.repository;

import com.craccify.ecommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    HashMap<Long, Product> productList = new HashMap<Long, Product>();

    public Product addProduct(Product product) {
        return productList.put(product.getId(), product);
    }

    public List<Product> getProducts() {
        return productList.values().stream().collect(Collectors.toList());
    }

    public Product updateProduct(Long id, Product product){
        return productList.put(id, product);
    }

    public boolean deleteProduct(Long id){
        return productList.remove(id)!=null;
    }

}
