/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.Subject;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectJpaRepository extends AbstractJpaRepository<Subject> {

    @Override
    public List<Subject> findAll() {
        return entityManager().createQuery("SELECT t FROM Subject t", Subject.class).getResultList();
    }

    @Override
    public Subject findById(Long id) {
        return entityManager().find(Subject.class, id);
    }
}
