package com.ecm.ecommerce.controller;
import com.ecm.ecommerce.models.FakeStoreProduct;
import com.ecm.ecommerce.models.Product;
import com.ecm.ecommerce.services.ExternalStoreService;
import com.ecm.ecommerce.services.FakeProductService;
import com.ecm.ecommerce.services.ProductService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("selfProductService")
    ProductService productService;

    @Autowired
    @Qualifier("externalStoreService")
    FakeProductService externalProduct;

    @PostMapping("/create")
    public String CreateProduct(@RequestBody Product product){

        try {

            if (product.getTitle()==null) throw new RuntimeException("Title is Mandatory...");
            productService.createProduct(product);
            return "Product Created...";

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }


    @GetMapping("/get")
    public String getProductName(@RequestParam String name,@RequestParam(defaultValue = "Unknown") String shortname){
        return "Given Product Name="+name+" ShortName="+shortname;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PatchMapping("/{id}")
    public String updateDesc(@PathVariable int id, @RequestBody Product product){
        productService.updateProduct(id,product);
        return "Updated Successfully";
    }

    @DeleteMapping("delete")
    public String deleteProductbyId(@RequestParam Integer id){
        productService.deleteProduct(id);
        return "Product Removed";
    }


    @RequestMapping("/")
    public String Notify(){
        return "Application Started...";
    }


    @RequestMapping("/ext")
    public FakeStoreProduct getExternalProductbyId(@RequestParam int id){
        return externalProduct.getProductById(id);
    }

}
