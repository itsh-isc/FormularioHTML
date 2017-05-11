<%@page import="itsh.pw.webservice.shared.model.dto.PerfilUsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfiles</title>
    </head>
    <body>
        <h1>Perfiles de Usuario</h1>
        
        
        <%
            List<PerfilUsuarioDTO> list = (List<PerfilUsuarioDTO>)session.getAttribute("perfiles"); 
            if(list != null){
                if(list.size() > 0){
                    for(PerfilUsuarioDTO dto : list){
                        out.println("<table border=\"1\">");
                        out.println("<tr>");
                            out.println("<td>Id Perfil</td>");
                            out.println("<td>" + dto.getIdPerfilUsuario() + "</td>");
                        out.println("</tr>");
                        out.println("<tr>");
                            out.println("<td>Nombre</td>");
                            out.println("<td>" + dto.getNombre() + "</td>");
                        out.println("</tr>");
                        out.println("<tr>");
                            out.println("<td>Apellidos</td>");
                            out.println("<td>" + dto.getApellidoP() + " "  + dto.getApellidoM() + "</td>");
                        out.println("</tr>");
                        out.println("</table><br>");
                    }
                }else{
                    out.println("<p>No existen perfiles para el usuario " + session.getAttribute("idUsuario") + "</p>");
                }
            }else{
                out.println("<p>Sesion Invalida</p>");
            }
        %>
    </body>
</html>
