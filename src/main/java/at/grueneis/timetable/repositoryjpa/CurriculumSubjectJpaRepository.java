/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.CurriculumSubject;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CurriculumSubjectJpaRepository extends AbstractJpaRepository<CurriculumSubject> {

    public List<CurriculumSubject> findAll() {
        return entityManager().createQuery("SELECT cs FROM CurriculumSubject cs", CurriculumSubject.class)
                .getResultList();
    }

    public CurriculumSubject findById(Long id) {
        return entityManager().find(CurriculumSubject.class, id);
    }
}
