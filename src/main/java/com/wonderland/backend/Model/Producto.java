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
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private Integer precio;

@Column(nullable = false)
private String nombre;


private String imagen;


private String categoria;

@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonIgnore
private Set<Carrito> carritos;


}

