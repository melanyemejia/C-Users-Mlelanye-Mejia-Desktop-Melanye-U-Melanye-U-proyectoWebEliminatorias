package com.eliminatoriasProyecto.demo.controladores;

import com.eliminatoriasProyecto.demo.dto.EquipoDto;
import com.eliminatoriasProyecto.demo.dto.EquipoMapper;
import com.eliminatoriasProyecto.demo.entidades.EquipoEntidad;
import com.eliminatoriasProyecto.demo.servicios.EquipoServicio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/equipos")
@Validated
public class EquipoController {

  private final EquipoServicio equipoServicio;
  private final EquipoMapper equipoMapper;

    @Autowired
    public EquipoController(EquipoServicio equipoServicio, EquipoMapper equipoMapper) {
        this.equipoServicio = equipoServicio;
        this.equipoMapper = equipoMapper;
    }

    @GetMapping()
    public ResponseEntity<List<EquipoDto>> getAll(){
        List<EquipoEntidad> listaEquipos = this.equipoServicio.getAll();
        List<EquipoDto> listaEquiposDto = null;

        listaEquiposDto = listaEquipos.stream()
                .map(equipo -> this.equipoMapper.equipoEntidadToEquipoDto(equipo))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaEquiposDto);
    }

    @GetMapping("/nombre")
    public ResponseEntity<EquipoDto> getPorNombre(@RequestParam @NotBlank String nombre){
        EquipoEntidad equipo = this.equipoServicio.encontrarEquipoPorNombre(nombre);
        EquipoDto equipoDto = null;

        equipoDto = this.equipoMapper.equipoEntidadToEquipoDto(equipo);
        return ResponseEntity.ok(equipoDto);
    }

    @PostMapping()
    public ResponseEntity<EquipoDto> addEquipo(@RequestParam @Validated EquipoEntidad equipo){

        EquipoEntidad equipoCreado = this.equipoServicio.addEquipo(equipo);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{idEquipo}")
                    .buildAndExpand(equipoCreado.getIdEquipo())
                    .toUri();

            EquipoDto equipoDto = this.equipoMapper.equipoEntidadToEquipoDto(equipoCreado);
            return  ResponseEntity.created(location).body(equipoDto);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<EquipoDto> updateEquipo(@PathVariable @Min(1) int id, @RequestBody @Valid EquipoEntidad equipo){
        if(this.equipoServicio.existeEquipoId(id)){
            EquipoEntidad equipoCreado = this.equipoServicio.addEquipo(equipo);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{idEquipo}")
                    .buildAndExpand(equipoCreado.getIdEquipo())
                    .toUri();
            EquipoDto equipoDto = this.equipoMapper.equipoEntidadToEquipoDto(equipoCreado);
            return ResponseEntity.created(location).body(equipoDto);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable @Min(1) int id){
        this.equipoServicio.eliminarEquipo(id);
        return ResponseEntity.noContent().build();
    }

}
