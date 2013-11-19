/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repositoryjpa;

public interface PersistenceFactory {

    ClassRoomJpaRepository classRoomRepository();

    CurriculumJpaRepository curriculumRepository();

    CurriculumSubjectJpaRepository curriculumSubjectRepository();

    SchoolClassJpaRepository schoolClassRepository();

    SubjectJpaRepository subjectRepository();

    TeacherJpaRepository teacherRepository();

    TeachingUnitJpaRepository teachingUnitRepository();
}