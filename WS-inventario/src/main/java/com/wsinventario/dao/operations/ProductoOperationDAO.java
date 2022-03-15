/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.operations;

import Utils.PoolConnection2;
import com.wsinventario.dao.ProductoDAO;
import com.wsinventario.dao.beans.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivano
 */
public class ProductoOperationDAO implements ProductoDAO {
    PoolConnection2 DBcon = new PoolConnection2();
    String jdni = "jdbc/test";
    
    @Override
    public Producto obtenerProducto(Integer id) {
        Producto producto = null;
        Producto p;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_producto WHERE id = " + id;
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            if(rs.next()) {
                producto = new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getFloat(6)
                );
            }
            System.out.println("Producto obtenido exitosamente.");
        } catch (SQLException e) {
            System.out.println("[SQL Depto] Error al intentar obtener la informacion: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return producto;
    }
    
    
    @Override
    public List<Producto> listarProductos(){
        List<Producto> prods = new ArrayList<>();
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_producto ORDER BY id DESC";
            ResultSet rs = this.DBcon.Consultar(consulta);
            Producto producto;
            
            while(rs.next()) {
                producto = new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getFloat(6)
                );
                prods.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("[SQLProductoOpDAO] Error al listar productos: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return prods;
    }
    
    @Override
    public String registrarProducto(Producto prod) {
        String resultado = "";
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "INSERT INTO IVANOBAJ.test_producto (nombre, descripcion, cantidad, costo_unitario, precio_venta_unitario) "
                    + "VALUES ('" + prod.getNombre() + "', '" + prod.getDescripcion() + "', " + prod.getCantidad() + ", " + prod.getCosto_unitario() + ", " + prod.getPrecio_venta_unitario() + ")";
            this.DBcon.ExecUpIn(consulta);
            resultado = prod.toString();
        } catch (SQLException e) {
            System.out.println("[SQLProductoOpDAO] Error al ingresar producto: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return resultado;
    }
    
    @Override
    public Integer actualizarProducto(Producto prod) {
        Integer resultado = 0;
        Integer id = 0;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_producto WHERE id = " + prod.getId();
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            while(rs.next()) {
                id = rs.getInt(1);
            }
            
            String queryUpdate = "UPDATE IVANOBAJ.test_producto SET nombre = '" + prod.getNombre() 
                    + "', descripcion = '" + prod.getDescripcion() + "', cantidad = " + prod.getCantidad() 
                    + ", costo_unitario = " + prod.getCosto_unitario() + ", precio_venta_unitario = " 
                    + prod.getPrecio_venta_unitario() + " WHERE id = " + id;
            this.DBcon.ExecUpIn(queryUpdate);
            System.out.println("Producto actualizado, id: " + id);
        } catch (SQLException e) {
            System.out.println("[SQLProductoOpDAO] Error al actualizar producto: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return resultado;
    }
    
    @Override
    public Integer eliminarProducto(Integer id) {
        Integer resultado = 0;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "DELETE FROM IVANOBAJ.test_producto WHERE id = " + id;
            this.DBcon.ExecUpIn(consulta);
            System.out.println("Registro producto " + id + "eliminado");
        } catch (SQLException e) {
            System.out.println("[SQLProductoOpDAO] Error al eliminar producto: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return resultado;
    }
}
