/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.service;

import com.wsinventario.dao.beans.EncabezadoFactura;
import com.wsinventario.dao.operations.EncabezadoFacturaOperationDAO;
import java.util.List;

/**
 *
 * @author ivano
 */
public class EncabezadoFacturaService {
    EncabezadoFacturaOperationDAO facturaOp = new EncabezadoFacturaOperationDAO();
    
    public EncabezadoFactura obtenerEncabezadoFactura(Integer id){
        return facturaOp.obtenerEncabezadoFactura(id);
    }
    
    public List<EncabezadoFactura> listarEncabezadoFacturas(){
        return facturaOp.listarEncabezadoFacturas();
    }
    
    public Integer registrarEncabezadoFactura(EncabezadoFactura encabezadoFactura){
        return facturaOp.registrarEncabezadoFactura(encabezadoFactura);
    }
    
    public Integer actualizarEncabezadoFactura(EncabezadoFactura encabezadoFactura){
        return facturaOp.actualizarEncabezadoFactura(encabezadoFactura);
    }
    
    public Integer eliminarEncabezadoFactura(Integer id){
        return facturaOp.eliminarEncabezadoFactura(id);
    }
}
