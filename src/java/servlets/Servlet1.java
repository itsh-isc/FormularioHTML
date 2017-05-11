package servlets;

/**
 * 	Servlet/Controlador para manejo de
 *      Ejemplo
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    01/Abr/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*Asocia los campos recibidos en los parametros a variables*/
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String []tecnologias=request.getParameterValues("tecnologia");
            String genero = request.getParameter("genero");
            String ocupacion = request.getParameter("ocupacion");
            String []musicas=request.getParameterValues("musica");
            String comentarios=request.getParameter("comentarios");

            /*Construye el codigo HTML*/
            out.println("<html>");
            out.println("   <head>");
            out.println("       <title>Servlet Servlet1</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Los parametros procesados son:</h1>");
            out.println("       <table border='1'>");
            out.println("           <tr>");
            out.println("               <td>");
            out.println("                   Usuario");
            out.println("               </td>");
            out.println("               <td>");
            out.println("                   "+usuario);
            out.println("               </td>");
            out.println("           </tr>");
            out.println("           <tr>");
            out.println("               <td>");
            out.println("                   Password");
            out.println("               </td>");
            out.println("               <td>");
            out.println("                   "+password);
            out.println("               </td>");
            out.println("           </tr>");
            out.println("           <tr>");
            out.println("               <td>");
            out.println("                   Tecnolog&iacute;as");
            out.println("               </td>");
            out.println("               <td>");
            for(String tecnologia:tecnologias){
                out.println("                   "+tecnologia+" ");
            }
            out.println("               </td>");
            out.println("           </tr>");
            out.println("           <tr>");
            out.println("               <td>");
            out.println("                   G&eacute;nero");
            out.println("               </td>");
            out.println("               <td>");
            out.println("                   "+genero);
            out.println("               </td>");
            out.println("           </tr>");
            out.println("           <tr>");
            out.println("               <td>");
            out.println("                   Ocupaci&oacute;n");
            out.println("               </td>");
            out.println("               <td>");
            out.println("                   "+ocupacion);
            out.println("               </td>");
            out.println("           </tr>");
            out.println("           <tr>");
            out.println("               <td>");
            out.println("                   M&uacute;sica Favorita");
            out.println("               </td>");
            out.println("               <td>");
            for(String musica:musicas)
                out.println("                   "+musica);
            out.println("               </td>");
            out.println("           </tr>");
            out.println("           <tr>");
            out.println("               <td>");
            out.println("                   Comentarios");
            out.println("               </td>");
            out.println("               <td>");
            out.println("                   "+comentarios);
            out.println("               </td>");
            out.println("           </tr>");
            out.println("       </table>");
            out.println("   </body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
