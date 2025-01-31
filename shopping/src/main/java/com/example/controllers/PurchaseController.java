package com.example.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.PurchaseService;


@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @PostMapping("/{userId}/{productId}/{quantity}")
    public String buyProduct(@PathVariable int userId, @PathVariable int productId, @PathVariable int quantity) {
        return purchaseService.buyProduct(userId, productId, quantity);
    }
    
}
