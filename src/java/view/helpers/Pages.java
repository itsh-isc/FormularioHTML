package view.helpers;

/**
 * 	Enumeracion para encapsulamiento de las Paginas JSP/HTML
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    01/Abr/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

public enum Pages {
    Index("index.html"),
    Login("login.jsp"),
    LoginOk("pages/LoginOk.jsp"),
    LoginError("pages/LoginError.jsp"),
    Perfil("pages/Perfil.jsp");
    
    private final String CONTEXT = "/FormularioHTML/";
    private String path;
    
    private Pages(String path){
        this.path = CONTEXT + path;
    }

    public String getPath() {
        return path;
    }
}
