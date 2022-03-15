/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.beans;



/**
 *
 * @author ivano
 */
public class Cliente {
    private Integer id;
    private String nombre;
    private String representante;
    private String nit;
    private Integer telefono;
    private String direccion;
    private String email;
    private String dob;
    private Integer id_depto;
    private Departamento depto;

    public Cliente(Integer id, String nombre, String representante, String nit, Integer telefono, String direccion, String email, String dob, Integer id_depto, Departamento depto) {
        this.id = id;
        this.nombre = nombre;
        this.representante = representante;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.dob = dob;
        this.id_depto = id_depto;
        this.depto = depto;
    }

    public Cliente(Integer id, String nombre, String representante, String nit, Integer telefono, String direccion, String email, String dob, Integer id_depto) {
        this.id = id;
        this.nombre = nombre;
        this.representante = representante;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.dob = dob;
        this.id_depto = id_depto;
    }

    public Cliente(String nombre, String representante, String nit, Integer telefono, String direccion, String email, String dob, Integer id_depto) {
        this.nombre = nombre;
        this.representante = representante;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.dob = dob;
        this.id_depto = id_depto;
    }

    public Cliente(Integer id) {
        this.id = id;
    }
    
    public Departamento depto() {
        return depto;
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

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getId_depto() {
        return id_depto;
    }

    public void setId_depto(Integer id_depto) {
        this.id_depto = id_depto;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    } 
    
}
