/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.service;

import com.wsinventario.dao.beans.Inventario;
import com.wsinventario.dao.operations.InventarioOperationDAO;
import java.util.List;

/**
 *
 * @author ivano
 */
public class InventarioService {
    InventarioOperationDAO inventarioOp = new InventarioOperationDAO();
    
    public Inventario obtenerInventario(Integer id){
        return inventarioOp.obtenerInventario(id);
    }
    
    public List<Inventario> listarInventarios(){
        return inventarioOp.listarInventarios();
    }
    
}
