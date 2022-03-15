package com.wsinventario.ws.rest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wsinventario.dao.beans.Cliente;
import com.wsinventario.security.Secured;
import com.wsinventario.service.ClienteService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Path("clientes")
public class ClienteServiceRest {
    
    public ClienteServiceRest(){
    }
    
    @GET
    @Path("obtenerCte")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerCliente(@QueryParam("id") Integer id){
        try {
            Cliente cte = new ClienteService().obtenerCliente(id);
            String json = new Gson().toJson(cte);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @GET
    @Path("listaCtes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarClientes() {
        try{
            List<Cliente> ctes = new ClienteService().listarClientes();
            String json = new Gson().toJson(ctes);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registrarCte")
    public String registrarCliente(String json){
        String resultado = "";
        String c = "";

        try {
            JSONObject objJson = new JSONObject(json);
            
            Cliente cte = new Cliente(
                                    objJson.getString("nombre"),
                                    objJson.getString("representante"),
                                    objJson.getString("nit"),
                                    objJson.getInt("telefono"),
                                    objJson.getString("direccion"),
                                    objJson.getString("email"),
                                    objJson.getString("dob"),
                                    objJson.getInt("id_depto")
            );
            c = new ClienteService().registrarCliente(cte);
            resultado = cte.toString();
        } catch (JsonSyntaxException e) {
            System.out.println("[CteSR] Error al registrar cliente: " + e);
        }
        return resultado;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("actualizarCte")
    public Integer actualizarCliente(String json){
        Integer resultado = 0;
        try {
            JSONObject objJson = new JSONObject(json);
            Cliente cte = new Cliente(
                                    objJson.getInt("id"),
                                    objJson.getString("nombre"),
                                    objJson.getString("representante"),
                                    objJson.getString("nit"),
                                    objJson.getInt("telefono"),
                                    objJson.getString("direccion"),
                                    objJson.getString("email"),
                                    objJson.getString("dob"),
                                    objJson.getInt("id_depto")
            );
            resultado = new ClienteService().actualizarCliente(cte);
        } catch (JsonSyntaxException e) {
            System.out.println("[CteSR] Error al actualizar cliente: " + e);
        }
        return resultado;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eliminarCte")
    public Integer eliminarCliente(@QueryParam("id") Integer id) {
        Integer resultado = 0;
        try {
            resultado = new ClienteService().eliminarCliente(id);
        } catch (JsonSyntaxException e) {
            System.out.println("[CteSR] Error al eliminar cliente: " + e);
        }
        return resultado;
    }
    
    
}
