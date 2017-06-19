package Utils;


import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Cuidador;


public class CuidadorJPAManager {
	
	private static EntityManagerFactory emf;
	
	public CuidadorJPAManager(){
		try {
			emf = Persistence.createEntityManagerFactory("CampJPA");
		} catch (Throwable ex) {
			System.err.println("Failed to create EntityManagerFactory object. "+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}	
		/* Method to READ all cuidadors */
		public void listCuidadors() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<Cuidador> result = em.createQuery("from cuidador", Cuidador.class)
					.getResultList();
			for (Cuidador a : result) {
				System.out.println(a.toString());
			}
			em.getTransaction().commit();
			em.close();	
		}
		/* Method to CREATE an cuidadors in the database */
		public void addCuidador(Cuidador ac) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(ac);
			em.getTransaction().commit();
			em.close();
		}
		/* Methods to UPDATE cuidadors */
		public void updateCuidadorNom(String id, String nom) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Cuidador ac = (Cuidador) em.find(Cuidador.class, id);
			ac.setName(nom);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}	
		public void updateCuidadorTlf(String id, String tlf) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Cuidador ac = (Cuidador) em.find(Cuidador.class, id);
			ac.setTlf(tlf);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}	
		public void updateCuidadorAdress(String id, String add) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Cuidador ac = (Cuidador) em.find(Cuidador.class, id);
			ac.setDireccio(add);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}		
		public void updateCuidadorMail(String id, String mail) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Cuidador ac = (Cuidador) em.find(Cuidador.class, id);
			ac.setMail(mail);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}		
		/* Method to DELETE an cuidadors from the records */
		public void deleteCuidador(String id) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Cuidador ac = (Cuidador) em.find(Cuidador.class, id);
			em.remove(ac);
			em.getTransaction().commit();
			em.close();
		}
}