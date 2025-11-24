package com.wonderland.backend.Controller;

import com.wonderland.backend.Model.Detalle;
import com.wonderland.backend.Service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle")
public class DetalleController {

    @Autowired
    private DetalleService detalleService;
    @GetMapping
    public ResponseEntity<List<Detalle>> listar() {
        List<Detalle> pedidos = detalleService.findAll();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Detalle> buscar(@PathVariable Long id) {
        try {
            Detalle pedido = detalleService.findById(id);
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity <Detalle> guardar(@RequestBody Detalle detalle) {
        Detalle nuevoPedido = detalleService.save(detalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle> actualizar(@PathVariable Long id, @RequestBody Detalle detalle) {
    try {
        Detalle existente = detalleService.findById(id);


        existente.setFechaPedido(detalle.getFechaPedido());
        existente.setUser(detalle.getUser());
        existente.setCarritos(detalle.getCarritos());

        Detalle actualizado = detalleService.save(existente);
        return ResponseEntity.ok(actualizado);

    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
}


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            detalleService.delete(id);
            return ResponseEntity.noContent().build();
        } catch ( Exception e ) {
            return ResponseEntity.notFound().build();
        }
    }

}
