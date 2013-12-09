/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repositoryjpa;

import java.util.Date;

import org.junit.Test;

import at.grueneis.timetable.domain.Teacher;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;

public class TeacherJpaRepositoryTest extends AbstractJpaRepositoryTest {
	@Test
	public void findAllWithoutTeachers() {
        TeacherJpaRepository teacherJpaRepository = new TeacherJpaRepository();
        teacherJpaRepository.setEntityManager(entityManager);

		// expect
		assertThat(teacherJpaRepository.findAll().isEmpty(),
				is(equalTo(Boolean.TRUE)));
	}

	@Test
	public void findByIdWithoutTeachers() {
        TeacherJpaRepository teacherJpaRepository = new TeacherJpaRepository();
        teacherJpaRepository.setEntityManager(entityManager);

		// expect
		assertThat(teacherJpaRepository.findById(0l), is(nullValue()));
	}

	@Test
	public void persistAndFindTeacher() {
        TeacherJpaRepository teacherJpaRepository = new TeacherJpaRepository();
        teacherJpaRepository.setEntityManager(entityManager);

		Teacher teacher = new Teacher("GRJ", "Grueneis", new Date());

		teacherJpaRepository.persist(teacher);
		assertThat(teacher.getId(), is(notNullValue()));
		Long newId = teacher.getId();

		logger.info("Created teacher with id: {} - teacher: {}", newId, teacher);

		Teacher teacherByFind = teacherJpaRepository.findById(newId);
		assertThat(teacherByFind, equalTo(teacher));
	}
}
