package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import kanban.Fiche;
import kanban.Utilisateur;

public class JpaTest {
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createFiche();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listFiches();

		manager.close();
		System.out.println(".. done");
	}

	private void createFiche() {
		int numOfFiche = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
		if (numOfFiche == 0) {
			Utilisateur Michael = new Utilisateur("Michael");
			Fiche fiche = new Fiche("Fiche 1", "15/01/2021", Michael, 60, "Rennes", "http://blabla", null);
			manager.persist(fiche);
			Utilisateur Nemo = new Utilisateur("Captain Nemo");
			Fiche fiche2 = new Fiche("Fiche 2", "15/01/2021", Nemo, 60, "Rennes", "http://blabla", null);

			manager.persist(Michael);
			manager.persist(Nemo);
			manager.persist(fiche2);
		}

	}

	private void listFiches() {
		List<Fiche> resultList = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
		System.out.println("num of fiches:" + resultList.size());
		for (Fiche next : resultList) {
			System.out.println("next fiche: " + next);
		}
	}

}
