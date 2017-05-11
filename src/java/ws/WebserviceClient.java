package ws;

/**
 * 	Clase para manejo del Webservice
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    03/Abr/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

import itsh.pw.webservice.shared.contracts.ContratoWS;
import itsh.pw.webservice.shared.contracts.ILogin;
import itsh.pw.webservice.shared.model.dto.PerfilUsuarioDTO;
import itsh.pw.webservice.shared.publish.Publishment;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import util.Log;

public class WebserviceClient {    
    public int login(String usuario, String password){
        int resultado = 0;

        ILogin contract = (ILogin)getContract("login");
        if(contract != null){
            resultado = contract.validarLogin(usuario, password);
            contract = null;
        }
        
        return resultado;
    }
    
    public List<PerfilUsuarioDTO> getPerfil(int idUsuario){
        List<PerfilUsuarioDTO> resultado = null;

        ILogin contract = (ILogin)getContract("login");
        if(contract != null){
            PerfilUsuarioDTO[] dtoArray = contract.getPerfil(idUsuario);
            contract = null;

            resultado = Arrays.asList(dtoArray);  
        }
        
        return resultado;
    }
    
    private ContratoWS getContract(String path){
        ContratoWS resultado = null;
        
        try {
            Publishment publishment = new Publishment("localhost", "8080", "WebserviceServer", "http://endpoints.webservice.pw.itsh/");
            
            URL url = new URL(publishment.getPathWsdl(path));
            
            String serviceURI = publishment.getServiceURI();
            String serviceName = publishment.getServiceName(path);

            QName qname = new QName(serviceURI, serviceName);

            Service service = Service.create(url, qname);
            resultado = service.getPort(ILogin.class);   
        } catch (Exception e) {
            Log.e(e);
        }
        
        return resultado;
    }
}
