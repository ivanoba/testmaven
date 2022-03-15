/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.operations;

import Utils.PoolConnection2;
import com.wsinventario.dao.DetalleFacturaDAO;
import com.wsinventario.dao.beans.DetalleFactura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivano
 */
public class DetalleFacturaOperationDAO implements DetalleFacturaDAO {
    PoolConnection2 DBcon = new PoolConnection2();
    String jdni = "jdbc/test";
    
    
    @Override
    public DetalleFactura obtenerDetalleFactura(Integer id) {
        DetalleFactura det_factura = null;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_detalle_factura WHERE id = " + id;
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            if(rs.next()) {
                det_factura = new DetalleFactura(
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getFloat(6),
                        rs.getFloat(7)
                );
                
            }
            System.out.println("Detalle factura obtenido.");
        } catch(SQLException e) {
            System.out.println("[SQL Detalle Factura] Error al intentar obtener la informacion: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
    
        return det_factura;
    }
    
    
    @Override
    public List<DetalleFactura> listarDetalleFacturas(){
        List<DetalleFactura> det_facturas = new ArrayList<>();
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_detalle_factura ORDER BY id DESC";
            ResultSet rs = this.DBcon.Consultar(consulta);
            DetalleFactura f;
            
            while(rs.next()) {
                f = new DetalleFactura(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getFloat(6),
                        rs.getFloat(7)
                );
                det_facturas.add(f);
            }   
        } catch (SQLException e) {
            System.out.println("[SQLDetFacturaOpDAO] Error al listar detalle facturas: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }

        return det_facturas;
    }
    
    @Override
    public String registrarDetalleFactura(DetalleFactura det_factura) {
        String resultado = "";
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "INSERT INTO IVANOBAJ.test_detalle_factura (id_factura, id_producto, precio, cantidad, descuento, total) VALUES "
                    + "(" + det_factura.getId_factura() + ", " + det_factura.getId_producto() + ", " + det_factura.getPrecio() + ", " 
                    + det_factura.getCantidad() + ", " + det_factura.getDescuento() + ", " + det_factura.getTotal() + ")";
            this.DBcon.ExecUpIn(consulta);
            
            resultado = det_factura.toString();
        } catch (SQLException e) {
            System.out.println("[SQLFactOpDAO] Error al ingresar det factura: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        
        return resultado;
    }
    
    @Override
    public Integer actualizarDetalleFactura(DetalleFactura det_factura) {
        Integer resultado = 0;
        Integer id = 0;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_detalle_factura WHERE id = " + det_factura.getId();
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            while(rs.next()){
                id = rs.getInt(1);
            }
            
            String queryUpdate = "UPDATE IVANOBAJ.test_detalle_factura SET id_factura = " +
                    det_factura.getId_factura() + ", id_producto = " + det_factura.getId_producto() + ", precio = " + det_factura.getPrecio() 
                    + ", cantidad = " + det_factura.getCantidad() + ", descuento = " + det_factura.getDescuento() + ", total = " + det_factura.getTotal() + " WHERE id = " + id;
            this.DBcon.ExecUpIn(queryUpdate);
            System.out.println("registro detalle Update listo ");
        } catch (SQLException e) {
            System.out.println("[SQLDetalleDAO] Error al actualizar detalle: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        return resultado;
    }
    
    @Override
    public Integer eliminarDetalleFactura(Integer id) {
        Integer resultado = 0;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "DELETE FROM IVANOBAJ.test_detalle_factura WHERE id = " + id;
            this.DBcon.ExecUpIn(consulta);
          
            System.out.println("Registro det factura " + id + "eliminado");
        } catch (SQLException e) {
            System.out.println("[SQLFacturaOpDAO] Error al eliminar factura: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        
        return resultado;
    }
}
