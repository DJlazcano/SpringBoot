package com.example.services;

import com.example.repositories.ProductRepository;
import com.example.repositories.UserRepository;
import com.example.repositories.WishlistRepository;

public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WishlistService(WishlistRepository wishlistRepository, UserRepository userRepository, ProductRepository productRepository){
        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
}
