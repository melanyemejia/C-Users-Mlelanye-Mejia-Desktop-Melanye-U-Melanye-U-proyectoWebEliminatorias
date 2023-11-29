package com.eliminatoriasProyecto.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PartidoDto {
    @JsonProperty("Id")
    private Integer idPartido;
    @JsonProperty("Estadio")
    @NotBlank
    private String estadio;
    @JsonProperty("Arbitro")
    private String arbitro;
    @JsonProperty("Fecha")
    private LocalDateTime fecha;
    @JsonProperty("ResultadoDelPartido")
    private ResultadoDto resultado;
}
