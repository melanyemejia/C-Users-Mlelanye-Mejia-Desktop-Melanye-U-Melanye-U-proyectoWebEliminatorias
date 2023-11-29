package com.eliminatoriasProyecto.demo.dto;

import com.eliminatoriasProyecto.demo.entidades.PartidoEntidad;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface PartidoMapper {

    PartidoDto partidoEntidadToPartidoDto (PartidoEntidad partido);
}
