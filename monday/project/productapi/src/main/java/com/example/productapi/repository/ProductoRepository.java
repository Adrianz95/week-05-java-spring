
package com.example.productapi.repository;

import com.example.productapi.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductoRepository {

    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong siguienteId = new AtomicLong(1);

    public ProductoRepository() {
        guardarNuevo("Teclado", 29.99);
        guardarNuevo("Ratón", 14.50);
    }

    public List<Producto> buscarTodos() {
        return List.copyOf(productos);
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productos.stream()
            .filter(producto -> producto.getId().equals(id))
            .findFirst();
    }

    public Producto guardarNuevo(String nombre, double precio) {
        Producto producto = new Producto(
            siguienteId.getAndIncrement(),
            nombre,
            precio
        );

        productos.add(producto);
        return producto;
    }

    public boolean eliminar(Long id) {
        return productos.removeIf(
            producto -> producto.getId().equals(id)
        );
    }
}