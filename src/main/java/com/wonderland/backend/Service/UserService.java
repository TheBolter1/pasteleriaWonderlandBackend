package com.wonderland.backend.Service;

import com.wonderland.backend.Model.User;
import com.wonderland.backend.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User crearUsuario(String correo, String password, String rol, String rut) {
        User u = new User();
        u.setCorreo(correo);
        u.setPasswordHash(password);
        u.setRol(rol);
        u.setRut(rut);
        u.setFechaRegistro(new Date());
        return repo.save(u);
    }
}


