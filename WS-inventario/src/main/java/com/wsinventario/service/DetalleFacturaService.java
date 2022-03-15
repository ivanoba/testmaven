/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.service;

import com.wsinventario.dao.beans.DetalleFactura;
import com.wsinventario.dao.operations.DetalleFacturaOperationDAO;
import java.util.List;

/**
 *
 * @author ivano
 */
public class DetalleFacturaService {
    DetalleFacturaOperationDAO det_factura = new DetalleFacturaOperationDAO();
    
    public DetalleFactura obtenerDetalleFactura(Integer id){
        return det_factura.obtenerDetalleFactura(id);
    }
    
    public List<DetalleFactura> listarDetalleFacturas(){
        return det_factura.listarDetalleFacturas();
    }
    
    public String registrarDetalleFactura(DetalleFactura detalleFactura ){
        return det_factura.registrarDetalleFactura(detalleFactura);
    }
    
    public Integer actualizarDetalleFactura(DetalleFactura detalleFactura ){
        return det_factura.actualizarDetalleFactura(detalleFactura);
    }
    
    public Integer eliminarDetalleFactura(Integer id){
        return det_factura.eliminarDetalleFactura(id);
    }
}
