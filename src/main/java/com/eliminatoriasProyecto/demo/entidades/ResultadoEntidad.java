package com.eliminatoriasProyecto.demo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "resultados")
@Getter
@Setter
@NoArgsConstructor
public class ResultadoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultado", nullable = false)
    private Integer idResultado;
    @Column(name = "gol_local")
    @PositiveOrZero
    private Integer golLocal;
    @Column(name = "gol_visitante")
    @PositiveOrZero
    private Integer golVisitante;
    @Column(name = "numero_rojas")
    @PositiveOrZero
    private Integer nRojas;
    @Column(name = "numero_amarillas")
    @PositiveOrZero
    private Integer nAmarillas;

}
