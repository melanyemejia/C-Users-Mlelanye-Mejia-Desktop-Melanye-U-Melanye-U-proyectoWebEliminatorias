package com.eliminatoriasProyecto.demo.respositorios;

import com.eliminatoriasProyecto.demo.entidades.EquipoEntidad;
import com.eliminatoriasProyecto.demo.entidades.PartidoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PartidoRepositorio extends JpaRepository<PartidoEntidad, Integer> {
    PartidoEntidad findAllByFecha(LocalDateTime fecha);
}
