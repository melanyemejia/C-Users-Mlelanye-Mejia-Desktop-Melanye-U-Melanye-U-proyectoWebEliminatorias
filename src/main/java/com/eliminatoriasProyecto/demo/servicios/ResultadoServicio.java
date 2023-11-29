package com.eliminatoriasProyecto.demo.servicios;

import com.eliminatoriasProyecto.demo.entidades.ResultadoEntidad;
import com.eliminatoriasProyecto.demo.respositorios.ResultadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultadoServicio {
    private final ResultadoRepositorio resultadoRepositorio;
    @Autowired
    public ResultadoServicio(ResultadoRepositorio resultadoRepositorio) {
        this.resultadoRepositorio = resultadoRepositorio;
    }
    public ResultadoEntidad addResultado(ResultadoEntidad resultado){
        return this.resultadoRepositorio.save(resultado);
    }
    public boolean existeResultadoId(int id){
        return this.resultadoRepositorio.existsById(id);
    }
}
