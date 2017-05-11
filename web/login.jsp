<%-- 
    Document   : login
    Created on : 30/03/2017, 12:46:45 PM
    Author     : SITI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Login</title>
        <link rel="stylesheet" type="text/css" href="recursos/estilos.css">
        <script type="text/javascript" src="recursos/validaciones.js"></script>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        
        <form name="form1" action="/FormularioHTML/LoginServlet"
              method="post" onsubmit="return validarForma(this);">
            
            <input type="hidden" name="accion" value="abrirPerfil" />

            <table width="200" id="one-column-emphasis">
                <caption>Formulario Registro de Datos</caption>

                <!--Usuario-->
                <tr>
                    <td class="oce-first">Usuario:</td>
                    <td>
                    <input class="default" type="text"
                         name="usuario" value="Escribir usuario"
                         onfocus="this.select();"/>
                    </td>
                </tr>

                <!--Password-->
                <tr>
                    <td class="oce-first">Password:</td>
                    <td>
                    <input class="default" type="password"
                         name="password" onfocus="this.select();">
                    </td>
                </tr>
                
                <!--Botones-->
                <tr style="text-align:center;">
                    <td><input type="reset" value="Limpiar" class="default"></td>
                    <td><input type="submit" value="Enviar" class="default"></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
