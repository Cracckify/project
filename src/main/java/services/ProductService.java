package services;


import models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(new Product(1,"sound-bar", "plays music", 10000),
            new Product(2,"laptop", "used for coding", 50000),
            new Product(3,"television", "entertainment", 60000),
            new Product(4,"books", "reading", 500));


    public List<Product> getProducts() {
        return products;
    }


    public void saveProduct(Product product) {
        products.add(product);
    }

    public Product getproductById(int id) {
        return products.stream().filter(p-> p.getId() == id).findFirst().orElse(null);
    }

    public void deleteProductById(int id) {
        Product eligibleForRemoving = products.stream().filter(p-> p.getId() == id).findFirst().orElse(null);
        if(eligibleForRemoving != null) {
            products.remove(eligibleForRemoving);
        }
    }

}
