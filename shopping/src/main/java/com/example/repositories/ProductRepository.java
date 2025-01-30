package com.example.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    Optional<Product> findByName(String name);
    List<Product> findByPrice(float price);
}
 
