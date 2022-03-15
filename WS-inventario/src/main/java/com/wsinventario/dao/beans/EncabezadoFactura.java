/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.beans;

import java.sql.Date;

/**
 *
 * @author ivano
 */
public class EncabezadoFactura {
    private Integer id;
    private Integer no_factura;
    private String serie_factura;
    private Integer id_cliente;
    private Cliente cliente;
    private String nombre;
    private String nit;
    private String fecha;
    private String direccion;
    private Float total_factura;

    public EncabezadoFactura(Integer id, Integer no_factura, String serie_factura, Integer id_cliente, Cliente cliente, String nombre, String nit, String fecha, String direccion, Float total_factura) {
        this.id = id;
        this.no_factura = no_factura;
        this.serie_factura = serie_factura;
        this.id_cliente = id_cliente;
        this.cliente = cliente;
        this.nombre = nombre;
        this.nit = nit;
        this.fecha = fecha;
        this.direccion = direccion;
        this.total_factura = total_factura;
    }

    public EncabezadoFactura(Integer id, Integer no_factura, String serie_factura, Integer id_cliente, String nombre, String nit, String fecha, String direccion, Float total_factura) {
        this.id = id;
        this.no_factura = no_factura;
        this.serie_factura = serie_factura;
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.nit = nit;
        this.fecha = fecha;
        this.direccion = direccion;
        this.total_factura = total_factura;
    }
    
    public EncabezadoFactura(Integer no_factura, String serie_factura, Integer id_cliente, String nombre, String nit, String fecha, String direccion, Float total_factura) {
        this.no_factura = no_factura;
        this.serie_factura = serie_factura;
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.nit = nit;
        this.fecha = fecha;
        this.direccion = direccion;
        this.total_factura = total_factura;
    }

    

    
    public EncabezadoFactura(Integer no_factura, String serie_factura, String nombre, String nit, String fecha, String direccion, Float total_factura) {
        this.no_factura = no_factura;
        this.serie_factura = serie_factura;
        this.nombre = nombre;
        this.nit = nit;
        this.fecha = fecha;
        this.direccion = direccion;
        this.total_factura = total_factura;
    }

    public EncabezadoFactura(Integer id) {
        this.id = id;
    }

    public Cliente cliente () {
        return cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo_factura() {
        return no_factura;
    }

    public void setNo_factura(Integer no_factura) {
        this.no_factura = no_factura;
    }

    public String getSerie_factura() {
        return serie_factura;
    }

    public void setSerie_factura(String serie_factura) {
        this.serie_factura = serie_factura;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Float getTotal_factura() {
        return total_factura;
    }

    public void setTotal_factura(Float total_factura) {
        this.total_factura = total_factura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
