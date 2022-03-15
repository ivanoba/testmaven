/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.service;

import com.wsinventario.dao.beans.Producto;
import com.wsinventario.dao.operations.ProductoOperationDAO;
import java.util.List;

/**
 *
 * @author ivano
 */
public class ProductoService {
    ProductoOperationDAO prodOp = new ProductoOperationDAO();
    
    public Producto obtenerProducto(Integer id){
        return prodOp.obtenerProducto(id);
    }
    
    public  List<Producto> listarProductos(){
        return prodOp.listarProductos();
    }
    
    public String registrarProducto(Producto producto){
        return prodOp.registrarProducto(producto);
    }
    
    public Integer actualizarProducto(Producto producto){
        return prodOp.actualizarProducto(producto);
    }
    
    public Integer eliminarProducto(Integer id){
        return prodOp.eliminarProducto(id);
    }
    
}
