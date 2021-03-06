/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
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
