/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.beans;

/**
 *
 * @author ivano
 */
public class Inventario {
    private Integer id;
    private Integer id_producto;
    private Float existencia;
    private Producto producto;

    public Inventario(Integer id, Integer id_producto, Float existencia, Producto producto) {
        this.id = id;
        this.id_producto = id_producto;
        this.existencia = existencia;
        this.producto = producto;
    }

    public Inventario(Integer id_producto, Float existencia, Producto producto) {
        this.id_producto = id_producto;
        this.existencia = existencia;
        this.producto = producto;
    }

    public Inventario(Integer id, Integer id_producto, Float existencia) {
        this.id = id;
        this.id_producto = id_producto;
        this.existencia = existencia;
    }
    

    public Inventario(Integer id_producto, Float existencia) {
        this.id_producto = id_producto;
        this.existencia = existencia;
    }

    public Inventario(Integer id) {
        this.id = id;
    }
    
    public Producto producto (){
        return producto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Float getExistencia() {
        return existencia;
    }

    public void setExistencia(Float existencia) {
        this.existencia = existencia;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
