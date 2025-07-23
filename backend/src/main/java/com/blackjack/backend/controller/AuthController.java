package com.blackjack.backend.controller;


import com.blackjack.backend.dto.JwtResponse;
import com.blackjack.backend.dto.LoginRequest;
import com.blackjack.backend.dto.RegisterRequest;
import com.blackjack.backend.dto.UserProfileResponse;
import com.blackjack.backend.security.UserDetailsImpl;
import com.blackjack.backend.service.AuthService;
import com.blackjack.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterRequest registerRequest){
        authService.register(registerRequest);
    }

    @PostMapping("/login")
    public JwtResponse login(@Valid @RequestBody LoginRequest loginRequest){
        String token = authService.login(loginRequest);
        return new JwtResponse(token);
    }

    @GetMapping("/profile")
    public UserProfileResponse profile(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return userService.getUserProfile(userDetails.getId());
    }
}
