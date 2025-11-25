package com.wonderland.backend.Service;

import com.wonderland.backend.Model.Detalle;
import com.wonderland.backend.Repository.DetalleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class DetalleService {
    @Autowired
    private DetalleRepository detalleRepository;

    public List<Detalle> findAll() {
        return detalleRepository.findAll();
    }

    public Detalle findById(String id) {
        return detalleRepository.findById(id).orElse(null);
    }

    public Detalle save(Detalle detalle ) {
        return detalleRepository.save(detalle);
    }

    public void delete(String id) {
        detalleRepository.deleteById(id);
    }
}
