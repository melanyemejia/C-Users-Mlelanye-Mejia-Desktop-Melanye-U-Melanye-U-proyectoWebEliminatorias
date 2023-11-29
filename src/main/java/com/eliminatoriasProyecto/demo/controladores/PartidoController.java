package com.eliminatoriasProyecto.demo.controladores;

import com.eliminatoriasProyecto.demo.dto.EquipoDto;
import com.eliminatoriasProyecto.demo.dto.PartidoDto;
import com.eliminatoriasProyecto.demo.dto.PartidoMapper;
import com.eliminatoriasProyecto.demo.entidades.EquipoEntidad;
import com.eliminatoriasProyecto.demo.entidades.PartidoEntidad;
import com.eliminatoriasProyecto.demo.servicios.PartidoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/v1/partidos")
public class PartidoController {

    private final PartidoServicio partidoServicio;
    private final PartidoMapper partidoMapper;

    @Autowired
    public PartidoController(PartidoServicio partidoServicio, PartidoMapper partidoMapper) {
        this.partidoServicio = partidoServicio;
        this.partidoMapper = partidoMapper;
    }

    @GetMapping
    public ResponseEntity<List<PartidoDto>> getAll(){
        List<PartidoDto> partidosDtos = null;

        partidosDtos = this.partidoServicio.getAll().stream()
                .map(partido -> this.partidoMapper.partidoEntidadToPartidoDto(partido))
                .collect(Collectors.toList());

        return ResponseEntity.ok(partidosDtos);
    }
    @GetMapping("/fecha")
    public ResponseEntity<PartidoDto> getByDate(@RequestParam LocalDateTime fecha){
        PartidoDto partidosDto = null;
        partidosDto = this.partidoMapper.partidoEntidadToPartidoDto(
                this.partidoServicio.encontrarPorFecha(fecha)
        );
        return ResponseEntity.ok(partidosDto);
    }

    @PostMapping
    public ResponseEntity<PartidoDto> addMatch( @RequestBody @Valid PartidoEntidad partido){
        PartidoEntidad partidoCreado = this.partidoServicio.addPartido(partido);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idEquipo}")
                .buildAndExpand(partidoCreado.getIdPartido())
                .toUri();

        PartidoDto partidoDto = this.partidoMapper.partidoEntidadToPartidoDto(partidoCreado);
        return  ResponseEntity.created(location).body(partidoDto);
    }

    @PatchMapping
    public ResponseEntity<PartidoDto> updateMatch( @RequestBody @Valid PartidoEntidad partido){
        if(partido.getIdPartido() != null && this.partidoServicio.existePartidoId(partido.getIdPartido())){
            PartidoEntidad partidoCreado = this.partidoServicio.addPartido(partido);
            PartidoDto partidoDto = this.partidoMapper.partidoEntidadToPartidoDto(partidoCreado);
            return ResponseEntity.ok(partidoDto);
        }
        return ResponseEntity.badRequest().build();
    }
}
