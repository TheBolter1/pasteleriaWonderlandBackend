package com.wonderland.backend.Repository;

import com.wonderland.backend.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
}
