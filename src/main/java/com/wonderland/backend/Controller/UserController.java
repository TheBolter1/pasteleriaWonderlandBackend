package com.wonderland.backend.Controller;

import com.wonderland.backend.Model.User;
import com.wonderland.backend.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

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
}
