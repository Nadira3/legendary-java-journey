package com.example.myapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.myapp.UserModel;
import com.example.myapp.UserService;
import com.example.myapp.UserPageResponseDto;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<UserPageResponseDto> getAllUsers(Pageable pageable) {
		Page<UserModel> users = userService.getAllUsers(pageable);

		UserPageResponseDto response = new UserPageResponseDto(users.getContent());
		return ResponseEntity.ok(response);
	}
}
