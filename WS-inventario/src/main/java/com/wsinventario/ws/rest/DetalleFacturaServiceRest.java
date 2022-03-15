package com.wsinventario.ws.rest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wsinventario.dao.beans.DetalleFactura;
import com.wsinventario.service.DetalleFacturaService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author ivano
 */
@Path("detalleFacturas")
public class DetalleFacturaServiceRest {
    public DetalleFacturaServiceRest(){
    }
    
    @GET
    @Path("obtenerDetFact")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerDetalleFactura(@QueryParam("id") Integer id){
        try {
            DetalleFactura det_factura = new DetalleFacturaService().obtenerDetalleFactura(id);
            String json = new Gson().toJson(det_factura);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @GET
    @Path("listaDetFacts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarDetalleFacturas() {
        try{
            List<DetalleFactura> det_facturas = new DetalleFacturaService().listarDetalleFacturas();
            String json = new Gson().toJson(det_facturas);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registrarDetFact")
    public String registrarDetalleFactura(String json){
        String resultado = "";
        String det = "";
        
        try {

            JSONObject objJson = new JSONObject(json);
                
            DetalleFactura det_factura = new DetalleFactura(
                                            objJson.getInt("id_factura"),
                                            objJson.getInt("id_producto"),
                                            objJson.getFloat("precio"),
                                            objJson.getFloat("cantidad"),
                                            objJson.getFloat("descuento"),
                                            objJson.getFloat("total")
            );
            det  = new DetalleFacturaService().registrarDetalleFactura(det_factura);
            resultado = det_factura.toString();
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("actualizarDetFact")
    public Integer actualizarDetalleFactura(String json){
        Integer resultado = 0;
        String det = "";
        
        try {
            JSONObject objJson = new JSONObject(json);
                
            DetalleFactura det_factura = new DetalleFactura(
                                                objJson.getInt("id"),
                                                objJson.getInt("id_factura"),
                                                objJson.getInt("id_producto"),
                                                objJson.getFloat("precio"),
                                                objJson.getFloat("cantidad"),
                                                objJson.getFloat("descuento"),
                                                objJson.getFloat("total")
            );

            resultado = new DetalleFacturaService().actualizarDetalleFactura(det_factura);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eliminarDetFact")
    public Integer eliminarDetalleFactura(@QueryParam("id") Integer id) {
        Integer resultado = 0;
        try {
            resultado = new DetalleFacturaService().eliminarDetalleFactura(id);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
}
