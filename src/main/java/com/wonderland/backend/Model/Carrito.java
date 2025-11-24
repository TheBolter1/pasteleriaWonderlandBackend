package com.wonderland.backend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {

    @EmbeddedId
    private CarritoId id;

    @Column(nullable = false)
    private Integer subtotal;

    @Column(nullable = false)
    private Integer cantidad;

    // Relación con Pedido
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("nroPedido")
    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "nroPedido", foreignKey = @ForeignKey(name = "fk_carrito_pedido"))
    private Pedido pedido;

    // Relación con Producto
@ManyToOne(fetch = FetchType.LAZY)
@MapsId("idProducto")
@JsonBackReference
@JoinColumn(name = "idProducto", foreignKey = @ForeignKey(name = "fk_carrito_producto"))
private Producto producto;

}
