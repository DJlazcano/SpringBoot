package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.models.Product;
import com.example.repositories.ProductRepository;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public String insertProduct(Product product){
        Optional<Product> existsProduct = productRepository.findByName(product.getProductName());
        if(existsProduct.isPresent()){
            Product product1 = existsProduct.get();
            product1.setTotal_products_inventory(product1.getTotal_products_inventory() + 1);
            productRepository.save(product1);
            return "Product exists, Product Inventory Updated!";
        }else{
            productRepository.save(product);
            return "Product Created!";
        }
    }

    public String updateProduct(int id, Product productData){
            Optional<Product> existingProd = productRepository.findById(id);
            if(existingProd.isPresent()){
                Product product = existingProd.get();
                product.setPrice(productData.getPrice());
                product.setImage(productData.getImage());
                product.setDescription(productData.getDescription());
                product.setTotal_products_inventory(productData.getTotal_products_inventory());
                productRepository.save(product);
                return "Product Data Updated!";
            }else{
                return "Product Not Found!";
            }
        }

        public String deleteProduct(int id){
            Optional<Product> existingProduct = productRepository.findById(id);
            if(existingProduct.isPresent()){
                Product product = existingProduct.get();
                product.setStatus(false);
                productRepository.save(product);
                return "Product Deleted";
            }else{
                return "Product Not Found";
            }
        }

        public List<Product> getAllProducts(){
            return productRepository.findAll();
        }

        public Optional<Product> getProductByName(String productName){
            return productRepository.findByName(productName);
        }

        public List<Product> getProductsByPrice(float price){
            return productRepository.findByPrice(price);
        }
    }
