/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.webservices;

import javax.ws.rs.core.Application;
import java.util.Set;

/**
 *
 * @author ivano
 */

@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.wsinventario.security.JWTFilter.class);
        resources.add(com.wsinventario.ws.rest.ClienteServiceRest.class);
        resources.add(com.wsinventario.ws.rest.DepartamentoServiceRest.class);
        resources.add(com.wsinventario.ws.rest.DetalleFacturaServiceRest.class);
        resources.add(com.wsinventario.ws.rest.EncabezadoFacturaServiceRest.class);
        resources.add(com.wsinventario.ws.rest.InventarioServiceRest.class);
        resources.add(com.wsinventario.ws.rest.PaisServiceRest.class);
        resources.add(com.wsinventario.ws.rest.ProductoServiceRest.class);
        resources.add(com.wsinventario.ws.rest.UsuarioServiceRest.class);
        resources.add(com.wsinventario.ws.rest.VentaServiceRest.class);
    }
    
}
