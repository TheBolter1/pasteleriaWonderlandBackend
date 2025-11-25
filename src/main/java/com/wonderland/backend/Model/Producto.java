package com.wonderland.backend.Model;

import java.util.Set;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
@Id

private String id;

@Column(nullable = false)
private Integer precio;

@Column(nullable = false)
private String nombre;


private String imagen;


private String categoria;

@Column(length = 1000)
private String descripcion;

@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonIgnore
private Set<Carrito> carritos;
public Producto(String id, Integer precio, String nombre, String imagen, String categoria, String descripcion) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

}

