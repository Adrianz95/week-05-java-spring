
package com.example.productapi.service;

import com.example.productapi.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public List<ProductResponse> findAll() {
        return List.of(
                new ProductResponse(1L, "Teclado", 49.99),
                new ProductResponse(2L, "Ratón", 19.99),
                new ProductResponse(3L, "Monitor", 199.99)
        );
    }
}
