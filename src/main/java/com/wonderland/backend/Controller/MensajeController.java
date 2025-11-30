package com.wonderland.backend.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wonderland.backend.Model.Mensaje;
import com.wonderland.backend.Service.MensajeService;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    private final MensajeService mensajeService;


    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }


    @PostMapping
    public Mensaje crearMensaje(@RequestBody Mensaje mensaje) {
        return mensajeService.guardarMensaje(mensaje);
    }


    @GetMapping
    public List<Mensaje> obtenerMensajes() {
        return mensajeService.obtenerMensajes();
    }
}
