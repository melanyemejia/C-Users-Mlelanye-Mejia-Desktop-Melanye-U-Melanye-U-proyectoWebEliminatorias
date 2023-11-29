package com.eliminatoriasProyecto.demo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "partidos")
@Getter
@Setter
@NoArgsConstructor
public class PartidoEntidad {
    @Id
    @Column(name = "id_partido", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPartido;

    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String estadio;
    private String arbitro;
    @Column(nullable = false)
    private LocalDateTime fecha;


    @Column(name = "id_local", nullable = false)
    private Integer idLocal;
    @Column(name = "id_visitante", nullable = false)
    private Integer idVisitante;
    @Column(name = "id_resultado", nullable = false)
    private Integer idResultado;


    @OneToOne
    @JoinColumn(name = "id_resultado", referencedColumnName = "id_resultado",insertable = false,
            updatable = false )
    private ResultadoEntidad resultado;

    @ManyToOne
    @JoinColumn(name = "id_local", referencedColumnName = "id_equipo",insertable = false,
            updatable = false )
    @JsonIgnore
    private EquipoEntidad equipoLocal;

    @ManyToOne
    @JoinColumn(name = "id_visitante", referencedColumnName = "id_equipo",insertable = false,
            updatable = false )
    @JsonIgnore
    private EquipoEntidad equipoVisitante;
}
