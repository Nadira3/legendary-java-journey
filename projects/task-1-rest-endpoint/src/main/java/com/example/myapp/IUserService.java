package com.example.myapp;

import java.util.List;
import java.util.Optional;

import com.example.myapp.UserModel;

import org.springframework.data.domain.Page;


public interface IUserService {
	UserModel saveUser(UserModel user);
	Optional<UserModel> getUserById(Long id);
	Page<UserModel> getAllUsers();
}
