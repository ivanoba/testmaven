/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.beans;

/**
 *
 * @author ivano
 */
public class Departamento {
    private Integer id;
    private String nombre;
    private Integer id_pais;
    
    private Pais pais;
    
    public Departamento(Integer id, String nombre, Integer id_pais, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.id_pais = id_pais;
        this.pais = pais;
    }
    
    public Departamento(Integer id, String nombre, Integer id_pais) {
        this.id = id;
        this.nombre = nombre;
        this.id_pais = id_pais;
    }

    public Departamento(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Departamento(String nombre, Integer id_pais) {
        this.nombre = nombre;
        this.id_pais = id_pais;
    }


    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public Departamento(Integer id) {
        this.id = id;
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Integer getId_pais() {
        return id_pais;
    }

    public void setId_pais(Integer id_pais) {
        this.id_pais = id_pais;
    }

    public Pais getPais() {
        return pais;
    }
/*
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
  */  
    
    
    
}
