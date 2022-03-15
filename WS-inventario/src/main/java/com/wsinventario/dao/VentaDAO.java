/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.dao;

import com.wsinventario.dao.beans.Venta;
import java.util.List;

/**
 *
 * @author ivano
 */
public interface VentaDAO {
    public Venta obtenerVenta(Integer id);
    
    public List<Venta> listarVentas();
    
}
