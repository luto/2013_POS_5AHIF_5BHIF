/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
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
