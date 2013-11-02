/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.BasePersistable;
import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractJpaRepository<T extends BasePersistable> implements JpaRepository {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EntityManager entityManager;

    public AbstractJpaRepository(EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalArgumentException("An entityManager must be specified.");
        }
        this.entityManager = entityManager;
    }

    protected EntityManager entityManager() {
        return entityManager;
    }

    public abstract List<T> findAll();

    public abstract T findById(Long id);

    public void persist(T entity) {
        entityManager.persist(entity);
    }
}
