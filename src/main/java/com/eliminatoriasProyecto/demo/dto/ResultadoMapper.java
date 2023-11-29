package com.eliminatoriasProyecto.demo.dto;

import com.eliminatoriasProyecto.demo.entidades.ResultadoEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResultadoMapper {
    ResultadoDto resultadoEntidadToResultadoDto(ResultadoEntidad resultado);
}
