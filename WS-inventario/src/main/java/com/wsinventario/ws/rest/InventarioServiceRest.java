package com.wsinventario.ws.rest;

import com.google.gson.Gson;
import com.wsinventario.dao.beans.Inventario;
import com.wsinventario.service.InventarioService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ivano
 */
@Path("inventario")
public class InventarioServiceRest {
    
    public InventarioServiceRest() {
    }
    
    
    @GET
    @Path("obtenerInv")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerInventario(@QueryParam("id") Integer id){
        try {
            Inventario inv = new InventarioService().obtenerInventario(id);
            String json = new Gson().toJson(inv);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @GET
    @Path("listaInv")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarInventarios() {
        try{
            List<Inventario> inv = new InventarioService().listarInventarios();
            String json = new Gson().toJson(inv);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
}
