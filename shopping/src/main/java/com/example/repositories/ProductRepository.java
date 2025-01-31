package com.example.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    Product findByName(String name);
    List<Product> findByPrice(float price);
}
 
