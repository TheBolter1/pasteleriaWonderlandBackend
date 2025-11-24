package com.wonderland.backend.Service;

import com.wonderland.backend.Model.Carrito;
import com.wonderland.backend.Repository.CarritoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    // Obtener todos los carritos
    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    // Buscar un carrito por ID
    public Optional<Carrito> findById(Long id) {
        return carritoRepository.findById(id);
    }

    // Guardar o actualizar un carrito
    public Carrito save(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    // Eliminar un carrito por ID
    public void delete(Long id) {
        carritoRepository.deleteById(id);
    }

}
