package at.grueneis.stundenplan.repository;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceFactoryImpl implements PersistenceFactory {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private final HashMap<Class<?>, AnyRepository> repositories = new HashMap<>();

	public void setup() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("spengergassePU");
		entityManager = entityManagerFactory.createEntityManager();

		repositories.put(TeacherRepository.class, new TeacherRepository(
				entityManager));
	}

	public void teardown() {
		if (entityManager != null)
			entityManager.close();
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}

	@Override
	public TeacherRepository teacherRepository() {
		return (TeacherRepository) repositories.get(TeacherRepository.class);
	}
}
