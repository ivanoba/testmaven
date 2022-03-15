/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao;

import com.wsinventario.dao.beans.Cliente;
import java.util.List;

/**
 *
 * @author ivano
 */
public interface ClienteDAO {
    public Cliente obtenerCliente(Integer id);
    
    public List<Cliente> listarClientes();
    
    public String registrarCliente(Cliente cliente);
    
    public Integer actualizarCliente(Cliente cliente);
    
    public Integer eliminarCliente(Integer id);
    
}
