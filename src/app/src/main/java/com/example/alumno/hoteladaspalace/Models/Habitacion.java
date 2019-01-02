package com.example.alumno.hoteladaspalace.Models;

import java.util.ArrayList;
public class Habitacion {
    public int id;
    public String codigo;

    public Habitacion(int _id, String _codigo) {
        this.id = _id;
        this.codigo = _codigo;
    }

    public static  ArrayList<Habitacion> getHabitaciones(){
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion(1, "H201"));
        habitaciones.add(new Habitacion(1, "H202"));
        habitaciones.add(new Habitacion(1, "H203"));
        habitaciones.add(new Habitacion(1, "H204"));
        return habitaciones;
    }
}
