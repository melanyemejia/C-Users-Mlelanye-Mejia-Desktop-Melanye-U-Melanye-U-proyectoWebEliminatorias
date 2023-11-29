package com.eliminatoriasProyecto.demo.excepciones;

public class EquipoNotFoundExeption extends  RuntimeException{
    public EquipoNotFoundExeption(String message) {
        super(message);
    }
}
