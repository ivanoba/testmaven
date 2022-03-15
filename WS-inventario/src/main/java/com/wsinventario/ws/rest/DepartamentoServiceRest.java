package com.wsinventario.ws.rest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wsinventario.dao.beans.Departamento;
import com.wsinventario.service.DepartamentoService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ivano
 */

@Path("departamentos")
public class DepartamentoServiceRest {
    
    public DepartamentoServiceRest(){
    }
    
    @GET
    @Path("obtenerDepto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerDepartamento(@QueryParam("id") Integer id){
        try {
            Departamento depto = new DepartamentoService().obtenerDepartamento(id);
            String json = new Gson().toJson(depto);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @GET
    @Path("listaDeptos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarDepartamentos() {
        try {
            List<Departamento> deptos = new DepartamentoService().listarDepartamentos();
            String json = new Gson().toJson(deptos);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registrarDepto")
    public String registrarDepartamento(String json){
        String p = "";
        String resultado = "";
        try {
            //Gson gson = new Gson();
            JSONObject objJson = new JSONObject(json);
            Departamento depto = new Departamento(objJson.getString("nombre"), objJson.getInt("id_pais"));
            p = new DepartamentoService().registrarDepartamento(depto);
            resultado = depto.toString();
            //Departamento depto = (Departamento) gson.fromJson(json, Departamento.class);
            //resultado = new DepartamentoService().registrarDepartamento(depto);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("actualizarDepto")
    public Integer actualizarDepartamento(String json){
        Integer resultado = 0;
        try {
            //Gson gson = new Gson();
            JSONObject objJson = new JSONObject(json);
            Departamento depto = new Departamento(objJson.getInt("id"), objJson.getString("nombre"), objJson.getInt("id_pais")); 
            resultado = new DepartamentoService().actualizarDepartamento(depto);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eliminarDepto")
    public Integer eliminarDepartamento(@QueryParam("id") Integer id) {
        Integer resultado = 0;
        try {
            resultado = new DepartamentoService().eliminarDepartamento(id);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
}
