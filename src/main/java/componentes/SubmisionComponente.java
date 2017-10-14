/**
 * 
 */
package componentes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Articulo;
import entities.Evento;
import entities.Revision;
import entities.Submision;
import entities.Usuario;

/**
 * @author HP
 *
 */
public class SubmisionComponente {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("webservice");
    EntityManager em = emf.createEntityManager();
	
	@SuppressWarnings("unchecked")
	public Articulo crearArticulo(Articulo ar,BigDecimal usuarioId){
		List<Articulo> articulos = em.createQuery("SELECT u FROM Articulo u").getResultList();
		BigDecimal cons ;
		if(!articulos.isEmpty())
    		cons= articulos.get(articulos.size()-1).getIdarticulo();
		else
			cons = new BigDecimal(0);
		Usuario us = em.find(Usuario.class,usuarioId);
        em.getTransaction().begin();
        ar.setIdarticulo(cons.add(new BigDecimal(1)));
        ar.setUsuarioIdusuario(us);
        em.persist(ar);
        em.getTransaction().commit();
        return ar;
	}
	
	@SuppressWarnings("unchecked")
	public Submision crearSubmision(BigDecimal articuloId,BigDecimal eventoId){
		List<Submision> submisiones = em.createQuery("SELECT u FROM Submision u").getResultList();
		BigDecimal cons ;
		if(!submisiones.isEmpty())
    		cons= submisiones.get(submisiones.size()-1).getIdsubmision();
		else
			cons = new BigDecimal(0);
		Articulo art = em.find(Articulo.class, articuloId);
		Submision sb = new Submision();
		em.getTransaction().begin();
        sb.setArticuloIdarticulo2(art);
        sb.setIdsubmision(cons.add(new BigDecimal(1)));
        sb.setFechasubida(new Date());
        sb.setEstado("Pendiente");
        sb.setEventoIdevento(em.find(Evento.class, eventoId));
        sb.setUsuarioIdusuario(em.find(Usuario.class, art.getUsuarioIdusuario().getIdusuario()));
        em.persist(sb);
        em.getTransaction().commit();
        return sb;
	}
	
	public Revision agregarRevisor(BigDecimal idSubmision,BigDecimal idRevisor){
		List<Revision> revisiones = em.createQuery("SELECT u FROM Revision u").getResultList();
		BigDecimal cons ;
		if(!revisiones.isEmpty())
    		cons= revisiones.get(revisiones.size()-1).getIdrevision();
		else
			cons = new BigDecimal(0);
		Submision sub = em.find(Submision.class, idSubmision);
		Usuario revisor = em.find(Usuario.class, idRevisor);
		em.getTransaction().begin();
		Revision revision = new Revision();
		revision.setIdrevision(cons.add(new BigDecimal(1)));
		revision.setSubmisionIdsubmision(sub);
		revision.setUsuarioIdusuario(revisor);
		revision.setCalificacion(-1);
		em.persist(revision);
		em.getTransaction().commit();
		return revision;
		
	}
	
	public Revision calificarSubmision(BigDecimal idRevision,Integer calificacion,String comentarios){
		Revision revision = em.find(Revision.class, idRevision);
		em.getTransaction().begin();
		revision.setComentarios(comentarios);
		revision.setCalificacion(calificacion);
		em.merge(revision);
		em.getTransaction().commit();
		return revision;
		
	}
	
	public Integer calcularCalificacion(BigDecimal idSubmision){
		Submision s = em.find(Submision.class, idSubmision);
		Integer b = new Integer(0);
		for (Revision r : s.getRevisionList()) {
			if(r.getCalificacion()==-1){
				return -1;
			}
			b+=r.getCalificacion();
		}
		b = b/s.getRevisionList().size();
		return b;
	}
	
	public List<Articulo> articuloUsuario(BigDecimal idUsuario){
		Usuario u = em.find(Usuario.class, idUsuario);
		return em.createQuery("select a from Articulo a where a.usuarioIdusuario = :usuario").setParameter("usuario", u).getResultList();
		
	}
	
	public List<Submision> submisionUsuario(BigDecimal idUsuario){
		Usuario u = em.find(Usuario.class, idUsuario);
		return em.createQuery("select a from Submision a where a.usuarioIdusuario = :usuario").setParameter("usuario", u).getResultList();
		
	}
	
	public List<Revision> revisionesSubmision(BigDecimal idSub){
		Submision s = em.find(Submision.class, idSub);
		return em.createQuery("select a from Revision a where a.submisionIdsubmision = :sub").setParameter("sub", s).getResultList();
		
	}
	
	

}
