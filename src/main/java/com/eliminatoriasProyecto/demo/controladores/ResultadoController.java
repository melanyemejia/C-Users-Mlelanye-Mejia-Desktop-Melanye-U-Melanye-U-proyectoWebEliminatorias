package com.eliminatoriasProyecto.demo.controladores;

import com.eliminatoriasProyecto.demo.dto.ResultadoDto;
import com.eliminatoriasProyecto.demo.dto.ResultadoMapper;
import com.eliminatoriasProyecto.demo.entidades.ResultadoEntidad;
import com.eliminatoriasProyecto.demo.servicios.ResultadoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/resultados")
public class ResultadoController {

    private final ResultadoServicio resultadoServicio;
    private final ResultadoMapper resultadoMapper;
    @Autowired
    public ResultadoController(ResultadoServicio resultadoServicio, ResultadoMapper resultadoMapper) {
        this.resultadoServicio = resultadoServicio;
        this.resultadoMapper = resultadoMapper;
    }
    @PostMapping
    public ResponseEntity<ResultadoDto> addResult (@RequestBody @Valid ResultadoEntidad result){
            ResultadoEntidad resultCreado = this.resultadoServicio.addResultado(result);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idPartido}")
                .buildAndExpand(resultCreado.getIdResultado())
                .toUri();

            ResultadoDto resultDto =   this.resultadoMapper.resultadoEntidadToResultadoDto(resultCreado);
            return ResponseEntity.ok(resultDto);

    }
    @PutMapping
    public ResponseEntity<ResultadoDto> updateResult (@RequestBody @Valid ResultadoEntidad result){
        if(result.getIdResultado()!=null && this.resultadoServicio.existeResultadoId(result.getIdResultado())){
            ResultadoEntidad resultCreado = this.resultadoServicio.addResultado(result);
            ResultadoDto resultDto =   this.resultadoMapper.resultadoEntidadToResultadoDto(resultCreado);
            return ResponseEntity.ok(resultDto);
        }
        return ResponseEntity.badRequest().build();
    }
}
