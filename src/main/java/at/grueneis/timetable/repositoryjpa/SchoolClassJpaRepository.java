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
import org.springframework.stereotype.Repository;

@Repository
public class SchoolClassJpaRepository extends AbstractJpaRepository<SchoolClass> {

    public List<SchoolClass> findAll() {
        return entityManager().createQuery("SELECT sc FROM SchoolClass sc", SchoolClass.class).getResultList();
    }

    public SchoolClass findById(Long id) {
        return entityManager().find(SchoolClass.class, id);
    }
}
