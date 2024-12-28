package com.example.myapp.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class User {

    private Long id;
    private String username;
    private String email;


public User() {
}
    public User(String username, String email) {
	this.username = username;
	this.email = email;
    }

    // Getters and Setters
    
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return username;
    }

    public void setName(String name) {
	    this.username = name;
    }

    public String getEmail() {
	    return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    // toString method
    @Override
    public String toString() {
	return "User [id=" + id + ", name=" + username + ", email=" + email + "]";
    }

}
 
