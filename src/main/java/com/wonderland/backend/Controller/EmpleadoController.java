
package com.wonderland.backend.Controller;

import com.wonderland.backend.Model.Empleado;
import com.wonderland.backend.Service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "http://localhost:5173")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    // GET /api/empleados
    @GetMapping
    public List<Empleado> listar() {
        return empleadoService.findAll();
    }

    // GET /api/empleados/{rut}
    @GetMapping("/{rut}")
    public ResponseEntity<Empleado> buscar(@PathVariable String rut) {
        Empleado emp = empleadoService.findByRut(rut);
        if (emp == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(emp);
    }

    // POST /api/empleados
    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        // rut es la PK, viene desde el front
        return empleadoService.save(empleado);
    }

    // PUT /api/empleados/{rut}
    @PutMapping("/{rut}")
    public ResponseEntity<Empleado> actualizar(@PathVariable String rut,
                                               @RequestBody Empleado datos) {
        Empleado emp = empleadoService.findByRut(rut);
        if (emp == null) return ResponseEntity.notFound().build();

        emp.setDv(datos.getDv());
        emp.setNombres(datos.getNombres());
        emp.setApellidos(datos.getApellidos());
        emp.setCorreo(datos.getCorreo());
        emp.setTelefono(datos.getTelefono());
        emp.setCargo(datos.getCargo());
        emp.setDireccion(datos.getDireccion());
        emp.setFecha_nacimiento(datos.getFecha_nacimiento());

        Empleado actualizado = empleadoService.save(emp);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE /api/empleados/{rut}
    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> eliminar(@PathVariable String rut) {
        Empleado emp = empleadoService.findByRut(rut);
        if (emp == null) return ResponseEntity.notFound().build();

        empleadoService.delete(rut);
        return ResponseEntity.noContent().build();
    }
}
