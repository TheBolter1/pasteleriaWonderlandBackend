package com.wonderland.backend.Service;

import com.wonderland.backend.Model.Empleado;
import com.wonderland.backend.Repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Empleado findByRut(String rut) {
        return empleadoRepository.findById(rut).orElse(null);
    }

    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void delete(String rut) {
        empleadoRepository.deleteById(rut);
    }
}
