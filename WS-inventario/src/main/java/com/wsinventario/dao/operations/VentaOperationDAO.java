/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.operations;

import Utils.PoolConnection2;
import com.wsinventario.dao.VentaDAO;
import com.wsinventario.dao.beans.DetalleFactura;
import com.wsinventario.dao.beans.Venta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivano
 */
public class VentaOperationDAO implements VentaDAO {
    PoolConnection2 DBcon = new PoolConnection2();
    String jdni = "jdbc/test";
    
    @Override
    public Venta obtenerVenta(Integer id) {
        Venta venta = null;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_venta WHERE id = " + id;
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            if(rs.next()) {
                venta = new Venta(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getFloat(3),
                        rs.getFloat(4)
                                        );
                
            }
            System.out.println("venta obtenido.");
        } catch(SQLException e) {
            System.out.println("[SQL Venta] Error al intentar obtener la informacion: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        return venta;
    }
    
    
    @Override
    public List<Venta> listarVentas(){
        System.out.println("cte operation dao");
        List<Venta> ventas = new ArrayList<>();
        Venta v = null;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_venta ORDER BY id DESC";
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            while(rs.next()) {
                v = new Venta(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getFloat(3),
                        rs.getFloat(4)
                );
                ventas.add(v);
            }
            System.out.println("venta obtenido.");
        } catch(SQLException e) {
            System.out.println("[SQL Venta] Error al intentar obtener la informacion: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        
        return ventas;
    }
    
}
