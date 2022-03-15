/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.beans;

/**
 *
 * @author ivano
 */
public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Float cantidad;
    private Float costo_unitario;
    private Float precio_venta_unitario;

    public Producto(Integer id, String nombre, String descripcion, Float cantidad, Float costo_unit, Float precio_venta_unit) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo_unitario = costo_unit;
        this.precio_venta_unitario = precio_venta_unit;
    }
    
    public Producto(String nombre, String descripcion, Float cantidad, Float costo_unit, Float precio_venta_unit) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo_unitario = costo_unit;
        this.precio_venta_unitario = precio_venta_unit;
    }
    
    public Producto(Integer id, String nombre, Float cantidad, Float costo_unit, Float precio_venta_unit) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo_unitario = costo_unit;
        this.precio_venta_unitario = precio_venta_unit;
    }
    
    public Producto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Producto(Integer id) {
        this.id = id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(Float costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public Float getPrecio_venta_unitario() {
        return precio_venta_unitario;
    }

    public void setPrecio_venta_unitario(Float precio_venta_unitario) {
        this.precio_venta_unitario = precio_venta_unitario;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", costo_unitario=" + costo_unitario + ", precio_venta_unitario=" + precio_venta_unitario + '}';
    }
    
    
    
    
}
