package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.User;
import com.example.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public Optional<User> findByName(String name){
        return userRepository.findByName(name);
    }

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String insertUser(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            return "User Already Exists!";
        }else{
            userRepository.save(user);
            return "User created!";
        }
    }

    public String updateUser(int id, String email, String areaOfInterest) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setEmail(email);
            user.setArea_of_interest(areaOfInterest);
            userRepository.save(user);
            return "User updated!";
        }else{
            return "User Not Found";
        }
    }

    public String deletrUser(int id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User Deleted!";
        }else{
            return "User Not Found";
        }
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserByName(String name){
        return userRepository.findByName(name);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
