/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.service;

import at.grueneis.timetable.domain.Teacher;
import at.grueneis.timetable.repository.TeacherRepository;
import at.grueneis.timetable.repository.TeachingUnitRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * All uses cases for the timetable management.
 */
@Service
public class TimetableManagementService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeachingUnitRepository teachingUnitRepository;

    public void createNewTeacher(String shortName, String name) {
        // start transaction
        // write audit log
        Teacher teacher = new Teacher(shortName, name, new Date());
        teacherRepository.save(teacher);
        // end (commit) transaction
    }
}
