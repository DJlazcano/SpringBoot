package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
}
