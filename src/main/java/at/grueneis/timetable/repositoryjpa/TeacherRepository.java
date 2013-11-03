package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.Teacher;
import java.util.List;
import javax.persistence.EntityManager;

public class TeacherRepository extends AbstractJpaRepository<Teacher> {

    public TeacherRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Teacher> findAll() {
        return entityManager().createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    public Teacher findById(Long id) {
        return entityManager().find(Teacher.class, id);
    }
}
