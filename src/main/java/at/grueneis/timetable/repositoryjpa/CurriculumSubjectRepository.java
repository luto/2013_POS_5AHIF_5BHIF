/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.CurriculumSubject;
import java.util.List;
import javax.persistence.EntityManager;

public class CurriculumSubjectRepository extends AbstractJpaRepository<CurriculumSubject> {

    public CurriculumSubjectRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public List<CurriculumSubject> findAll() {
        return entityManager().createQuery("SELECT cs FROM CurriculumSubject cs", CurriculumSubject.class)
                .getResultList();
    }

    public CurriculumSubject findById(Long id) {
        return entityManager().find(CurriculumSubject.class, id);
    }
}
