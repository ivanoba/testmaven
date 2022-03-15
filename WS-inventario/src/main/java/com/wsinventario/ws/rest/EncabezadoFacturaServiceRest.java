/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.ws.rest;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wsinventario.dao.beans.Departamento;
import com.wsinventario.dao.beans.DetalleFactura;
import com.wsinventario.dao.beans.EncabezadoFactura;
import com.wsinventario.service.DepartamentoService;
import com.wsinventario.service.DetalleFacturaService;
import com.wsinventario.service.EncabezadoFacturaService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ivano
 */

@Path("facturas")
public class EncabezadoFacturaServiceRest {
    
    public EncabezadoFacturaServiceRest(){        
    }
    
    @GET
    @Path("obtenerFactura")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerEncabezadoFactura(@QueryParam("id") Integer id) {
        try {
            EncabezadoFactura enc_fact = new EncabezadoFacturaService().obtenerEncabezadoFactura(id);
           //DetalleFactura det_fact = new DetalleFacturaService().obtenerDetalleFactura(id);
            String json = new Gson().toJson(enc_fact);
            //String json2 = new Gson().toJson(det_fact);
            //Response.ok(json2, MediaType.APPLICATION_JSON).build();
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    
    @GET
    @Path("listaFacturas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarEncabezadoFacturas(){
        try {
            List<EncabezadoFactura> facturas = new EncabezadoFacturaService().listarEncabezadoFacturas();
           // List<DetalleFactura> det_facturas = new DetalleFacturaService().listarDetalleFacturas();
            String json = new Gson().toJson(facturas);
           // String json2 = new Gson().toJson(det_facturas);
           // Response.ok(json2, MediaType.APPLICATION_JSON).build();
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registrarFactura")
    public Integer registrarEncabezadoFactura(String json){
        String enc = "";
        String det = "";
        String resultado = "";
        Integer id_factura = 0;
        Integer id = 0;
        
        try {
            //Gson gson = new Gson();
            JSONObject objJson = new JSONObject(json);
            
            EncabezadoFactura factura = new EncabezadoFactura(
                                            objJson.getInt("no_factura"),
                                            objJson.getString("serie_factura"),
                                            objJson.getInt("id_cliente"),
                                            objJson.getString("nombre"),
                                            objJson.getString("nit"),
                                            objJson.getString("fecha"),
                                            objJson.getString("direccion"),
                                            objJson.getFloat("total_factura")
            );
            id_factura = new EncabezadoFacturaService().registrarEncabezadoFactura(factura);
            //EncabezadoFactura id_enc = new EncabezadoFactura(id_factura);
            //id = id_enc.getId();
            
            System.out.println("id_factura: " + id_factura);
            JSONArray jsonArray = objJson.getJSONArray("detalle");

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject objDet = jsonArray.getJSONObject(i);
                
                DetalleFactura det_factura = new DetalleFactura(
                                                id_factura,
                                                objDet.getInt("id_producto"),
                                                objDet.getFloat("precio"),
                                                objDet.getFloat("cantidad"),
                                                objDet.getFloat("descuento"),
                                                objDet.getFloat("total")
                );
                det = new DetalleFacturaService().registrarDetalleFactura(det_factura);
                
            }
            
            resultado = factura.toString();
            //Departamento depto = (Departamento) gson.fromJson(json, Departamento.class);
            //resultado = new DepartamentoService().registrarDepartamento(depto);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return id_factura;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("actualizarFactura")
    public Integer actualizarEncabezadoFactura(String json){
        Integer resultado = 0;
        Integer enc = 0;
        Integer det = 0;
        
        try {
            //Gson gson = new Gson();
            JSONObject objJson = new JSONObject(json);
            
            EncabezadoFactura factura = new EncabezadoFactura(
                                            objJson.getInt("id"),
                                            objJson.getInt("no_factura"),
                                            objJson.getString("serie_factura"),
                                            objJson.getInt("id_cliente"),
                                            objJson.getString("nombre"),
                                            objJson.getString("nit"),
                                            objJson.getString("fecha"),
                                            objJson.getString("direccion"),
                                            objJson.getFloat("total_factura")
            );
            resultado = new EncabezadoFacturaService().actualizarEncabezadoFactura(factura);
            
            JSONArray jsonArray = objJson.getJSONArray("detalle");
            
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject objDet = jsonArray.getJSONObject(i);
                
                DetalleFactura det_factura = new DetalleFactura(
                                                objDet.getInt("id"),
                                                objDet.getInt("id_factura"),
                                                objDet.getInt("id_producto"),
                                                objDet.getFloat("precio"),
                                                objDet.getFloat("cantidad"),
                                                objDet.getFloat("descuento"),
                                                objDet.getFloat("total")
                );
                det = new DetalleFacturaService().actualizarDetalleFactura(det_factura);
                
            }

        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eliminarFactura")
    public Integer eliminarEncabezadoFactura(@QueryParam("id") Integer id) {
        Integer resultado = 0;
        try {
            resultado = new EncabezadoFacturaService().eliminarEncabezadoFactura(id);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
}
