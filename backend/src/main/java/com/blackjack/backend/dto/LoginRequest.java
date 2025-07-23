package com.blackjack.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Email or username are required")
    private String usernameOrEmail;

    @NotBlank(message = "Password is required")
    private String password;
}
