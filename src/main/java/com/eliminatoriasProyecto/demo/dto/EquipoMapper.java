package com.eliminatoriasProyecto.demo.dto;

import com.eliminatoriasProyecto.demo.entidades.EquipoEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipoMapper {
    EquipoDto equipoEntidadToEquipoDto(EquipoEntidad equipo);

}
