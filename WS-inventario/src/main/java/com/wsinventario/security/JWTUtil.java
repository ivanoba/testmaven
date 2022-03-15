/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wsinventario.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;


/**
 *
 * @author ivano
 */
public class JWTUtil {
    private String secret;
    
    public String generarToken(String usuario) throws IllegalArgumentException, JWTCreationException {
        return JWT.create()
                .withSubject("Detalles usuario")
                .withClaim("username", usuario)
                .withIssuedAt(new Date())
                .withIssuer("WS-Inventario/Inventario/Pentcloud")
                .sign(Algorithm.HMAC256(secret));
    }
    
    public String validarTokenYObtenerUsuario(String token) throws JWTVerificationException {
        JWTVerifier verificador = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("Detalles usuario")
                .withIssuer("WS-Inventario/Inventario/Pentcloud")
                .build();
        
        DecodedJWT jwt = verificador.verify(token);
        return jwt.getClaim("username").asString();
    }
    
    
    
}
