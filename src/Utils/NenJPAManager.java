package Utils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Nen;

public class NenJPAManager {

private static EntityManagerFactory emf;
	
	public NenJPAManager(){
		try {
			emf = Persistence.createEntityManagerFactory("CampJPA");
		} catch (Throwable ex) {
			System.err.println("Failed to create EntityManagerFactory object. "+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}	
		/* Method to READ all Nens */
		public void listNens() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<Nen> result = em.createQuery("from nen", Nen.class)
					.getResultList();
			for (Nen a : result) {
				System.out.println(a.toString());
			}
			em.getTransaction().commit();
			em.close();	
		}
		/* Method to CREATE an Nens in the database */
		public void addNen(Nen ac) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(ac);
			em.getTransaction().commit();
			em.close();
		}
		
		/* Methods to UPDATE Nens */
		public void updateNenNom(Integer id, String nom) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Nen ac = (Nen) em.find(Nen.class, id);
			ac.setNom(nom);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}	
		public void updateNenDataNaix(Integer id, Date data_naix) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Nen ac = (Nen) em.find(Nen.class, id);
			ac.setData_naix(data_naix);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}	
		public void updateMenuEsp(Integer id, boolean menu_esp) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Nen ac = (Nen) em.find(Nen.class, id);
			ac.setMenu_especial(menu_esp);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}	
		
		/* Method to DELETE an Nens from the records */
		public void deleteNen(Integer id) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Nen ac = (Nen) em.find(Nen.class, id);
			em.remove(ac);
			em.getTransaction().commit();
			em.close();
		}
}