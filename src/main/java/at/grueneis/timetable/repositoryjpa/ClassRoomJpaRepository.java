/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.ClassRoom;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ClassRoomJpaRepository extends AbstractJpaRepository<ClassRoom> {

    public List<ClassRoom> findAll() {
        return entityManager().createQuery("SELECT cr FROM ClassRoom cr", ClassRoom.class).getResultList();
    }

    public ClassRoom findById(Long id) {
        return entityManager().find(ClassRoom.class, id);
    }
}
