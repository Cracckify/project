package controllers;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.ProductService;

import java.util.List;

@RestController

@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/product")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/product")
    public void saveProduct(Product product) {
        productService.saveProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product getproductById(@PathVariable int id) {
        return productService.getproductById(id);
    }

    @DeleteMapping("product/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }
}
