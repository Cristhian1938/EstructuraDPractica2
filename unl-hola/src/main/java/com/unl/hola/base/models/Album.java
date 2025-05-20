package com.unl.hola.base.models;


public class Album {
    private Integer id;
    private String nombre;
    private Integer id_banda;
 
    // Getters and Setters
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
    
    public Integer getId_banda() {
        return id_banda;
    }
    public void setId_banda(Integer id_banda) {
        this.id_banda = id_banda;
    }

}
