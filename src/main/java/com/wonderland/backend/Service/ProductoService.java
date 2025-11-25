package com.wonderland.backend.Service;

import com.wonderland.backend.Model.Producto;
import com.wonderland.backend.Repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void delete(String id) {
        productoRepository.deleteById(id);
    }
}
