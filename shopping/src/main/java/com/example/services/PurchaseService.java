package com.example.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.models.OrderHistory;
import com.example.models.Product;
import com.example.models.User;
import com.example.repositories.OrderHistoryRepository;
import com.example.repositories.ProductRepository;
import com.example.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class PurchaseService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderHistoryRepository orderHistoryRepository;

    public PurchaseService(UserRepository userRepository,ProductRepository productRepository,OrderHistoryRepository orgHistoryRepository){
        this.userRepository=userRepository;
        this.productRepository=productRepository;
        this.orderHistoryRepository=orgHistoryRepository;
    }

    @Transactional
    public String buyProduct(int userId, int productId, int quantity){
        Optional<User> userO = userRepository.findById(userId);
        Optional<Product> productO = productRepository.findById(productId);

        if(userO.isEmpty() || productO.isEmpty() ){
            return "User or Product Not Found!";
        }else{
            User user = userO.get();
            Product product = productO.get();

            if(product.getTotal_products_inventory() < quantity){
                return "There is no more inventory for the product: " + product.getProductName();
            }else{
                product.setTotal_products_inventory(product.getTotal_products_inventory() - quantity);
                productRepository.save(product);

                OrderHistory orderHistory = new OrderHistory(user, product, quantity);
                orderHistoryRepository.save(orderHistory);

                return "Purchase successful!";
            }
        }
    }
}
