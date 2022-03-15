package com.wsinventario.ws.rest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wsinventario.dao.beans.Producto;
import com.wsinventario.service.ProductoService;
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
@Path("productos")
public class ProductoServiceRest {
    
    public ProductoServiceRest(){       
    }
    
    @GET
    @Path("obtenerProd")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerProducto(@QueryParam("id") Integer id){
        try {
            Producto prod = new ProductoService().obtenerProducto(id);
            String json = new Gson().toJson(prod);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @GET
    @Path("listaProds")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductos() {
        try{
            List<Producto> prods = new ProductoService().listarProductos();
            String json = new Gson().toJson(prods);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registrarProd")
    public String registrarProducto(String json){
        String resultado = "";
        String p = "";
        try {
            //Gson gson = new Gson();
            JSONObject objJson = new JSONObject(json);
            Producto prod = new Producto(
                                        objJson.getString("nombre"),
                                        objJson.getString("descripcion"),
                                        objJson.getFloat("cantidad"),
                                        objJson.getFloat("costo_unitario"),
                                        objJson.getFloat("precio_venta_unitario")
                                        );
            p = new ProductoService().registrarProducto(prod);
            resultado = prod.toString();
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("actualizarProd")
    public Integer actualizarProducto(String json){
        Integer resultado = 0;
        try {
            //Gson gson = new Gson();
            JSONObject objJson = new JSONObject(json);
            Producto prod = new Producto(
                                        objJson.getInt("id"),
                                        objJson.getString("nombre"),
                                        objJson.getString("descripcion"),
                                        objJson.getFloat("cantidad"),
                                        objJson.getFloat("costo_unitario"),
                                        objJson.getFloat("precio_venta_unitario")
                                        );
            resultado = new ProductoService().actualizarProducto(prod);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eliminarProd")
    public Integer eliminarProducto(@QueryParam("id") Integer id) {
        Integer resultado = 0;
        try {
            resultado = new ProductoService().eliminarProducto(id);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
}
