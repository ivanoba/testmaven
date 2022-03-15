/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao.operations;

import Utils.PoolConnection2;
import com.wsinventario.dao.InventarioDAO;
import com.wsinventario.dao.beans.Inventario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivano
 */
public class InventarioOperationDAO implements InventarioDAO {
    PoolConnection2 DBcon = new PoolConnection2();
    String jdni = "jdbc/test";
    
    @Override
    public Inventario obtenerInventario(Integer id) {
        Inventario inventario = null;
        //Inventario inv;
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_inventario WHERE id = " + id;
            ResultSet rs = this.DBcon.Consultar(consulta);
            
            if(rs.next()){
                System.out.println("Entra a if rs.next");
                inventario = new Inventario(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3)
                );
            }
            System.out.println("Inventario obtenido exitosamente");
        } catch (SQLException e) {
            System.out.println("[SQL Inventario] Error al intentar obtener la informacion: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return inventario;
    }
    
    
    @Override
    public List<Inventario> listarInventarios(){
        List<Inventario> invs = new ArrayList<>();
        
        try {
            this.DBcon.conectarJNDI(jdni);
            String consulta = "SELECT * FROM IVANOBAJ.test_inventario ORDER BY id DESC";
            ResultSet rs = this.DBcon.Consultar(consulta);
            Inventario inventario;
            
            while(rs.next()){
                inventario = new Inventario(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3)
                );
                invs.add(inventario);
            }
        } catch (SQLException e) {
            System.out.println("[SQLInventarioOpDAO] Error al listar inventario: " + e);
        } finally {
            this.DBcon.cerrarConexion();
        }
        return invs;
    }
}
