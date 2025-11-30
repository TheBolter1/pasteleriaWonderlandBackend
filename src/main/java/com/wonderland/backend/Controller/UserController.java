package com.wonderland.backend.Controller;

import com.wonderland.backend.Configuration.JwtUtil;
import com.wonderland.backend.Model.User;
import com.wonderland.backend.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User u = service.crearUsuario(
                user.getCorreo(),
                user.getPasswordHash(),
                user.getRol(),
                user.getRut()
        );
        return ResponseEntity.ok(u);
    }

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest req) {

    User user = service.findByCorreo(req.getCorreo()).orElse(null);

    if (user == null) {
        return ResponseEntity.status(401).body("Usuario no encontrado");
    }

    if (!user.getPasswordHash().equals(req.getContrasena())) {
        return ResponseEntity.status(401).body("Contraseña incorrecta");
    }


    String token = jwtUtil.generarToken(user.getCorreo(), user.getRol());

    return ResponseEntity.ok(
        new LoginResponse(
            token,
            user.getCorreo(),
            user.getRol(),
            user.getNombres(),
            user.getApellidos()
        )
    );
}


    @GetMapping
    public ResponseEntity<List<User>> listar() {
        List<User> usuarios = service.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<User> buscar(@PathVariable Long id) {
        Optional<User> usuario = service.findById(id);
        return usuario.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

   @GetMapping("/correo/{correo}")
    public ResponseEntity<User> buscarPorCorreo(@PathVariable String correo) {
    return service.findByCorreo(correo)
                  .map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
}



 
    @PutMapping("/{id}")
    public ResponseEntity<User> actualizar(@PathVariable Long id, @RequestBody User user) {
        Optional<User> actualizado = service.update(id, user);
        return actualizado.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
