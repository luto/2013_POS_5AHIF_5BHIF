package at.grueneis.stundenplan.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.grueneis.stundenplan.domain.Teacher;

public class TeacherRepository implements AnyRepository {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final EntityManager entityManager;

	public TeacherRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Teacher> findAll() {
		return entityManager.createQuery("SELECT t FROM Teacher t",
				Teacher.class).getResultList();
	}

	public Teacher findById(Long id) {
		return entityManager.find(Teacher.class, id);
	}

	public void persist(Teacher teacher) {
		entityManager.persist(teacher);
	}
}
