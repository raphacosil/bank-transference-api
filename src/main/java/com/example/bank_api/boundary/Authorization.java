package com.example.bank_api.boundary;

public record Authorization(
        String token,
        String tokenType,
        Long expiresIn
) {}

