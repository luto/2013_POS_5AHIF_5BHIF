/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.ClassRoom;
import java.util.List;
import javax.persistence.EntityManager;

public class ClassRoomRepository extends AbstractJpaRepository<ClassRoom> {

    public ClassRoomRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public List<ClassRoom> findAll() {
        return entityManager().createQuery("SELECT cr FROM ClassRoom cr", ClassRoom.class).getResultList();
    }

    public ClassRoom findById(Long id) {
        return entityManager().find(ClassRoom.class, id);
    }
}
