/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.Subject;
import java.util.List;
import javax.persistence.EntityManager;

public class SubjectRepository extends AbstractJpaRepository<Subject> {

    public SubjectRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Subject> findAll() {
        return entityManager().createQuery("SELECT t FROM Subject t", Subject.class).getResultList();
    }

    @Override
    public Subject findById(Long id) {
        return entityManager().find(Subject.class, id);
    }
}
