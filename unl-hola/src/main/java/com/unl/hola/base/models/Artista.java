package com.unl.hola.base.models;

public class Artista { 
    private Integer id;
    private String nombre;
    private String Nacionalidad;

    //getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
    public String getNacionalidad() {
        return Nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }
}