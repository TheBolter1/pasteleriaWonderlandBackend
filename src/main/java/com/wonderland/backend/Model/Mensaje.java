package com.wonderland.backend.Model;
import jakarta.persistence.*;
@Entity
@Table(name = "mensajes")
public class Mensaje {
   


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;
    private String nombre;
    private String correo;
    private String orden;

    @Column(length = 2000)
    private String mensaje;

    public Mensaje() {
    }

    public Mensaje(String fecha, String nombre, String correo, String orden, String mensaje) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.correo = correo;
        this.orden = orden;
        this.mensaje = mensaje;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

    

