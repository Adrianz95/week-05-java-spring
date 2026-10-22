
package com.example.productapi.service;

import com.example.productapi.service.ProductService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private final ProductService productService = new ProductService();

    @Test
    void findAllReturnsThreeProducts() {
        var products = productService.findAll();

        assertEquals(3, products.size());
        assertEquals("Teclado", products.get(0).name());
        assertEquals(49.99, products.get(0).price(), 0.001);
    }
}
