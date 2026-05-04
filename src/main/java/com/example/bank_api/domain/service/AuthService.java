package com.example.bank_api.domain.service;

import com.example.bank_api.boundary.Authorization;
import com.example.bank_api.boundary.LoginRequest;
import com.example.bank_api.config.security.JwtService;
import com.example.bank_api.domain.model.Customer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtService jwtService;

    public AuthService(
            AuthenticationManager authManager,
            UserDetailsServiceImpl userDetailsService,
            JwtService jwtService
    ) {
        this.authManager = authManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    public Authorization login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request, request.password())
        );

        Customer customer = userDetailsService.findCustomerEntity(request.username());
        String token = jwtService.generateToken(customer);

        return new Authorization(token, "Bearer", 86400000L);
    }
}

