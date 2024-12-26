package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import com.example.myapp.UserModel;
import com.example.myapp.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserModel> getUserById(Long id) {
	return userRepository.findById(id)
		.map(user -> Optional.of(user))
		.orElse(Optional.empty());
    }

    public UserModel saveUser(UserModel user) {
	return userRepository.save(user);
    }

    public Page<UserModel> getAllUsers(Pageable pageable) {
	return userRepository.findAll(pageable);
    }

}
