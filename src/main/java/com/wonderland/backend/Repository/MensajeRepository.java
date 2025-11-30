package com.wonderland.backend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wonderland.backend.Model.Mensaje;

   

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}


