package at.grueneis.stundenplan.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TeachingUnitTest {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@Before
	public void setup() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("spengergassePU");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}

	@After
	public void teardown() {
		if (entityManager != null)
			entityManager.getTransaction().commit();
		if (entityManager != null)
			entityManager.close();
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}

	@Test
	public void testCreateATeachingUnit() {
		Teacher teacher = new Teacher("Grüneis");
		Subject subject = new Subject("POS", 6);
		TeachingUnit teachingUnit = new TeachingUnit(subject, teacher,
				Weekday.MO, 1);
		entityManager.persist(teacher);
		entityManager.persist(subject);
		entityManager.persist(teachingUnit);
	}
}
