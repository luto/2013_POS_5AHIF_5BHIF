package at.grueneis.timetable.repository;

public interface PersistenceFactory {

    ClassRoomRepository classRoomRepository();

    CurriculumRepository curriculumRepository();

    CurriculumSubjectRepository curriculumSubjectRepository();

    SchoolClassRepository schoolClassRepository();

    SubjectRepository subjectRepository();

    TeacherRepository teacherRepository();

    TeachingUnitRepository teachingUnitRepository();
}