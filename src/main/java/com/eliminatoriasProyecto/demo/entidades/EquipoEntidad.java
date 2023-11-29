package com.eliminatoriasProyecto.demo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "equipos")
@Setter
@Getter
@NoArgsConstructor
public class EquipoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo", nullable = false)
    private Integer idEquipo;
    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;
    @Column(name = "bandera_url")
    private String banderaUrl;
    @Column(name = "director_tecnico")
    @NotBlank(message = "El nombre del DT no puede estar en blanco")
    private String directorTecnico;


        @OneToMany(mappedBy = "equipoLocal")
        private List<PartidoEntidad> partidosLocal;

        @OneToMany(mappedBy = "equipoVisitante")
        private List<PartidoEntidad> partidosVisitante;
}
