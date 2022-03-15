/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.beans;

/**
 *
 * @author ivano
 */
public class Venta {
    private Integer id;
    private Integer id_factura;
    private Integer id_producto;
    private DetalleFactura det_factura;
    private Producto producto;
    private Float precio;
    private Float cantidad;

    public Venta(Integer id, Integer id_factura, Integer id_producto, DetalleFactura det_factura, Producto producto, Float precio, Float cantidad) {
        this.id = id;
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.det_factura = det_factura;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Venta(Integer id, Integer id_factura, Integer id_producto, Float precio, Float cantidad) {
        this.id = id;
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    

    public Venta(Integer id) {
        this.id = id;
    }
    
    public DetalleFactura det_factura(){
        return det_factura;
    }
    
    public Producto producto(){
        return producto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DetalleFactura getDet_factura() {
        return det_factura;
    }

    public void setDet_factura(DetalleFactura det_factura) {
        this.det_factura = det_factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
