<%-- 
    Document   : pais
    Created on : 28/02/2022, 17:14:57
    Author     : ivano
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventario - Gestion Pa&iacute;s</title>
    </head>
    <body>
        <%@page import="com.wsinventario.dao.PaisDAO,com.wsinventario.dao.bean.*,java.util.*" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
        <h1>Gestion Pa&iacute;s</h1>
        
        <% 
            List<Pais> list= Pais.listarPaises();
            request.setAttribute("list", list);
        %>
        
        <table border="1" width="90%">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
            </tr>
            
            <c:forEach items="${list}" var="u">
                <tr>
                    <td>${u.getId()}</td>
                    <td>${u.getNombre()}</td>
                </tr>
            </c:forEach>
        </table>
        
        
    </body>
</html>
