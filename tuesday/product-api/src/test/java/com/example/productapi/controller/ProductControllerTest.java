
package com.example.productapi.controller;

import com.example.productapi.controller.ProductController;
import com.example.productapi.dto.ProductResponse;
import com.example.productapi.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void findAll_shouldReturnStatus200() throws Exception {
        when(productService.findAll()).thenReturn(List.of(
                new ProductResponse(1L, "Teclado", 49.99),
                new ProductResponse(2L, "Ratón", 19.99),
                new ProductResponse(3L, "Monitor", 199.99)
        ));

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
    }

    @Test
    void findAll_shouldReturnThreeProducts() throws Exception {
        when(productService.findAll()).thenReturn(List.of(
                new ProductResponse(1L, "Teclado", 49.99),
                new ProductResponse(2L, "Ratón", 19.99),
                new ProductResponse(3L, "Monitor", 199.99)
        ));

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    void findAll_shouldReturnExpectedFirstProduct() throws Exception {
        when(productService.findAll()).thenReturn(List.of(
                new ProductResponse(1L, "Teclado", 49.99),
                new ProductResponse(2L, "Ratón", 19.99),
                new ProductResponse(3L, "Monitor", 199.99)
        ));

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Teclado"))
                .andExpect(jsonPath("$[0].price").value(49.99));
    }

    @Test
    void findAll_shouldReturnExpectedJsonFields() throws Exception {
        when(productService.findAll()).thenReturn(List.of(
                new ProductResponse(1L, "Teclado", 49.99),
                new ProductResponse(2L, "Ratón", 19.99),
                new ProductResponse(3L, "Monitor", 199.99)
        ));

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").exists())
                .andExpect(jsonPath("$[0].price").exists());
    }
}
