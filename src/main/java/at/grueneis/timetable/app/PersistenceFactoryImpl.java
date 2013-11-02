package at.grueneis.timetable.app;

import at.grueneis.timetable.repository.JpaRepository;
import at.grueneis.timetable.repository.ClassRoomRepository;
import at.grueneis.timetable.repository.CurriculumRepository;
import at.grueneis.timetable.repository.CurriculumSubjectRepository;
import at.grueneis.timetable.repository.PersistenceFactory;
import at.grueneis.timetable.repository.SchoolClassRepository;
import at.grueneis.timetable.repository.SubjectRepository;
import at.grueneis.timetable.repository.TeacherRepository;
import at.grueneis.timetable.repository.TeachingUnitRepository;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceFactoryImpl implements PersistenceFactory {

    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    private final HashMap<Class<?>, JpaRepository> repositories = new HashMap<>();

    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("spengergassePU");
        entityManager = entityManagerFactory.createEntityManager();

        repositories.put(ClassRoomRepository.class, new ClassRoomRepository(entityManager));
        repositories.put(CurriculumRepository.class, new CurriculumRepository(entityManager));
        repositories.put(CurriculumSubjectRepository.class, new CurriculumSubjectRepository(entityManager));
        repositories.put(SchoolClassRepository.class, new SchoolClassRepository(entityManager));
        repositories.put(SubjectRepository.class, new SubjectRepository(entityManager));
        repositories.put(TeacherRepository.class, new TeacherRepository(entityManager));
        repositories.put(TeachingUnitRepository.class, new TeachingUnitRepository(entityManager));
    }

    public void teardown() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Override
    public ClassRoomRepository classRoomRepository() {
        return (ClassRoomRepository)repositories.get(ClassRoomRepository.class);
    }

    @Override
    public CurriculumRepository curriculumRepository() {
        return (CurriculumRepository)repositories.get(CurriculumRepository.class);
    }

    @Override
    public CurriculumSubjectRepository curriculumSubjectRepository() {
        return (CurriculumSubjectRepository)repositories.get(CurriculumSubjectRepository.class);
    }

    @Override
    public SchoolClassRepository schoolClassRepository() {
        return (SchoolClassRepository)repositories.get(SchoolClassRepository.class);
    }

    @Override
    public SubjectRepository subjectRepository() {
        return (SubjectRepository)repositories.get(SubjectRepository.class);
    }

    @Override
    public TeacherRepository teacherRepository() {
        return (TeacherRepository)repositories.get(TeacherRepository.class);
    }

    @Override
    public TeachingUnitRepository teachingUnitRepository() {
        return (TeachingUnitRepository)repositories.get(TeachingUnitRepository.class);
    }
}
