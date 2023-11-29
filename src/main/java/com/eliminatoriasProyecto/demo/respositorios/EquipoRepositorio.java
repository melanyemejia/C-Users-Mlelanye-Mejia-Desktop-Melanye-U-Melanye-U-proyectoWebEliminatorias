package com.eliminatoriasProyecto.demo.respositorios;

import com.eliminatoriasProyecto.demo.entidades.EquipoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface EquipoRepositorio extends JpaRepository<EquipoEntidad, Integer> {

    EquipoEntidad findByNombre(String nombre);

}
