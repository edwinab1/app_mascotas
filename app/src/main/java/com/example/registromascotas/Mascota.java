package com.example.registromascotas;

public class Mascota {

    String nombre;
    String color;
    String raza;
    int edad;

    public Mascota(String nombre, String color, String raza, int edad){

        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
        this.raza = raza;

    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
