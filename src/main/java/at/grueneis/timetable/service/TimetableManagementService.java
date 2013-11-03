package at.grueneis.timetable.service;

import at.grueneis.timetable.domain.Teacher;
import at.grueneis.timetable.repositoryjpa.TeacherRepository;
import java.util.Date;

public class TimetableManagementService {
	private final TeacherRepository teacherRepository;

	public TimetableManagementService(TeacherRepository teacherRepository) {
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
