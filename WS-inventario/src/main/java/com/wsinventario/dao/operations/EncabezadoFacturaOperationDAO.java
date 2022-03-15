/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.operations;

import Utils.PoolConnection2;
import com.wsinventario.dao.EncabezadoFacturaDAO;
import com.wsinventario.dao.beans.DetalleFactura;
import com.wsinventario.dao.beans.EncabezadoFactura;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivano
 */
public class EncabezadoFacturaOperationDAO implements EncabezadoFacturaDAO {
    PoolConnection2 DBcon = new PoolConnection2();
    String jdni = "jdbc/test";
    
    @Override
    public EncabezadoFactura obtenerEncabezadoFactura(Integer id) {
        EncabezadoFactura factura = null;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_factura WHERE id = " + id;
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            if(rs.next()) {
                factura = new EncabezadoFactura(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getFloat(9)
                );
                
            }
            System.out.println("Encabezado factura obtenido.");
        } catch(SQLException e) {
            System.out.println("[SQL Factura] Error al intentar obtener la informacion: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        return factura;
    }
    
    
    @Override
    public List<EncabezadoFactura> listarEncabezadoFacturas(){
        List<EncabezadoFactura> facturas = new ArrayList<>();
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_factura ORDER BY id DESC";
            ResultSet rs = this.DBcon.Consultar(consulta);
            EncabezadoFactura f;
            
            while(rs.next()) {
                f = new EncabezadoFactura(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getFloat(9)
                );
                facturas.add(f);
            }   
        } catch (SQLException e) {
            System.out.println("[SQLFacturaOpDAO] Error al listar facturas: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }

        return facturas;
    }
    
    @Override
    public Integer registrarEncabezadoFactura(EncabezadoFactura factura) {
        Integer id_factura = 0;
        String resultado = "";
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "BEGIN INSERT INTO test_factura (no_factura, serie_factura, id_cliente, nombre, nit, fecha, direccion, total_factura) "
                    + "VALUES (" + factura.getNo_factura() + ", '" + factura.getSerie_factura() + "', " + factura.getId_cliente() + ", '" + factura.getNombre() 
                    + "', '" + factura.getNit() + "', To_date('" + factura.getFecha() + "', 'dd/mm/yyyy'), '" + factura.getDireccion() + "', " + factura.getTotal_factura() 
                    + ") returning id into ?; END;";

            id_factura = this.DBcon.Create(consulta);
            //this.DBcon.ExecUpIn(consulta);
            resultado = factura.toString();
        } catch (SQLException e) {
            System.out.println("[SQLFactOpDAO] Error al ingresar factura: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return id_factura;
    }
    
    @Override
    public Integer actualizarEncabezadoFactura(EncabezadoFactura factura) {
        Integer resultado = 0;
        Integer id = 0;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_factura WHERE id = " + factura.getId();
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            while(rs.next()){
                id = rs.getInt(1);
            }
            
            String queryUpdate = "UPDATE IVANOBAJ.test_factura SET no_factura = " + factura.getNo_factura() + ", serie_factura = '" + factura.getSerie_factura() + "', id_cliente = " + factura.getId_cliente() + ", nombre = '" + factura.getNombre() 
                    + "', nit = '" + factura.getNit() + "', fecha = '" + factura.getFecha() + "', direccion = '" + factura.getDireccion() + "', total_factura = " + factura.getTotal_factura() + " WHERE id = " + id;
            this.DBcon.ExecUpIn(queryUpdate);
            System.out.println("factura Update listo ");
        } catch (SQLException e) {
            System.out.println("[SQLFacturaDAO] Error al actualizar factura: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        return resultado;
    }
    
    @Override
    public Integer eliminarEncabezadoFactura(Integer id) {
        Integer resultado = 0;

                       
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "DELETE FROM IVANOBAJ.test_factura WHERE id = " + id;
            this.DBcon.ExecUpIn(consulta);
          
            System.out.println("Registro factura " + id + "eliminado");
        } catch (SQLException e) {
            System.out.println("[SQLFacturaOpDAO] Error al eliminar factura: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        return resultado;
    }
}
