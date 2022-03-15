/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.service;

import com.wsinventario.dao.beans.Cliente;
import com.wsinventario.dao.operations.ClienteOperationDAO;
import java.util.List;

/**
 *
 * @author ivano
 */
public class ClienteService {
    ClienteOperationDAO cteOp = new ClienteOperationDAO();

    public Cliente obtenerCliente(Integer id){
        return cteOp.obtenerCliente(id);
    }
    
    public List<Cliente> listarClientes(){
        return cteOp.listarClientes();
    }
    
    public String registrarCliente(Cliente cliente){
        return cteOp.registrarCliente(cliente);
    }
    
    public Integer actualizarCliente(Cliente cliente){
        return cteOp.actualizarCliente(cliente);
    }
    
    public Integer eliminarCliente(Integer id){
        return cteOp.eliminarCliente(id);
    }
}
