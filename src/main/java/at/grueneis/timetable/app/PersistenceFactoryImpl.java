/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.app;

import at.grueneis.timetable.repositoryjpa.ClassRoomJpaRepository;
import at.grueneis.timetable.repositoryjpa.CurriculumJpaRepository;
import at.grueneis.timetable.repositoryjpa.CurriculumSubjectJpaRepository;
import at.grueneis.timetable.repositoryjpa.JpaRepository;
import at.grueneis.timetable.repositoryjpa.PersistenceFactory;
import at.grueneis.timetable.repositoryjpa.SchoolClassJpaRepository;
import at.grueneis.timetable.repositoryjpa.SubjectJpaRepository;
import at.grueneis.timetable.repositoryjpa.TeacherJpaRepository;
import at.grueneis.timetable.repositoryjpa.TeachingUnitJpaRepository;
import java.util.HashMap;
import javax.persistence.EntityManager;

/**
 * The factory for all repositories...
 */
public class PersistenceFactoryImpl implements PersistenceFactory {

    private final HashMap<Class<?>, JpaRepository> repositories = new HashMap<>();

    public PersistenceFactoryImpl(EntityManager entityManager) {
        ClassRoomJpaRepository classRoomJpaRepository = new ClassRoomJpaRepository();
        classRoomJpaRepository.setEntityManager(entityManager);
        repositories.put(ClassRoomJpaRepository.class, classRoomJpaRepository);

        CurriculumJpaRepository curriculumJpaRepository = new CurriculumJpaRepository();
        curriculumJpaRepository.setEntityManager(entityManager);
        repositories.put(CurriculumJpaRepository.class, curriculumJpaRepository);

        CurriculumSubjectJpaRepository curriculumSubjectJpaRepository = new CurriculumSubjectJpaRepository();
        curriculumSubjectJpaRepository.setEntityManager(entityManager);
        repositories.put(CurriculumSubjectJpaRepository.class, curriculumSubjectJpaRepository);

        SchoolClassJpaRepository schoolClassJpaRepository = new SchoolClassJpaRepository();
        schoolClassJpaRepository.setEntityManager(entityManager);
        repositories.put(SchoolClassJpaRepository.class, schoolClassJpaRepository);

        SubjectJpaRepository subjectJpaRepository = new SubjectJpaRepository();
        subjectJpaRepository.setEntityManager(entityManager);
        repositories.put(SubjectJpaRepository.class, subjectJpaRepository);

        TeacherJpaRepository teacherJpaRepository = new TeacherJpaRepository();
        teacherJpaRepository.setEntityManager(entityManager);
        repositories.put(TeacherJpaRepository.class, teacherJpaRepository);

        TeachingUnitJpaRepository teachingUnitJpaRepository = new TeachingUnitJpaRepository();
        teachingUnitJpaRepository.setEntityManager(entityManager);
        repositories.put(TeachingUnitJpaRepository.class, teachingUnitJpaRepository);
    }

    @Override
    public ClassRoomJpaRepository classRoomRepository() {
        return (ClassRoomJpaRepository)repositories.get(ClassRoomJpaRepository.class);
    }

    @Override
    public CurriculumJpaRepository curriculumRepository() {
        return (CurriculumJpaRepository)repositories.get(CurriculumJpaRepository.class);
    }

    @Override
    public CurriculumSubjectJpaRepository curriculumSubjectRepository() {
        return (CurriculumSubjectJpaRepository)repositories.get(CurriculumSubjectJpaRepository.class);
    }

    @Override
    public SchoolClassJpaRepository schoolClassRepository() {
        return (SchoolClassJpaRepository)repositories.get(SchoolClassJpaRepository.class);
    }

    @Override
    public SubjectJpaRepository subjectRepository() {
        return (SubjectJpaRepository)repositories.get(SubjectJpaRepository.class);
    }

    @Override
    public TeacherJpaRepository teacherRepository() {
        return (TeacherJpaRepository)repositories.get(TeacherJpaRepository.class);
    }

    @Override
    public TeachingUnitJpaRepository teachingUnitRepository() {
        return (TeachingUnitJpaRepository)repositories.get(TeachingUnitJpaRepository.class);
    }
}
