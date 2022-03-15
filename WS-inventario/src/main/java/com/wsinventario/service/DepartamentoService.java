/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.service;

import com.wsinventario.dao.beans.Departamento;
import com.wsinventario.dao.operations.DepartamentoOperationDAO;
import java.util.List;

/**
 *
 * @author ivano
 */
public class DepartamentoService {
    DepartamentoOperationDAO deptoOp = new DepartamentoOperationDAO();
    
    public Departamento obtenerDepartamento(Integer id){
        return deptoOp.obtenerDepartamento(id);
    }
    
    public List<Departamento> listarDepartamentos(){
        return deptoOp.listarDepartamentos();
    }
    
    public String registrarDepartamento(Departamento depto){
        return deptoOp.registrarDepartamento(depto);
    }
    
    public Integer actualizarDepartamento(Departamento depto){
        return deptoOp.actualizarDepartamento(depto);
    }
    
    public Integer eliminarDepartamento(Integer id){
        return deptoOp.eliminarDepartamento(id);
    }
    
}
