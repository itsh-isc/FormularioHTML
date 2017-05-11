package util;

/**
 * 	Clase para manejo de logs
 *      (http://host:port/management/domain/view-log)
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    25/Mar/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

public class Log {
    // <editor-fold defaultstate="collapsed" desc="Static Methods">
    
    /**
     * Log simple text message.  
     * @param text  The <code>String</code> to be logged.
     */
    public static void m(String text){
        System.out.println(text);
    }
    
    /**
     * Log exception stack trace.  
     * @param exception  The <code>Exception</code> to be logged.
     */
    public static void e(Exception exception){
        m("");
        exception.printStackTrace();
    }
    // </editor-fold>
}
