package com.wonderland.backend.Service;

import com.wonderland.backend.Model.Mensaje;
import com.wonderland.backend.Repository.MensajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeService {

    private final MensajeRepository mensajeRepository;

    public MensajeService(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    public Mensaje guardarMensaje(Mensaje mensaje) {

     
        if (mensaje.getFecha() == null || mensaje.getFecha().isEmpty()) {
            mensaje.setFecha(java.time.LocalDate.now().toString());
        }

        return mensajeRepository.save(mensaje);
    }

    public List<Mensaje> obtenerMensajes() {
        return mensajeRepository.findAll();
    }
}