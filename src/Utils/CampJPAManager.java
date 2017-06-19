package Utils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Camp;

public class CampJPAManager {

private static EntityManagerFactory emf;

	public CampJPAManager(){
		try {
			emf = Persistence.createEntityManagerFactory("CampJPA");
		} catch (Throwable ex) {
			System.err.println("Failed to create EntityManagerFactory object. "+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}	
		/* Method to READ all Camps */
		public void listCamps() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<Camp> result = em.createQuery("from campament", Camp.class)
					.getResultList();
			for (Camp a : result) {
				System.out.println(a.toString());
			}
			em.getTransaction().commit();
			em.close();	
		}
		/* Method to CREATE an Camps in the database */
		public void addCamp(Camp ac) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(ac);
			em.getTransaction().commit();
			em.close();
		}
		
		/* Methods to UPDATE Camps */
		public void updateCampNom(Integer id, String localitzacio) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Camp ac = (Camp) em.find(Camp.class, id);
			ac.setLocalitzacio(localitzacio);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}	
		public void updateCampDataIni(Integer id, Date data_ini) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Camp ac = (Camp) em.find(Camp.class, id);
			ac.setData_ini(data_ini);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}	
		public void updateCampDataFi(Integer id, Date data_fi) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Camp ac = (Camp) em.find(Camp.class, id);
			ac.setData_fi(data_fi);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}	
		
		/* Method to DELETE an Camps from the records */
		public void deleteCamp(Integer id) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Camp ac = (Camp) em.find(Camp.class, id);
			em.remove(ac);
			em.getTransaction().commit();
			em.close();
		}
}
