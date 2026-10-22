
package com.example.productapi.dto;

public record ProductResponse(
        Long id,
        String name,
        double price
) {}
