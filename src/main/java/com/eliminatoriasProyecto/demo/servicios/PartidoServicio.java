package com.eliminatoriasProyecto.demo.servicios;

import com.eliminatoriasProyecto.demo.entidades.EquipoEntidad;
import com.eliminatoriasProyecto.demo.entidades.PartidoEntidad;
import com.eliminatoriasProyecto.demo.respositorios.PartidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PartidoServicio {
    private final PartidoRepositorio partidoRepositorio;
    @Autowired
    public PartidoServicio(PartidoRepositorio partidoRepositorio) {
        this.partidoRepositorio = partidoRepositorio;
    }

    public List<PartidoEntidad> getAll(){
        return this.partidoRepositorio.findAll();
    }

    public PartidoEntidad encontrarPorFecha(LocalDateTime date){
        return this.partidoRepositorio.findAllByFecha(date);
    }

    public PartidoEntidad addPartido(PartidoEntidad partido){
        return this.partidoRepositorio.save(partido);
    }

    public boolean existePartidoId(int id){
        return  this.partidoRepositorio.existsById(id);
    }
}
