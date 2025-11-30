package com.wonderland.backend.Controller;

public class LoginResponse {
    public String token;
    public String correo;
    public String rol;
    public String nombres;
    public String apellidos;

    public LoginResponse(String token, String correo, String rol, String nombres, String apellidos) {
        this.token = token;
        this.correo = correo;
        this.rol = rol;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
}
