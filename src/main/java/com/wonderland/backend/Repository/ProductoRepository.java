package com.wonderland.backend.Repository;

import com.wonderland.backend.Model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, String> {

}

