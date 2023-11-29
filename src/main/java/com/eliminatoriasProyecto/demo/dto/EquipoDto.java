package com.eliminatoriasProyecto.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Data
public class EquipoDto {
    @JsonProperty("Id")
    private Integer idEquipo;
    @JsonProperty("Nombre")
    @NotBlank
    private String nombre;
    @JsonProperty("DirectorTecnico")
    @NotBlank
    private String directorTecnico;
    @JsonProperty("PartidosDeLocal")
    private Set<PartidoDto> partidosLocal;
    @JsonProperty("PartidosDeVisitante")
    private Set<PartidoDto> partidosVisitante;
}
