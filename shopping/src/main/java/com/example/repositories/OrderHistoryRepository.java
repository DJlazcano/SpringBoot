package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.OrderHistory;

@Repository
public interface  OrderHistoryRepository extends JpaRepository<OrderHistory, Integer>{
    
}
