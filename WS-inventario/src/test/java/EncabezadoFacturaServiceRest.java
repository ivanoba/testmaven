

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wsinventario.dao.beans.Departamento;
import com.wsinventario.dao.beans.EncabezadoFactura;
import com.wsinventario.service.DepartamentoService;
import com.wsinventario.service.EncabezadoFacturaService;
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
public class EncabezadoFacturaServiceRest {
    public EncabezadoFacturaServiceRest(){
    }
    
    @GET
    @Path("obtenerFactura")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerencabezadoFactura(@QueryParam("id") Integer id) {
        try {
            EncabezadoFactura enc_fact = new EncabezadoFacturaService().obtenerEncabezadoFactura(id);
            //DetalleFactura det_fact = new DetalleFacturaService().obtenerDetalleFactura(id);
            String json = new Gson().toJson(enc_fact);
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
            String json = new Gson().toJson(facturas);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch(Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registrarFactura")
    public Integer registrarEncabezadoFactura(String json){
        String p = "";
        String resultado = "";
        try {
            //Gson gson = new Gson();
            JSONObject objJson = new JSONObject(json);
            
            EncabezadoFactura factura = new EncabezadoFactura(
                                            objJson.getInt("no_factura"),
                                            objJson.getString("serie_factura"),
                                            objJson.getString("nombre"),
                                            objJson.getString("nit"),
                                            objJson.getString("fecha"),
                                            objJson.getString("direccion"),
                                            objJson.getFloat("total_factura")
            );
            p = new EncabezadoFacturaService().registrarEncabezadoFactura(factura);
            
            resultado = factura.toString();
            //Departamento depto = (Departamento) gson.fromJson(json, Departamento.class);
            //resultado = new DepartamentoService().registrarDepartamento(depto);
        } catch (JsonSyntaxException e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }*/
    
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
