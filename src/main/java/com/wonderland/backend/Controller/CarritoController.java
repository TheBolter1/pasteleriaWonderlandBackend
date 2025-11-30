package com.wonderland.backend.Controller;

import com.wonderland.backend.Model.Carrito;
import com.wonderland.backend.Service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public ResponseEntity<List<Carrito>> listar() {
        List<Carrito> carritos = carritoService.findAll();
        if (carritos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carritos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> buscar(@PathVariable Long id) {
        Optional<Carrito> carrito = carritoService.findById(id);
        return carrito.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carrito> register(@RequestBody Carrito carrito) {
        Carrito nuevoCarrito = carritoService.save(carrito);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCarrito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizar(@PathVariable Long id, @RequestBody Carrito carrito) {
        Optional<Carrito> car = carritoService.findById(id);
        if (car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        carrito.setId(id);
        Carrito actualizado = carritoService.save(carrito);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (carritoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        carritoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
