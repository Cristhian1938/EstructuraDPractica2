package com.unl.hola.base.models;
import java.util.Date;

public class Banda {
    private Integer id;
    private String nombre;
    private Date fecha;
    
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
    public Date getFecha() {
        return this.fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
