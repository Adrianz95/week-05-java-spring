package com.example.productapi.service;

import com.example.productapi.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductoService {

    private final List<Producto> lista = new ArrayList<>();

    public List<Producto> listar() {
        return lista;
    }

    public Producto buscarPorId(Long id) {
        return lista.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Producto no encontrado con ID: " + id
                ));
    }

    public Producto guardar(Producto producto) {
        validarPrecio(producto.getPrecio());
        lista.add(producto);
        return producto;
    }

    public Producto actualizar(Long id, Producto productoNuevo) {
        validarPrecio(productoNuevo.getPrecio());
        Producto productoExistente = buscarPorId(id); // Si no existe, ya lanza el 404 automáticamente
        
        productoExistente.setNombre(productoNuevo.getNombre());
        productoExistente.setPrecio(productoNuevo.getPrecio());
        
        return productoExistente;
    }

    public void eliminar(Long id) {
        Producto productoExistente = buscarPorId(id); // Asegura que existe antes de borrar
        lista.removeIf(p -> Objects.equals(p.getId(), id));
    }

    // Método auxiliar privado para validar el precio
    private void validarPrecio(Double precio) {
        if (precio != null && precio < 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El precio no puede ser negativo."
            );
        }
    }
}
