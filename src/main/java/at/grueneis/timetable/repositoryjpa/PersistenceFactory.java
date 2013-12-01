/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repositoryjpa;

/**
 * A factory specification to create the JPA repositories.
 */
public interface PersistenceFactory {

    ClassRoomJpaRepository classRoomJpaRepository();

    CurriculumJpaRepository curriculumJpaRepository();

    CurriculumSubjectJpaRepository curriculumSubjectJpaRepository();

    SchoolClassJpaRepository schoolClassJpaRepository();

    SubjectJpaRepository subjectJpaRepository();

    TeacherJpaRepository teacherJpaRepository();

    TeachingUnitJpaRepository teachingUnitJpaRepository();
}