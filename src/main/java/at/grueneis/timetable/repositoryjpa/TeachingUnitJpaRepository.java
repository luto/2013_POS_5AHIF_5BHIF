/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.TeachingUnit;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class TeachingUnitJpaRepository extends AbstractJpaRepository<TeachingUnit> {

    @Override
    public List<TeachingUnit> findAll() {
        return entityManager().createQuery("SELECT t FROM TeachingUnit t", TeachingUnit.class).getResultList();
    }

    @Override
    public TeachingUnit findById(Long id) {
        return entityManager().find(TeachingUnit.class, id);
    }
}
