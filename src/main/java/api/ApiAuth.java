package api;


import javax.jws.WebMethod;
import javax.jws.WebService;

import componentes.AutenticacionComponente;
import entities.Usuario;

@WebService
public class ApiAuth {
	
	private AutenticacionComponente auth = new AutenticacionComponente();
	
	@WebMethod
	public Usuario autenticarse(String correo,String pass){
		return auth.autenticacion(correo, pass);
	}

}
