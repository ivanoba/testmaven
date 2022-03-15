/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.operations;

import Utils.PoolConnection2;
import com.wsinventario.dao.ClienteDAO;
import com.wsinventario.dao.beans.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivano
 */
public class ClienteOperationDAO implements ClienteDAO {
    PoolConnection2 DBcon = new PoolConnection2();
    String jdni = "jdbc/test";
    
    @Override
    public Cliente obtenerCliente(Integer id) {
        Cliente cte = null;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_cliente WHERE id = " + id;
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            if(rs.next()){
                cte = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                
                );
            }
            System.out.println("Cliente obtenido exitosamente.");
        } catch(SQLException e) {
            System.out.println("[SQL Cliente] Error al intentar obtener la informacion: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return cte;
    }
    
    
    @Override
    public List<Cliente> listarClientes(){
        List<Cliente> ctes = new ArrayList<>();
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_cliente ORDER BY id DESC";
            ResultSet rs = this.DBcon.Consultar(consulta);
            Cliente cte;
            
            while(rs.next()){
                cte = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                );
                ctes.add(cte);
            }
        } catch (SQLException e) {
            System.out.println("[SQLClienteOpDAO] Error al listar clientes: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        } 
        return ctes;
    }
    
    @Override
    public String registrarCliente(Cliente cte) {
        String resultado = "";
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "INSERT INTO test_cliente (nombre, representante, nit, telefono, direccion, email, dob, id_depto) "
                    + "VALUES ('" + cte.getNombre() + "', '" + cte.getRepresentante() + "', '" + cte.getNit() + "', " + cte.getTelefono() 
                    + ", '" + cte.getDireccion() + "', '" + cte.getEmail() + "', '" + cte.getDob() + "', " + cte.getId_depto() + ")";
            this.DBcon.ExecUpIn(consulta);
            resultado = cte.toString();
            System.out.println(consulta);
        } catch (SQLException e) {
            System.out.println("[SQLClienteOpDAO] Error al ingresar cliente: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        return resultado;
    }
    
    @Override
    public Integer actualizarCliente(Cliente cte) {
        Integer resultado = 0;
        Integer id = 0;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_cliente WHERE id = " + cte.getId();
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            while(rs.next()){
                id = rs.getInt(1);
            }
            
            String queryUpdate = "UPDATE IVANOBAJ.test_cliente SET nombre = '" + cte.getNombre() + "', representante = '" + cte.getRepresentante() + "', nit = '" + cte.getNit() + "', telefono = " + cte.getTelefono() 
                    + ", direccion = '" + cte.getDireccion() + "', email = '" + cte.getEmail() + "', dob = '" + cte.getDob() + "', id_depto = " + cte.getId_depto() + " WHERE id = " + id;
            this.DBcon.ExecUpIn(queryUpdate);
            System.out.println("Cliente actualizado, id: " + id);
        } catch (SQLException e) {
            System.out.println("[SQLClienteOpDAO] Error al actualizar cliente: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        resultado = id;
        return resultado;
    }
    
    @Override
    public Integer eliminarCliente(Integer id) {
        Integer resultado = 0;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "DELETE FROM IVANOBAJ.test_cliente WHERE id = " + id;
            this.DBcon.ExecUpIn(consulta);
            System.out.println("Registro cliente " + id + "eliminado");
        } catch (SQLException e) {
            System.out.println("[SQLClienteOpDAO] Error al eliminar cliente: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        resultado = id;
        return resultado;
    }
}
