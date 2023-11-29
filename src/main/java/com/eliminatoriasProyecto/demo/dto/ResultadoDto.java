package com.eliminatoriasProyecto.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ResultadoDto {
    @JsonProperty("Id")
    private Integer idResultado;
    @JsonProperty("Goles local")
    @PositiveOrZero
    private Integer golLocal;
    @JsonProperty("Goles visitante")
    private Integer golVisitante;
    @PositiveOrZero
    @JsonProperty("Tarjetas amarillas")
    @PositiveOrZero
    private Integer nAmarillas;
    @JsonProperty("Tarjetas Rojas")
    @PositiveOrZero
    private Integer nRojas;
}
