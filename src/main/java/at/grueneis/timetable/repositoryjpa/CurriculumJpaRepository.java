/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.Curriculum;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CurriculumJpaRepository extends AbstractJpaRepository<Curriculum> {

    public List<Curriculum> findAll() {
        return entityManager().createQuery("SELECT c FROM Curriculum c", Curriculum.class).getResultList();
    }

    public Curriculum findById(Long id) {
        return entityManager().find(Curriculum.class, id);
    }
}
