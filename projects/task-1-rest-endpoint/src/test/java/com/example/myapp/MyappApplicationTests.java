package com.example.myapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.myapp.UserModel;
import com.example.myapp.UserPageResponseDto;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class MyappApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	private UserModel user;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void setUp() {
		user = new UserModel("Cher", "passwordcher", "cherjoie@example.com");
	}

	// Test CRUD Operations for the REST API
	@Test
	void shouldCreateNewUserWithValidInput() {
		// Verify that the user was created
		// assertThat(user.getId()).isNotNull();
		assertThat(user.getUsername()).isEqualTo("Cher");
		assertThat(user.getEmail()).isEqualTo("cherjoie@example.com");
		assertThat(user.getPassword()).isEqualTo("passwordcher");
	}

	@Test
	void shouldReturnAllUsers() {
		// verify that the /users endpoint returns all users
		ResponseEntity<UserPageResponseDto> response = restTemplate.getForEntity("http://localhost:8080/users", UserPageResponseDto.class);

		// Verify that the response is not null
		assertThat(response).isNotNull();

		// Verify that the response body is not null
		assertThat(response.getBody()).isNotNull();

		// Verufy the response status code
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Verify that the response body is an array of users
		assertThat(response.getBody().getUsers()).isNotNull();

		UserModel[] users = response.getBody().getUsers().toArray(new UserModel[0]);
		assertThat(users.length).isGreaterThan(0);
	}
}
