/**
 * 
 */
package componentes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Usuario;

/**
 * @author HP
 *
 */
public class UsuarioComponente {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("webservice");
    EntityManager em = emf.createEntityManager();
    
//    private int cons = em.createQuery("SELECT u FROM Usuario u").getResultList().size();
    
    @SuppressWarnings("unchecked")
	public Usuario crearAutor(Usuario usuario){
    	List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();
    	BigDecimal cons;	
    	if(!usuarios.isEmpty())
    		cons = usuarios.get(usuarios.size()-1).getIdusuario();
    	else
    		cons = new BigDecimal(0);
    	em.getTransaction().begin();
    	usuario.setIdusuario(cons.add(new BigDecimal(1)));
    	usuario.setTipo("autor");
    	em.persist(usuario);
    	em.getTransaction().commit();
    	return usuario;
    }
    
    @SuppressWarnings("unchecked")
	public Usuario crearRevisor(Usuario usuario){
    	List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();
    	BigDecimal cons = usuarios.get(usuarios.size()-1).getIdusuario();
    	em.getTransaction().begin();
    	usuario.setIdusuario(cons.add(new BigDecimal(1)));
    	usuario.setTipo("revisor");
    	em.persist(usuario);
    	em.getTransaction().commit();
    	return usuario;
    }
    
    public List<Usuario> usuarioTipo(String tipo){
    	return em.createNamedQuery("Usuario.findByTipo").setParameter("tipo", tipo).getResultList();
    }

}
