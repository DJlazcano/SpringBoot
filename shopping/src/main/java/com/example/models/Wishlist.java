package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="WISHLIST", schema="shoppingcart")
public class Wishlist {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable= false)
    private User user;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    public Wishlist(){}

    public Wishlist(User user, Product product){
        this.user = user;
        this.product = product;
    }


}
