package Utils;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Activitats;

public class ActivitatsJPAManager {
	
	private static EntityManagerFactory emf;
	
	public static void main(String[] args) throws IOException {
		try {
			emf = Persistence.createEntityManagerFactory("CampJPA");
		} catch (Throwable ex) {
			System.err.println("Failed to create EntityManagerFactory object. "+ ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		ActivitatsJPAManager MA = new ActivitatsJPAManager();

		FileAccesor.loadActivitatsFile("activitats.csv");
		System.out.println("Activitats llegides des del fitxer");
		for (int i = 0; i < FileAccesor.actiList.size(); i++) {
			System.out.println(FileAccesor.actiList.get(i).toString());
			MA.addActivity(FileAccesor.actiList.get(i));
		}
		System.out.println("Activitats llegides de la base de dades");
		MA.listActivities();
		MA.deleteActivity(5);
		MA.updateActivityDesc(12, "Nueva Actividad Añadida");
		System.out.println("Activitats llegides de la base de dades després de des actualitzacions");
		MA.listActivities();
		}
		/* Method to READ all activities */
		public void listActivities() {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			List<Activitats> result = em.createQuery("from Activitats", Activitats.class)
					.getResultList();
			for (Activitats a : result) {
				System.out.println(a.toString());
			}
			em.getTransaction().commit();
			em.close();	
		}
		/* Method to CREATE an activities in the database */
		public void addActivity(Activitats ac) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(ac);
			em.getTransaction().commit();
			em.close();
		}
		/* Method to UPDATE activity */
		public void updateActivityDesc(Integer id, String desc) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Activitats ac = (Activitats) em.find(Activitats.class, id);
			ac.setDesc(desc);
			em.merge(ac);
			em.getTransaction().commit();
			em.close();
		}		
		/* Method to DELETE an activity from the records */
		public void deleteActivity(Integer id) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Activitats ac = (Activitats) em.find(Activitats.class, id);
			em.remove(ac);
			em.getTransaction().commit();
			em.close();
		}
}