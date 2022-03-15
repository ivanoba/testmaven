/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao;

import com.wsinventario.dao.beans.Departamento;
import java.util.List;

/**
 *
 * @author ivano
 */
public interface DepartamentoDAO {
    
    public Departamento obtenerDepartamento(Integer id);
    
    public List<Departamento> listarDepartamentos();
    
    public String registrarDepartamento(Departamento depto);
    
    public Integer actualizarDepartamento(Departamento depto);
    
    public Integer eliminarDepartamento(Integer id);
    
}
