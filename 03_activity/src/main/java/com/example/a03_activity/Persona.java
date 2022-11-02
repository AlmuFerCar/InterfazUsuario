package com.example.a03_activity;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String edad;
    private String sexo;
    private String prof;
    private String [] hob;

    public Persona (String nombre, String edad, String sexo, String prof, String [] hob)
    {
        this.nombre=nombre;
        this.edad=edad;
        this.sexo=sexo;
        this.prof=prof;
        this.hob=hob;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getProf() {
        return prof;
    }

    public String[] getHob() {
        return hob;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

   public void setHob(String[] hob) {
        this.hob = hob;
    }
}
