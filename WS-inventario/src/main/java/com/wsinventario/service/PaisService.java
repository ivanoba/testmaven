/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.service;

import com.wsinventario.dao.PaisDAO;
import com.wsinventario.dao.beans.Pais;
import com.wsinventario.dao.operations.PaisOperationDAO;
import java.util.List;

/**
 *
 * @author ivano
 */
public class PaisService {
    PaisOperationDAO paisOp = new PaisOperationDAO();
    
    public Pais obtenerPais(Integer id) {
        return paisOp.obtenerPais(id);
    }
    
    public List<Pais> listarPaises(){
        return paisOp.listarPaises();
    }
    
    public String registrarPais(Pais pais){
        return paisOp.registrarPais(pais);
    }
    
    public Integer actualizarPais(Pais pais){
        return paisOp.actualizarPais(pais);
    }
    
    public Integer eliminarPais(Integer id){
        return paisOp.eliminarPais(id);
    }
}
