package com.example.models;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="WISHLIST", schema="shoppingcart")
public class Wishlist {
    @Id
    public int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable= false)
    private Optional<User> user;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private List<Product> products;

    public Wishlist(){}

    public Wishlist(Optional<User> user, Product product){
        this.user = user;
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }
}
