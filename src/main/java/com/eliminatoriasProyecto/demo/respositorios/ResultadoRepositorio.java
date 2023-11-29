package com.eliminatoriasProyecto.demo.respositorios;

import com.eliminatoriasProyecto.demo.entidades.ResultadoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepositorio extends JpaRepository<ResultadoEntidad, Integer> {
}
