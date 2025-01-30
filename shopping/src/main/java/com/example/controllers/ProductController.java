package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Product;
import com.example.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productsService;

    @Autowired
    public ProductController(ProductService productService){
        this.productsService=productService;
    }

    @PostMapping("/insert")
    public String insertProduct(@RequestBody Product product){
        return productsService.insertProduct(product);
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product productData){
        return productsService.updateProduct(id,productData);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productsService.deleteProduct(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping("/name/{name}")
    public Optional<Product> getProductByName(@PathVariable String name){
        return productsService.getProductByName(name);
    }

    @GetMapping("/price/{price}")
    public List<Product> getProductByName(@PathVariable float price){
        return productsService.getProductsByPrice(price);
    }
}
