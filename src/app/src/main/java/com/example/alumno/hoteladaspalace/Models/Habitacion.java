package com.example.alumno.hoteladaspalace.Models;

import java.util.ArrayList;
public class Habitacion {
    public int id;
    public String codigo;
    public String descripcion;

    public Habitacion(){

    }

    public Habitacion(int _id, String _codigo) {
        this.id = _id;
        this.codigo = _codigo;
      //  this.descripcion = _descripcion;
    }

    public static  ArrayList<Habitacion> getHabitaciones(){
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion(1, "HABITACION INDIVIDUAL"));
        habitaciones.add(new Habitacion(1, "HABITACION DOBLE"));
        habitaciones.add(new Habitacion(1, "HABITACION MATRIMONIAL"));
        habitaciones.add(new Habitacion(1, "HABITACION FAMILIAR"));
        return habitaciones;
    }
}
