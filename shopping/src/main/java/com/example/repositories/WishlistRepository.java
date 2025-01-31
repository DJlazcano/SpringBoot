package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.User;
import com.example.models.Wishlist;

@Repository
public interface  WishlistRepository extends JpaRepository<Wishlist, Integer> {
    Wishlist findByUser(Optional<User> user);
    void deleteByUser(Optional<User> user);
}
