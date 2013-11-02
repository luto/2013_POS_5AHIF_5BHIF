package at.grueneis.timetable.repository;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.grueneis.timetable.domain.Teacher;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;

public class TeacherRepositoryTest extends AbstractJpaRepositoryTest {
	@Test
	public void findAllWithoutTeachers() {
        TeacherRepository teacherRepository = new TeacherRepository(entityManager);

		// expect
		assertThat(teacherRepository.findAll().isEmpty(),
				is(equalTo(Boolean.TRUE)));
	}

	@Test
	public void findByIdWithoutTeachers() {
        TeacherRepository teacherRepository = new TeacherRepository(entityManager);

		// expect
		assertThat(teacherRepository.findById(0l), is(nullValue()));
	}

	@Test
	public void persistAndFindTeacher() {
        TeacherRepository teacherRepository = new TeacherRepository(entityManager);

		Teacher teacher = new Teacher("Grueneis", new Date());

		teacherRepository.persist(teacher);
		assertThat(teacher.getId(), is(notNullValue()));
		Long newId = teacher.getId();

		logger.info("Created teacher with id: {} - teacher: {}", newId, teacher);

		Teacher teacherByFind = teacherRepository.findById(newId);
		assertThat(teacherByFind, equalTo(teacher));
	}
}
