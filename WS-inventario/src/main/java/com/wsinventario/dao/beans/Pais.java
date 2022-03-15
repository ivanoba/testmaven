/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.beans;

/**
 *
 * @author ivano
 */
public class Pais {
    private Integer id;
    private String nombre;
    
    
    public Pais(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Pais(Integer id) {
        this.id = id;
    }
    
    public Pais(String nombre){
        this.nombre = nombre;
    }

    public Pais(){
    }
    
    
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
    
    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", nombre=" + nombre + "}";
    }
    
    //modelo
}
