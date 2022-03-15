/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.operations;
import Utils.Acknowledgement;
import com.wsinventario.dao.PaisDAO;
import com.wsinventario.dao.beans.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utils.PoolConnection2;
import java.sql.DriverManager;
import org.json.JSONObject;
/**
 *
 * @author ivano
 */
public class PaisOperationDAO implements PaisDAO {
    PoolConnection2 DBcon = new PoolConnection2();
    //Acknowledgement akno = new Acknowledgement();
    //JSONObject response = new JSONObject();
    String jdni = "jdbc/test";
    
    @Override
    public Pais obtenerPais(Integer id) {
        Pais pais = null;
        this.DBcon.conectarJNDI(jdni);

        try {
            String consulta = "SELECT * FROM IVANOBAJ.test_pais WHERE id = " + id ;
            ResultSet rs = this.DBcon.Consultar(consulta);
                 
            if(rs.next()){
                pais = new Pais(
                        rs.getInt(1),
                        rs.getString(2)
                );      
            }
            
        } catch (SQLException e) {
            System.out.println("[SQL Pais] Error al intentar obtener la informacion:" + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        return pais;
    }
    
    @Override
    public List<Pais> listarPaises(){
        List<Pais> paises = new ArrayList<Pais>();
        this.DBcon.conectarJNDI(jdni);       
        try {
            String consulta = "SELECT * FROM IVANOBAJ.test_pais ORDER BY id DESC";
            ResultSet rs = this.DBcon.Consultar(consulta);
            Pais p;
            
            while(rs.next()) {
                p = new Pais(
                        rs.getInt(1),
                        rs.getString(2)
                );
                paises.add(p);
            }
            System.out.println("Lista de paises obtenida exitosamente.");
        } catch(SQLException e) {
            System.out.println("[SQL Pais] Error al intentar obtener la informacion: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return paises;
    }
    
    
    @Override
    public String registrarPais(Pais pais){
        String resultado = "";
        String consulta = "INSERT INTO IVANOBAJ.test_pais (nombre) VALUES ('" + pais.getNombre() + "')";
        this.DBcon.conectarJNDI(jdni);

        try {
            this.DBcon.ExecUpIn(consulta);
            resultado = pais.toString();
        } catch (SQLException e) {
            System.out.println("[SQLPaisDAO] Error al insertar pais: " + e);
            /*this.akno.Error();
            this.akno.setDescription("Error, " + e.toString());*/
            //resultado = this.akno.ParseResponse(response);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return resultado;
    }
    
    
    @Override
    public Integer actualizarPais(Pais pais){
        Integer resultado = 0;
        Pais p = null;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            Integer id = 0;
            String obtenerPais = "SELECT * FROM IVANOBAJ.test_pais WHERE id = " + pais.getId();
            ResultSet rs = this.DBcon.Consultar(obtenerPais);
            
            while(rs.next()){
                id = rs.getInt(1);
            }
            
            String queryUpdate = "UPDATE IVANOBAJ.test_pais SET nombre = '" + pais.getNombre() + "' WHERE id = " + id;
            this.DBcon.ExecUpIn(queryUpdate);
            System.out.println("Pais queryUpdate listo");
            /*
            System.out.println(pais.toString());
            System.out.println(queryUpdate);
            */
        } catch (SQLException | RuntimeException e) {
            System.out.println("[SQLPaisDAO] Error al actualizar pais: " + e);
            /*this.akno.Error();
            this.akno.setDescription("Error, " + e.toString());*/
        } finally {
            System.out.println("Se cierra la conexion");
            this.DBcon.cerrarConexion();
        }
   
        return resultado;
    }
    
    @Override
    public Integer eliminarPais(Integer id){
        Integer resultado = 0;
        Pais p = null;
        this.DBcon.conectarJNDI(jdni);
        try {
            String consulta = "DELETE FROM IVANOBAJ.test_pais WHERE id = " + id;
            this.DBcon.ExecUpIn(consulta);
            System.out.println(consulta);
        } catch (SQLException e) {
            System.out.println("[SQL Pais] Error al eliminar pais:" + e);
            /*this.akno.Error();
            this.akno.setDescription("Error, " + e.toString());*/
        } finally {
            this.DBcon.cerrarConexion();
        }
        return resultado;
    }
    
}
