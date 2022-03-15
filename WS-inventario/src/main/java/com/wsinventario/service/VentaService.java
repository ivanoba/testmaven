/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.service;

import com.wsinventario.dao.beans.Venta;
import com.wsinventario.dao.operations.VentaOperationDAO;
import java.util.List;

/**
 *
 * @author ivano
 */
public class VentaService {
    VentaOperationDAO ventaOp = new VentaOperationDAO();
    
    public Venta obtenerVenta(Integer id){
        return ventaOp.obtenerVenta(id);
    }
    
    public List<Venta> listarVentas(){
        return ventaOp.listarVentas();
    }
    
}
