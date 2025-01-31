package com.example.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Wishlist;
import com.example.services.WishlistService;



@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService){
        this.wishlistService = wishlistService;
    }

    @PostMapping("/add}")
    public String addToWishlist(@RequestParam int userId, @RequestParam int product_id) {
        return wishlistService.addToWishlist(userId, product_id);
    }
    
    @GetMapping("/{userId}")
    public Wishlist getUserWishlist(@PathVariable int userId) {
        return wishlistService.getUserWishlist(userId);
    }

    @DeleteMapping("/remove-product")
    public String removeProdictFromWishlist(@RequestParam int user_id, @RequestParam int product_id){
        return wishlistService.removeProductFromWishlist(user_id, product_id);
    }

    @DeleteMapping("/clearWishlist/{userId}")
    public String deleteWishlist(@PathVariable int userId){
        return wishlistService.deleteWishList(userId);
    }
}
