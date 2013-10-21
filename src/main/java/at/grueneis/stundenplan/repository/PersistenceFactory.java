package at.grueneis.stundenplan.repository;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceFactory {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private final HashMap<Class<?>, AnyRepository> repositories = new HashMap<>();

	public void setup() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("spengergassePU");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}

	public void teardown() {
		if (entityManager != null)
			entityManager.getTransaction().commit();
		if (entityManager != null)
			entityManager.close();
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}

	public TeacherRepository teacherRepository() {
		if (!repositories.containsKey(TeacherRepository.class)) {
			repositories.put(TeacherRepository.class, new TeacherRepository(
					entityManager));
		}
		return (TeacherRepository) repositories.get(TeacherRepository.class);
	}
}
