package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;
import com.example.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @PostMapping("/insert")
    public String insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody String email, @RequestBody String areaOfInterest) {
        return userService.updateUser(id, email, areaOfInterest);
    }

    @DeleteMapping("/delete/{id}")
    public String requestMethodName(@RequestParam int id) {
        return userService.deletrUser(id);
    }
    
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/name/{name}")
    public Optional<User> getUserByName(@RequestParam String name) {
        return userService.getUserByName(name);
    }
    
    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}
