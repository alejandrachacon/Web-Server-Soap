/**
 * 
 */
package api;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import componentes.SubmisionComponente;
import entities.Articulo;
import entities.Revision;
import entities.Submision;

/**
 * @author HP
 *
 */
@WebService
public class ApiSubmision {
	

	private SubmisionComponente subComponent = new SubmisionComponente();
	
	@WebMethod
	public Articulo crearArticulo(Articulo ar,BigDecimal idusuario){
		return subComponent.crearArticulo(ar, idusuario);
	}
	
	@WebMethod
	public Submision crearSubmision(BigDecimal articuloId,BigDecimal eventoId){
		return subComponent.crearSubmision(articuloId, eventoId);
	}
	
	@WebMethod
	public Revision agregarRevisor(BigDecimal idSubmision,BigDecimal idRevisor){
		return subComponent.agregarRevisor(idSubmision, idRevisor);
	}
	
	@WebMethod
	public Revision calificarSubmision(BigDecimal idRevision,Integer calificacion,String comentarios){
		return subComponent.calificarSubmision(idRevision, calificacion, comentarios);
	}
	
	@WebMethod
	public Integer calcularCalificacion(BigDecimal idSubmision){
		return subComponent.calcularCalificacion(idSubmision);
	}
	
	@WebMethod
	public List<Articulo> articuloUsuario(BigDecimal idUsuario){
		return subComponent.articuloUsuario(idUsuario);
	}
	
	@WebMethod
	public List<Submision> submisionUsuario(BigDecimal idUsuario){
		return subComponent.submisionUsuario(idUsuario);
	}
	@WebMethod
	public List<Revision> revisionesSubmision(BigDecimal idSub){
		return subComponent.revisionesSubmision(idSub);
	}
	
	

}
