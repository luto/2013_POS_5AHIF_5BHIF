package at.grueneis.stundenplan.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.grueneis.stundenplan.domain.Teacher;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;

public class TeacherRepositoryTest {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private TeacherRepository teacherRepository;

	@Before
	public void setup() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("spengergassePU");
		entityManager = entityManagerFactory.createEntityManager();
		teacherRepository = new TeacherRepository(entityManager);
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
	public void findAllWithoutTeachers() {
		// expect
		assertThat(teacherRepository.findAll().isEmpty(),
				is(equalTo(Boolean.TRUE)));
	}

	@Test
	public void findByIdWithoutTeachers() {
		// expect
		assertThat(teacherRepository.findById(0l), is(nullValue()));
	}

	@Test
	public void persistAndFindTeacher() {
		Teacher teacher = new Teacher("Grueneis");

		teacherRepository.persist(teacher);
		assertThat(teacher.getId(), is(notNullValue()));
		Long newId = teacher.getId();

		logger.info("Created teacher with id: {} - teacher: {}", newId, teacher);

		Teacher teacherByFind = teacherRepository.findById(newId);
		assertThat(teacherByFind, equalTo(teacher));
	}
}
