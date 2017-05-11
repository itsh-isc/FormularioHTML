<%-- 
    Document   : LoginOk
    Created on : 30/03/2017, 01:05:09 PM
    Author     : SITI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Ok</h1>

        <p>Id Usuario: <%= session.getAttribute("idUsuario") %></p>
        
        <form name="form1" action="/FormularioHTML/LoginServlet" method="post">
            
            <input type="hidden" name="accion" value="abrirPerfil" />

            <table width="200" id="one-column-emphasis">
                
                <tr style="text-align:center;">
                    <td><input type="submit" value="Ver Perfil" class="default"></td>
                </tr>
            </table>
        </form>
        
        <form name="form2" action="/FormularioHTML/LoginServlet" method="post">
            
            <input type="hidden" name="accion" value="logout" />

            <table width="200" id="one-column-emphasis">
                
                <tr style="text-align:center;">
                    <td><input type="submit" value="Cerrar Sesion" class="default"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
