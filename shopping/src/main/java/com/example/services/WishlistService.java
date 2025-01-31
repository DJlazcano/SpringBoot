package com.example.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.models.Product;
import com.example.models.User;
import com.example.models.Wishlist;
import com.example.repositories.ProductRepository;
import com.example.repositories.UserRepository;
import com.example.repositories.WishlistRepository;

@Service
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WishlistService(WishlistRepository wishlistRepository, UserRepository userRepository, ProductRepository productRepository){
        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public String addToWishlist(int user_id, int product_id){
        Optional<User> user = userRepository.findById(user_id);
        Optional<Product> product = productRepository.findById(product_id);
    
        if(user == null || product == null){
            return "User or Product not Found!";
        }else{
            Wishlist wishlist = new Wishlist(user,product.get());
            wishlistRepository.save(wishlist);
            return "Product added to wishlist!";
        }
    }

    public Wishlist getUserWishlist(int user_id){
        Optional<User> user = userRepository.findById(user_id);
        return (user != null) ? wishlistRepository.findByUser(user) : null;
    }

    public String removeProductFromWishlist(int user_id, int product_id){
        Optional<User> user = userRepository.findById(user_id);
        Optional<Product> product = productRepository.findById(product_id);
        
        if(user == null || product == null){
            return "User or Product not found!";
        }

        Wishlist userWishlist = wishlistRepository.findByUser(user);
        if(userWishlist == null){
            return "Wishlist not Found!";
        }else{
            userWishlist.removeProduct(product.get());
            
            return "Product removed from Wishlist!";
        }
    }

    public String deleteWishList(int user_id){
        Optional<User> user = userRepository.findById(user_id);
        Wishlist wishlist = wishlistRepository.findByUser(user);

        if(user == null){ return "User not Found";}
        if(wishlist != null){
            wishlistRepository.deleteByUser(user);
            return "Wishlist Deleted!";
        }else{
                return "User not Found";
            }
    }
}
