package com.example.bank_api.boundary.dto;

public record Authorization(
        String token,
        String tokenType,
        Long expiresIn
) {}

