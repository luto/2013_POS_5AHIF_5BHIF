package at.grueneis.stundenplan.service;

import at.grueneis.stundenplan.domain.Teacher;
import at.grueneis.stundenplan.repository.PersistenceFactory;
import at.grueneis.stundenplan.repository.TeacherRepository;

public class TeacherManagementService {
	private PersistenceFactory persistenceFactory;

	public void createNewTeacher(String name) {
		// start transaction
		TeacherRepository teacherRepository = persistenceFactory
				.teacherRepository();
		Teacher teacher = new Teacher("Grueneis");
		teacherRepository.persist(teacher);
		// end (commit) transaction
	}
}
