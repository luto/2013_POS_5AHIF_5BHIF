/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.SchoolClass;
import java.util.List;
import javax.persistence.EntityManager;

public class SchoolClassRepository extends AbstractJpaRepository<SchoolClass> {

    public SchoolClassRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public List<SchoolClass> findAll() {
        return entityManager().createQuery("SELECT sc FROM SchoolClass sc", SchoolClass.class).getResultList();
    }

    public SchoolClass findById(Long id) {
        return entityManager().find(SchoolClass.class, id);
    }
}
