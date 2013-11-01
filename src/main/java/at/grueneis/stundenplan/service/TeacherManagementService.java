package at.grueneis.stundenplan.service;

import at.grueneis.stundenplan.domain.Teacher;
import at.grueneis.stundenplan.repository.TeacherRepository;
import java.util.Date;

public class TeacherManagementService {
	private final TeacherRepository teacherRepository;

	public TeacherManagementService(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	public void createNewTeacher(String name) {
		// start transaction
		// write audit log
		Teacher teacher = new Teacher(name, new Date());
		teacherRepository.persist(teacher);
		// end (commit) transaction
	}
}
