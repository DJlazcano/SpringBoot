package com.example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.User;
import com.example.models.Wishlist;

public class WishlistRepository extends JpaRepository<Wishlist, Integer> {
    List<Wishlist> findByUser(User user);
    void deleteByUser(User user);
}
