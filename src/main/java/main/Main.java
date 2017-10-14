/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entities.Articulo;
import entities.Evento;
import entities.Submision;
import entities.Usuario;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.xml.ws.Endpoint;

import org.eclipse.persistence.jpa.jpql.parser.SubExpression;

import api.ApiAuth;
import api.ApiSubmision;
import api.ApiUsuarios;
import componentes.AutenticacionComponente;
import componentes.SubmisionComponente;
import componentes.UsuarioComponente;

/**
 *
 * @author HP
 */
public class Main {
	
	
	
	public void something(){
		
	}
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("webservice");
        EntityManager em = emf.createEntityManager();
       
        AutenticacionComponente a = new AutenticacionComponente();
        UsuarioComponente usu = new UsuarioComponente();
        SubmisionComponente sb = new SubmisionComponente();
//        Usuario u = new Usuario();
//	      u.setCorreo("Correolokkkk");
//	      u.setContrasena("Contrasenalok");
//	      u.setNombres("nombreslokkkkk");
//	      u.setFechanacimiento(new Date());
//	      u.setApellidos("apellidoslokkkkk");
//	      usu.crearAutor(u);
//        Submision s = new Submision();
//        Evento e = new Evento();
//        em.getTransaction().begin();
//        e.setIdevento(new BigDecimal(1));
//        e.setFechainicio(new Date());
//        e.setFechafin(new Date());
//        e.setTema("Web services");
//        em.persist(e);
//        em.getTransaction().commit();
        
//        Usuario us = a.autenticacion("Correolokkkk", "Contrasenalok");
//        Articulo ar = new Articulo();
//        ar.setPalabrasclave("palabras");
//        ar.setResumen("Resumen");
//        ar.setTitulo("titulo");
//        sb.crearArticulo(ar, new BigDecimal(1));
//        Articulo art = em.find(Articulo.class, new BigDecimal(1));
//        em.getTransaction().begin();
//        s.setArticuloIdarticulo2(art);
//        s.setIdsubmision(new BigDecimal(0));
//        s.setEstado("Pendiente");
//        s.setFechasubida(new Date());
//        s.setEventoIdevento(em.find(Evento.class, new BigDecimal(1)));
//        s.setUsuarioIdusuario(em.find(Usuario.class, new BigDecimal(1)));
//        em.persist(s);
//        em.getTransaction().commit();
//        Articulo ar = new Articulo();
//      ar.setPalabrasclave("palabras");
//      ar.setResumen("Resumen");
//      ar.setTitulo("titulo");
//      sb.crearArticulo(ar, new BigDecimal(1));
//      sb.crearSubmision(new BigDecimal(2), new BigDecimal(1));

//        	System.out.println(sb.calcularCalificacion(new BigDecimal(1)));
//        Usuario us = em.find(Usuario.class, new BigDecimal(0));
//        System.out.println(us.getArticuloList().get(0).getTitulo());
//        em.flush();
    	
//        System.out.println(sb.revisionesSubmision(new BigDecimal(1)).size());
    	Endpoint.publish("http://localhost:9990/ws/javearticulos/auth", new ApiAuth());
    	Endpoint.publish("http://localhost:9990/ws/javearticulos/usuario", new ApiUsuarios());
    	Endpoint.publish("http://localhost:9990/ws/javearticulos/submision", new ApiSubmision());
    }
    
}
