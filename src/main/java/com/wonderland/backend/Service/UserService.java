package com.wonderland.backend.Service;

import com.wonderland.backend.Model.User;
import com.wonderland.backend.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User crearUsuario(String correo, String password, String rol, String rut, String nombres, String apellidos) {
    User u = new User();
    u.setCorreo(correo);
    u.setPasswordHash(password);
    u.setRol(rol);
    u.setRut(rut);
    u.setNombres(nombres);
    u.setApellidos(apellidos);
    u.setFechaRegistro(new Date());
    return repo.save(u);
}

    public List<User> findAll() {
        return repo.findAll();
    }

    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    public Optional<User> findByCorreo(String correo) {
        return repo.findByCorreo(correo);
    }

    public Optional<User> update(Long id, User user) {
        return repo.findById(id).map(existing -> {

        
            existing.setCorreo(user.getCorreo());
            existing.setRol(user.getRol());
            existing.setRut(user.getRut());
            existing.setPasswordHash(user.getPasswordHash());
            existing.setNombres(user.getNombres());
            existing.setApellidos(user.getApellidos());

            return repo.save(existing);
        });
    }

    public boolean delete(Long id) {
        return repo.findById(id).map(u -> {
            repo.delete(u);
            return true;
        }).orElse(false);
    }
}
