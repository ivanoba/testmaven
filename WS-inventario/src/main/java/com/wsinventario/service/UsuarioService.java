/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.service;

import com.wsinventario.dao.beans.Usuario;
import com.wsinventario.dao.operations.UsuarioOperationDAO;
import java.util.List;

/**
 *
 * @author ivano
 */
public class UsuarioService {
    UsuarioOperationDAO userOp = new UsuarioOperationDAO();
    
    public Usuario obtenerUsuario(Integer id){
        return userOp.obtenerUsuario(id);
    }
    
    public List<Usuario> listarUsuarios(){
        return userOp.listarUsuarios();
    }
    
    public String registrarUsuario(Usuario usuario){
        return userOp.registrarUsuario(usuario);
    }
    
    public Integer actualizarUsuario(Usuario usuario){
        return userOp.actualizarUsuario(usuario);
    }
    
    public Integer loginUsuario(Usuario usuario){
        return userOp.loginUsuario(usuario);
    }
    
    public Integer eliminarUsuario(Integer id){
        return userOp.eliminarUsuario(id);
    }
    
    public Usuario obtenerNombreUsuario(String usuario){
        return userOp.obtenerNombreUsuario(usuario);
    }
    
}
