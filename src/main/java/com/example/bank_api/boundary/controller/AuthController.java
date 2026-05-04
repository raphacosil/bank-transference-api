package com.example.bank_api.boundary.controller;

import com.example.bank_api.boundary.Authorization;
import com.example.bank_api.boundary.LoginRequest;
import com.example.bank_api.boundary.contract.AuthContract;
import com.example.bank_api.domain.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication", description = "Endpoints for authentication and authorization")
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController implements AuthContract {

    private final AuthService authService;

    public ResponseEntity<Authorization> login(LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}

