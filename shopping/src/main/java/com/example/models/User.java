package com.example.models;

import jakarta.persistence.Entity;  
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS", schema="shoppingcart")
public class User {
    @Id
    private int id;
    private String name;
    private String email;
    private String area_of_interest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArea_of_interest() {
        return area_of_interest;
    }

    public void setArea_of_interest(String area_of_interest) {
        this.area_of_interest = area_of_interest;
    }

}
