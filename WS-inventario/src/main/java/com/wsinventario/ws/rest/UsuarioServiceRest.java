/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.ws.rest;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wsinventario.dao.beans.Usuario;
import com.wsinventario.service.UsuarioService;
import java.util.List;
import javax.ws.rs.Consumes;
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
@Path("usuarios")
public class UsuarioServiceRest {
    
    public UsuarioServiceRest(){
    }
    
    @GET
    @Path("obtenerUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerUsuario(@QueryParam("id") Integer id){
        Response respuesta;
        
        try {
            Usuario user = new UsuarioService().obtenerUsuario(id);
            String json = new Gson().toJson(user);
            respuesta = Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            respuesta = Response.status(Response.Status.SEE_OTHER).entity("[UserSR] Error al obtener user: " + e.toString()).build();
        }
        return respuesta;
    }
    
    @GET
    @Path("obtenerUsername")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerNombreUsuario(String username){
        Response respuesta;
        
        try {
            Usuario user = new UsuarioService().obtenerNombreUsuario(username);
            String json = new Gson().toJson(user);
            respuesta = Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            respuesta = Response.status(Response.Status.SEE_OTHER).entity("[UserSR] Error al obtener username: " + e.toString()).build();
        }
        return respuesta;
    }
    
    
    
    @GET
    @Path("listaUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuarios(){
        Response respuesta;
        try {
            List<Usuario> users = new UsuarioService().listarUsuarios();
            String json = new Gson().toJson(users);
            respuesta = Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            respuesta = Response.status(Response.Status.SEE_OTHER).entity("[UserSR] Error al listar users: " + e.toString()).build();
        }
        return respuesta;
    }
    
    @POST
    @Path("loginUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer loginUsuario (String credentials) {
        Integer resultado = 0;
        
        try {
            JSONObject objJson = new JSONObject(credentials);
            Usuario user = new Usuario(
                                    objJson.getString("username"),
                                    objJson.getString("contrasenia")
            );
            resultado = new UsuarioService().loginUsuario(user);
        } catch(JsonSyntaxException e) {
            System.out.println("[UserSR] Error en login: " + e);
        }
        
        return resultado;
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registrarUser")
    public String registrarUsuario(String json){
        String resultado = "";
        String u = "";
        
        try {
            JSONObject objJson = new JSONObject(json);
            
            Usuario user = new Usuario(
                                    objJson.getString("nombre"),
                                    objJson.getString("email"),
                                    objJson.getString("username"),
                                    objJson.getString("contrasenia")
            );
            u = new UsuarioService().registrarUsuario(user);
            resultado = user.toString();
        } catch(JsonSyntaxException e) {
            System.out.println("[UserSR] Error al registrar usuario: " + e);
        }
        return resultado;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("actualizarUser")
    public Integer actualizarUsuario(String json){
        Integer resultado = 0;
        try {
            JSONObject objJson = new JSONObject(json);
            Usuario user = new Usuario(
                                    objJson.getInt("id"),
                                    objJson.getString("nombre"),
                                    objJson.getString("email"),
                                    objJson.getString("username"),
                                    objJson.getString("contrasenia")  
            );
            resultado = new UsuarioService().actualizarUsuario(user);
        } catch(JsonSyntaxException e) {
            System.out.println("[UserSR] Error al actualizar el usuario: " + e);
        }
        return resultado;
    }
    
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("eliminarUser")
    public Integer eliminarUsuario(@QueryParam("id") Integer id) {
        Integer resultado = 0;
        try {
            resultado = new UsuarioService().eliminarUsuario(id);
        } catch (JsonSyntaxException e) {
            System.out.println("[UserSR] Error al eliminar usuario: " + e);
        }
        return resultado;
    }
    
}
