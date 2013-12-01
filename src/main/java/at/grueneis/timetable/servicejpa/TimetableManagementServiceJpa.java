/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.servicejpa;

import at.grueneis.timetable.domain.Teacher;
import at.grueneis.timetable.repositoryjpa.TeacherJpaRepository;
import at.grueneis.timetable.repositoryjpa.TeachingUnitJpaRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * All uses cases for the timetable management.
 */
@Service
public class TimetableManagementServiceJpa implements ServiceJpa {

    @Autowired
    private TeacherJpaRepository teacherJpaRepository;

    @Autowired
    private TeachingUnitJpaRepository teachingUnitJpaRepository;

    public void createNewTeacher(String name) {
        // start transaction
        // write audit log
        Teacher teacher = new Teacher(name, new Date());
        teacherJpaRepository.persist(teacher);
        // end (commit) transaction
    }

    public void setTeacherJpaRepository(TeacherJpaRepository teacherJpaRepository) {
        this.teacherJpaRepository = teacherJpaRepository;
    }

    public void setTeachingUnitJpaRepository(TeachingUnitJpaRepository teachingUnitJpaRepository) {
        this.teachingUnitJpaRepository = teachingUnitJpaRepository;
    }
}
