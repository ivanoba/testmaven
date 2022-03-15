/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//interface
package com.wsinventario.dao;

import com.wsinventario.dao.beans.Pais;
import java.util.List;

/**
 *
 * @author ivano
 */
public interface PaisDAO {
    
    public Pais obtenerPais(Integer id);
    
    public List<Pais> listarPaises();
    
    public String registrarPais(Pais pais);
    
    public Integer actualizarPais(Pais pais);
    
    public Integer eliminarPais(Integer id);
    
}
