package com.example.myapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(@NotBlank String productName, @NotNull Integer quantity, @NotNull Long userId) {

	// Getters and setters are generated automatically
	public String getProductName() {
		return productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Long getUserId() {
		return userId;
	}
}
