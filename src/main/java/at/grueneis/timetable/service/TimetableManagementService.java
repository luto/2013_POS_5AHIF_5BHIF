/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.service;

import at.grueneis.timetable.domain.Teacher;
import at.grueneis.timetable.repositoryjpa.ClassRoomJpaRepository;
import at.grueneis.timetable.repositoryjpa.TeacherJpaRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableManagementService {
    @Autowired
	private TeacherJpaRepository teacherJpaRepository;

	public void createNewTeacher(String name) {
		// start transaction
		// write audit log
		Teacher teacher = new Teacher(name, new Date());
		teacherJpaRepository.persist(teacher);
		// end (commit) transaction
	}
}
