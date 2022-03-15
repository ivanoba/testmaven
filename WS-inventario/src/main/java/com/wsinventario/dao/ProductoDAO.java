/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao;

import com.wsinventario.dao.beans.Producto;
import java.util.List;

/**
 *
 * @author ivano
 */
public interface ProductoDAO {
    public Producto obtenerProducto(Integer id);
    
    public  List<Producto> listarProductos();
    
    public String registrarProducto(Producto producto);
    
    public Integer actualizarProducto(Producto producto);
    
    public Integer eliminarProducto(Integer id);
}
