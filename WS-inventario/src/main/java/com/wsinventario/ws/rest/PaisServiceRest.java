/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.ws.rest;

import Utils.Acknowledgement;
import com.wsinventario.dao.beans.Pais;
import com.wsinventario.service.PaisService;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import javax.ws.rs.Consumes;

import java.util.List;
import java.util.Properties;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 *
 * @author ivano
 */

@Path("paises")
public class PaisServiceRest {
    //Acknowledgement akno = new Acknowledgement();
    //SONObject response = new JSONObject();
    
    
    public PaisServiceRest(){
    }
    
    @GET
    @Path("obtenerPais")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPais(@QueryParam("id") Integer id){
        try {
            Pais pais = new PaisService().obtenerPais(id);
            String json = new Gson().toJson(pais);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @GET
    @Path("listaPaises")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPaises() {
        try{
            List<Pais> paises = new PaisService().listarPaises();
            String json = new Gson().toJson(paises);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registrarPais")
    public String registrarPais(String json){
        String p = "";
        String resultado = "";
        
        try {
            //this.akno.setFunctionName("procedureRegisterCountry");
           // JSONObject group = new JSONObject(json);
            //JSONObject req = group.getJSONObject("procedureRegisterCountry");
            
            Gson gson = new Gson();
            System.out.println("El json es: " + json);
            JSONObject objJson = new JSONObject(json);
            Pais pais = new Pais(objJson.getString("nombre"));
            p = new PaisService().registrarPais(pais);
            /*
            if(p != null && !this.akno.HasError()){
                this.akno.setDescription("Usuario registrado exitosamente.");
            } else {
                this.akno.setDescription("Error, pais no registrado");
                this.akno.Error();
            }
            this.response.put("AcknowledgementIndicator", this.akno.getIndicator());
            this.response.put("AcknowledgementCode", this.akno.getCode());
            this.response.put("AcknowledgementDescription", this.akno.getDescription());
 */           System.out.println(pais.toString());
            resultado = pais.toString();
        } catch (JsonSyntaxException e) {
            System.out.println("Error registrarPaisRst: " + e);
            /*this.akno.Error();
            this.akno.setDescription(e.toString());
            this.response.put("AcknowledgementIndicator", this.akno.getIndicator());
            this.response.put("AcknowledgementCode", this.akno.getCode());
            this.response.put("AcknowledgementDescription", this.akno.getDescription());
            resultado = this.akno.ParseResponse(this.response);*/
        }
        return resultado;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("actualizarPais")
    public Integer actualizarPais(String json){
        Integer resultado = 0;
        try {
            Gson gson = new Gson();
            JSONObject objJson = new JSONObject(json);
            Pais pais = new Pais(objJson.getInt("id"), objJson.getString("nombre"));
            resultado = new PaisService().actualizarPais(pais);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eliminarPais")
    public Integer eliminarPais(@QueryParam("id") Integer id) {
        Integer resultado = 0;
        try {
            resultado = new PaisService().eliminarPais(id);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
    
   
}
