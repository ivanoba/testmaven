/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.operations;

import Utils.PoolConnection;
import Utils.PoolConnection2;
import com.wsinventario.dao.DepartamentoDAO;
import com.wsinventario.dao.beans.Departamento;
import com.wsinventario.dao.beans.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivano
 */
public class DepartamentoOperationDAO implements DepartamentoDAO {
    PoolConnection2 DBcon = new PoolConnection2();
    String jdni = "jdbc/test";
    
    
    @Override
    public Departamento obtenerDepartamento(Integer id) {
        Departamento depto = null;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_departamento WHERE id = " + id;
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            if(rs.next()){
                depto = new Departamento(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
            }
            System.out.println("Departamento obtenido exitosamente.");
        } catch(SQLException e) {
            System.out.println("[SQL Depto] Error al intentar obtener la informacion: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return depto;
    }
    
    
    @Override
    public List<Departamento> listarDepartamentos(){
        List<Departamento> deptos = new ArrayList<>();
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_departamento ORDER BY id DESC";
            ResultSet rs = this.DBcon.Consultar(consulta);
            Departamento d;
            
            while(rs.next()) {
                d = new Departamento(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                deptos.add(d);
            }   
        } catch (SQLException e) {
            System.out.println("[SQLDepartamentoOpDAO] Error al listar departamentos: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return deptos;
    }
    
    
    @Override
    public String registrarDepartamento(Departamento depto) {
        String resultado = "";

        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "INSERT INTO IVANOBAJ.test_departamento (nombre, id_pais) VALUES ('" + depto.getNombre() + "' , " + depto.getId_pais() + ")";
            System.out.println("Registro depto query: " + consulta);
            this.DBcon.ExecUpIn(consulta);
            resultado = depto.toString();
        } catch (SQLException e) {
            System.out.println("[SQLDepartamentoDAO] Error al ingresar departamento: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return resultado;
    }
    
    
    @Override
    public Integer actualizarDepartamento(Departamento depto) {
        Integer resultado = 0;
        Integer id = 0;
        Departamento d = null;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_departamento WHERE id = " + depto.getId();
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            while(rs.next()){
                id = rs.getInt(1);
            }
            
            String queryUpdate = "UPDATE IVANOBAJ.test_departamento SET nombre = '" + depto.getNombre() + "', id_pais = " + depto.getId_pais() + " WHERE id = " + id;
            this.DBcon.ExecUpIn(queryUpdate);
            System.out.println("Depto Update listo ");
        } catch (SQLException e) {
            System.out.println("[SQLDepartamentoDAO] Error al actualizar departamento: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return resultado;
    }
    
    @Override
    public Integer eliminarDepartamento(Integer id) {
        Integer resultado = 0;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "DELETE FROM IVANOBAJ.test_departamento WHERE id = " + id;
            this.DBcon.ExecUpIn(consulta);
            System.out.println("Registro depto" + id + "eliminado");
        } catch (SQLException e) {
            System.out.println("[SQLDepartamentoDAO] Error al eliminar departamento: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return resultado;
    }
    
}
