package com.wsinventario.ws.rest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.google.gson.Gson;
import com.wsinventario.dao.beans.Venta;
import com.wsinventario.service.VentaService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author ivano
 */
@Path("ventas")
public class VentaServiceRest {
    public VentaServiceRest(){
    }
    
    @GET
    @Path("obtenerVenta")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerCliente(@QueryParam("id") Integer id){
        try {
            Venta venta = new VentaService().obtenerVenta(id);
            String json = new Gson().toJson(venta);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @GET
    @Path("listaVentas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarClientes() {
        try{
            List<Venta> ctes = new VentaService().listarVentas();
            String json = new Gson().toJson(ctes);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
}
