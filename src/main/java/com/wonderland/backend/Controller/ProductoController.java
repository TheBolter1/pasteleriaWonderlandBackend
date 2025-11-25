package com.wonderland.backend.Controller;

import com.wonderland.backend.Model.Producto;
import com.wonderland.backend.Service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = productoService.findAll();
        if (productos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable String id) {
        Producto producto = productoService.findById(id);
        if (producto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable String id, @RequestBody Producto producto) {
        Producto proExistente = productoService.findById(id);
        if (proExistente == null) return ResponseEntity.notFound().build();

        proExistente.setNombre(producto.getNombre());
        proExistente.setPrecio(producto.getPrecio());
        proExistente.setCategoria(producto.getCategoria());
        proExistente.setImagen(producto.getImagen());

        productoService.save(proExistente);
        return ResponseEntity.ok(proExistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id) {
        Producto proExistente = productoService.findById(id);
        if (proExistente == null) return ResponseEntity.notFound().build();
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
