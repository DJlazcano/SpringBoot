package com.example.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ORDER_HISTORY", schema="shoppingcart")
public class OrderHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "purchase_date", nullable = false)
    private LocalDateTime purchaseDate;

    public OrderHistory(){}

    public OrderHistory(User user, Product product, int quantity){
        this.user = user;
        this.product= product;
        this.quantity = quantity;
        this.purchaseDate=LocalDateTime.now();
    }

    public void save(OrderHistory orderHistory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
