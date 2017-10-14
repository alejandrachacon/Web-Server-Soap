/**
 * 
 */
package componentes;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Usuario;

/**
 * @author HP
 *
 */
public class AutenticacionComponente {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("webservice");
    EntityManager em = emf.createEntityManager();
    
    public Usuario autenticacion(String correo,String pass){
    	Query q = em.createNamedQuery("Usuario.autenticacion");
    	q.setParameter("correo", correo);
    	q.setParameter("contrasena", pass);
    	return (Usuario)q.getSingleResult();

    }

}
