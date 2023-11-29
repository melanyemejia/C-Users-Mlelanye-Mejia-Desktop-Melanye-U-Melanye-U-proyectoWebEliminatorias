package com.eliminatoriasProyecto.demo.servicios;

import com.eliminatoriasProyecto.demo.entidades.EquipoEntidad;
import com.eliminatoriasProyecto.demo.respositorios.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EquipoServicio {
    private final EquipoRepositorio equipoRepositorio;
    @Autowired
    public EquipoServicio(EquipoRepositorio equipoRepositorio) {
        this.equipoRepositorio = equipoRepositorio;
    }


    public List<EquipoEntidad> getAll(){
        return this.equipoRepositorio.findAll();
    }

    public EquipoEntidad addEquipo(EquipoEntidad equipo){
        EquipoEntidad equipoNuevo = new EquipoEntidad();
        equipoNuevo.setNombre(equipo.getNombre());
        equipoNuevo.setBanderaUrl(equipo.getBanderaUrl());
        equipoNuevo.setDirectorTecnico(equipo.getDirectorTecnico());


        return this.equipoRepositorio.save(equipoNuevo);
    }

    public void eliminarEquipo(int id){
        this.equipoRepositorio.deleteById(id);
    }

    public Optional<EquipoEntidad> encontrarEquipoId(int id){
        return this.equipoRepositorio.findById(id);
    }

    public EquipoEntidad encontrarEquipoPorNombre(String nombre){
        return this.equipoRepositorio.findByNombre(nombre);
    }

    public boolean existeEquipoId(int id){
        return this.equipoRepositorio.existsById(id);
    }

}
