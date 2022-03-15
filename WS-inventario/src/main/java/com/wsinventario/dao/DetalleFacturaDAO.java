/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao;

import com.wsinventario.dao.beans.DetalleFactura;
import java.util.List;

/**
 *
 * @author ivano
 */
public interface DetalleFacturaDAO {
    public DetalleFactura obtenerDetalleFactura(Integer id);
    
    public List<DetalleFactura> listarDetalleFacturas();
    
    public String registrarDetalleFactura(DetalleFactura detalleFactura );
    
    public Integer actualizarDetalleFactura(DetalleFactura detalleFactura );
    
    public Integer eliminarDetalleFactura(Integer id);
}
