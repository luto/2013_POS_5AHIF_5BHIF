package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherJpaRepository extends AbstractJpaRepository<Teacher> {

    public List<Teacher> findAll() {
        return entityManager().createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    public Teacher findById(Long id) {
        return entityManager().find(Teacher.class, id);
    }
}
