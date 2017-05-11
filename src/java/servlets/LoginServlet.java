package servlets;

/**
 * 	Servlet/Controlador para manejo de
 *      Login
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    01/Abr/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

import itsh.pw.webservice.shared.model.dto.PerfilUsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Log;
import view.helpers.Pages;
import ws.WebserviceClient;

public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("validarLogin".equals(accion)) {
            this.validarLogin(request, response);
        } else if ("verPerfil".equals(accion)) {
            this.verPerfil(request, response);
        }else if ("abrirPerfil".equals(accion)) {
            this.abrirPerfil(request, response);
        }else if("logout".equals(accion)){
            this.logout(request, response);
        }else{
            //
        }
    }
    
    protected void validarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String jspResult = Pages.LoginError.getPath();
        try {
            
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            
            int resultadoLogin = loginWS(usuario, password);
            if(resultadoLogin != 0){
                request.getSession().setAttribute("idUsuario", String.valueOf(resultadoLogin));
                jspResult = Pages.LoginOk.getPath();
            }
            
        } catch(Exception e){
            Log.e(e);
        }
        
        Log.m("JSP Result: " + jspResult);
        
        response.sendRedirect(jspResult);
    }
    
    protected void abrirPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String jspResult = Pages.LoginError.getPath();
        
        try {
            
            int idUsuario = Integer.parseInt(request.getSession().getAttribute("idUsuario").toString());
            
            List<PerfilUsuarioDTO> list = this.getPerfil(idUsuario);
            if(list != null){
                if(list.size() > 0){
                    request.getSession().setAttribute("perfiles", list);
                    jspResult = Pages.Perfil.getPath();
                }
            }
        } catch(Exception e){
            Log.e(e);
        }
        
        Log.m("JSP Result: " + jspResult);
        
        response.sendRedirect(jspResult);
    }
    
    protected void verPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            int idUsuario = Integer.parseInt(request.getSession().getAttribute("idUsuario").toString());
            
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Perfil</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Context at " + request.getContextPath() + "</h1>");
            
            List<PerfilUsuarioDTO> list = this.getPerfil(idUsuario);
            if(list != null){
                if(list.size() > 0){
                    Map<String, String> fields = new LinkedHashMap<String, String>();
                    for(PerfilUsuarioDTO dto : list){
                        fields.put("Id Perfil", String.valueOf(dto.getIdPerfilUsuario()));
                        fields.put("Id Usuario", String.valueOf(dto.getIdUsuario()));
                        fields.put("Nombre", dto.getNombre());
                        fields.put("Apellido Paterno", dto.getApellidoP());
                        fields.put("Apellido Materno", dto.getApellidoM());
                        fields.put("Sexo", dto.getSexo());
                        fields.put("Mayor de Edad", String.valueOf(dto.isMayorDeEdad()));
                        
                        createTable(fields, out);
                    }                    
                }else{
                    out.println("No se encontraron registros");
                }
            }else{
                out.println("No se regresaron datos desde el Webservice");
            }
            
            out.println("</body>");
            out.println("</html>");
            
            out.close();
        } catch(Exception e){
            Log.e(e);
            response.sendRedirect(Pages.LoginError.getPath());
        }
    }
    
    private void createTable(Map<String, String> fields, PrintWriter out){
        out.println("<table border=\"1\">");
        for(Map.Entry<String, String> entry : fields.entrySet()){
            out.println("<tr>");
            out.println("<td>" + entry.getKey() + "</td>");
            out.println("<td>" + entry.getValue() + "</td>");
            out.println("</tr>");
        }
        out.println("</table><br>");
    }
    
    private int loginWS(String user, String pass){
        int result = 0;
        
        WebserviceClient ws = new WebserviceClient();
        result = ws.login(user, pass);
        
        return result;    
    }
    
    private List<PerfilUsuarioDTO> getPerfil(int idUsuario){
        List<PerfilUsuarioDTO> result = null;
        
        WebserviceClient ws = new WebserviceClient();
        result = ws.getPerfil(idUsuario);
        
        return result; 
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response){
        try{
        HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
                response.sendRedirect(Pages.Login.getPath());
            }
        }catch(Exception e){
            Log.e(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
