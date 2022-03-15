/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.operations;

import Utils.PoolConnection2;
import com.wsinventario.dao.UsuarioDAO;
import com.wsinventario.dao.beans.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivano
 */
public class UsuarioOperationDAO implements UsuarioDAO {
    PoolConnection2 DBcon = new PoolConnection2();
    String jdni = "jdbc/test";
    
    @Override
    public Usuario obtenerUsuario(Integer id){
        Usuario user = null;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_usuario WHERE id = " + id;
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            if(rs.next()){
               user = new Usuario(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5)
               ); 
            }
        } catch (SQLException e) {
            System.out.println("UserOpDAO Error al obtener usuario: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return user;
    }
    
    @Override
    public List<Usuario> listarUsuarios(){
        List<Usuario> users = new ArrayList<>();
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_usuario ORDER BY id DESC";
            ResultSet rs = this.DBcon.Consultar(consulta);
            Usuario usr;
            
            while(rs.next()){
                usr = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                users.add(usr);
            }
            
        } catch(SQLException e) {
            System.out.println("[SQLUserDAO] Error al listar usuarios: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        return users;
    }
    
    @Override
    public String registrarUsuario(Usuario usuario){
        String resultado = "";
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "INSERT INTO test_usuario (nombre, email, username, contrasenia) "
                    + "VALUES ('" + usuario.getNombre() + "', '" + usuario.getEmail() + "', '" 
                    + usuario.getUsername() + "', '" + usuario.getPassword() + "')";
            this.DBcon.ExecUpIn(consulta);
            resultado = usuario.toString();
            System.out.println(consulta);
        } catch (SQLException e) {
            System.out.println("[UsuarioOp] Error al registrar cliente: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return resultado;
    }
    
    @Override
    public Integer actualizarUsuario(Usuario usuario){
        Integer resultado = 0;
        Integer id = 0;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_usuario WHERE id = " + usuario.getId();
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            while(rs.next()){
                id = rs.getInt(1);
            }
            
            String queryUpdate = "UPDATE test_usuario "
                    + "SET nombre = '" + usuario.getNombre() + "', email = '" + usuario.getEmail() 
                    + "', username = '" + usuario.getUsername() + "', contrasenia = '" + usuario.getPassword() + "' WHERE id = " + id;
        
            this.DBcon.ExecUpIn(queryUpdate);
            System.out.println("Usuario actualizado, id = " + id);
        } catch (SQLException e) {
            System.out.println("[UsuarioOp] Error al actualizar usuario: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        resultado = id;
        return resultado;
    }
    
    @Override
    public Integer loginUsuario(Usuario usuario){
        Integer resultado = 0;
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_usuario WHERE username = '" + usuario.getUsername() 
                + "' AND contrasenia = '" + usuario.getPassword() + "'";
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            if(rs != null){
                System.out.println("acceso autorizado");
            } else {
                System.out.println("acceso denegado");
            }
            
        } catch (SQLException e) {
            System.out.println("[UserOp] Error en login: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
       
        
        return resultado;
    }
    
    @Override
    public Usuario obtenerNombreUsuario(String usuario) {
        String consulta = "SELECT * FROM IVANOBAJ.test_usuario WHERE username = '" + usuario + "'";
        Usuario user = null;
        int i = 1;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            while(rs.next()){
                Object usuarioObj = rs.getObject(i);
                user = (Usuario)usuarioObj;
                i++;
            }
            
        } catch (SQLException e) {
            System.out.println("DetallesUsuarioService, Error: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        return user;
    }
    
    @Override
    public Integer eliminarUsuario(Integer id){
        Integer resultado = 0;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "DELETE FROM IVANOBAJ.test_usuario WHERE id = "+ id;
            this.DBcon.ExecUpIn(consulta);
            System.out.println("Registro usuario " + id + " eliminado.");
        } catch (SQLException e) {
            System.out.println("[UsuarioOp] Error al eliminar usuario: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        resultado = id;
        return resultado;
    }
    
}
