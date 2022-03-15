/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wsinventario.dao.beans.Usuario;
import com.wsinventario.dao.operations.UsuarioOperationDAO;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ivano
 */
@Provider
@Secured
public class JWTFilter implements ContainerRequestFilter {
    private UsuarioOperationDAO usuarioOp;
    private JWTUtil jwtUtil;
    
    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        
        String jwt = request.getHeaderString("Authorization");
        if(jwt != null && !jwt.isEmpty()) {
            
            try {
                String username = jwtUtil.validarTokenYObtenerUsuario(jwt);
                Usuario usuario = usuarioOp.obtenerNombreUsuario(username);
                
                if(usuario != null) {
                    System.out.println("UserAuth" + usuario.toString());
                } else {
                    request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                }
            } catch (JWTVerificationException ex) {
                //request.sendError(HttpServletResponse.SC_BAD_REQUEST, "Token JWT invalido.");
                request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }            
            
        }
        
    }
    
}
