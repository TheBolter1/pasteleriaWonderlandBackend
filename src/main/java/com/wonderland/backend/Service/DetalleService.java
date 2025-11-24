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
    private DetalleRepository pedidoRepository;

    public List<Detalle> findAll() {
        return pedidoRepository.findAll();
    }

    public Detalle findById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Detalle save(Detalle pedido ) {
        return pedidoRepository.save(pedido);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
}
