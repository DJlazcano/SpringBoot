package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCTS", schema="shoppingcart")
public class Product {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String productName;
    private float price;
    private String image;
    private String description;
    private int total_products_inventory;
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal_products_inventory() {
        return total_products_inventory;
    }

    public void setTotal_products_inventory(int total_products_inventory) {
        this.total_products_inventory = total_products_inventory;
    }

    public boolean  getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
