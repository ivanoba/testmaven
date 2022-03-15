/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao;

import com.wsinventario.dao.beans.Inventario;
import java.util.List;

/**
 *
 * @author ivano
 */
public interface InventarioDAO {
    public Inventario obtenerInventario(Integer id);
    
    public List<Inventario> listarInventarios();
    
}
