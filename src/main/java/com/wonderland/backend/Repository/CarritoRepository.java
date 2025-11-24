package com.wonderland.backend.Repository;

import com.wonderland.backend.Model.Carrito;
import com.wonderland.backend.Model.CarritoId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, CarritoId> {
}
