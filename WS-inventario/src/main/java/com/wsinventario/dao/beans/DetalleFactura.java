/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.beans;

/**
 *
 * @author ivano
 */
public class DetalleFactura {
    private Integer id;
    private Integer id_factura;
    private Integer id_producto;
    private EncabezadoFactura enc_factura;
    private Producto producto;
    private Float precio;
    private Float cantidad;
    private Float descuento;
    private Float total;

    public DetalleFactura(Integer id, Integer id_factura, Integer id_producto, EncabezadoFactura enc_factura, Producto producto, Float precio, Float cantidad, Float descuento, Float total) {
        this.id = id;
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.enc_factura = enc_factura;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
    }

    public DetalleFactura(Integer id, Integer id_factura, Integer id_producto, Float precio, Float cantidad, Float descuento, Float total) {
        this.id = id;
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
    }

    public DetalleFactura(Integer id_factura, Integer id_producto, Float precio, Float cantidad, Float descuento, Float total) {
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
    }

    public DetalleFactura(Integer id_producto, Float precio, Float cantidad, Float descuento, Float total) {
        this.id_producto = id_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
    }

    

    public DetalleFactura(Integer id) {
        this.id = id;
    }
    
    public DetalleFactura() {
    }
    
    public EncabezadoFactura enc_factura(){
        return enc_factura;
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

    public Integer getId_factura() {
        return id_factura;
    }

    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }
    
    

    public EncabezadoFactura getEnc_factura() {
        return enc_factura;
    }

    public void setEnc_factura(EncabezadoFactura enc_factura) {
        this.enc_factura = enc_factura;
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

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
    
    
}
