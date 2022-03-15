/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao;

import com.wsinventario.dao.beans.Usuario;
import java.util.List;

/**
 *
 * @author ivano
 */
public interface UsuarioDAO {
    public Usuario obtenerUsuario(Integer id);
    
    public List<Usuario> listarUsuarios();
    
    public String registrarUsuario(Usuario usuario);
    
    public Integer actualizarUsuario(Usuario usuario);
    
    public Integer loginUsuario(Usuario usuario);
    
    public Integer eliminarUsuario(Integer id);
    
    public Usuario obtenerNombreUsuario(String usuario);
}
