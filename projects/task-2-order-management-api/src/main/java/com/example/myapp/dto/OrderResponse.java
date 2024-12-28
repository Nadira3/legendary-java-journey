package com.example.myapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderResponse(@NotBlank String productName, @NotNull Integer quantity) {
}
