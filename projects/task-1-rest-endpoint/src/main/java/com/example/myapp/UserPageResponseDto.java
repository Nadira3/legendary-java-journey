package com.example.myapp;

import java.util.List;

import lombok.Data;

import com.example.myapp.UserModel;

@Data
public class UserPageResponseDto {
	private List<UserModel> users;

	public UserPageResponseDto() {
	}

	public UserPageResponseDto(List<UserModel> users) {
		this.users = users;
	}

	public List<UserModel> getUsers() {
		return users;
	}
}
