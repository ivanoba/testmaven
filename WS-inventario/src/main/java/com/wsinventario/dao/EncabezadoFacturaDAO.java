/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao;

import com.wsinventario.dao.beans.EncabezadoFactura;
import java.util.List;

/**
 *
 * @author ivano
 */
public interface EncabezadoFacturaDAO {
    public EncabezadoFactura obtenerEncabezadoFactura(Integer id);
    
    public List<EncabezadoFactura> listarEncabezadoFacturas();
    
    public Integer registrarEncabezadoFactura(EncabezadoFactura encabezadoFactura);
    
    public Integer actualizarEncabezadoFactura(EncabezadoFactura encabezadoFactura);
    
    public Integer eliminarEncabezadoFactura(Integer id);
}
