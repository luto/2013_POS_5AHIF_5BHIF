/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.ClassRoom;
import org.junit.Assert;
import org.junit.Test;

public class ClassRoomRepositoryTest extends AbstractJpaRepositoryTest {
    @Test
    public void verifyFindByUnknownId() {
        ClassRoomJpaRepository classRoomJpaRepository = new ClassRoomJpaRepository();
        classRoomJpaRepository.setEntityManager(entityManager);

        ClassRoom classRoom = classRoomJpaRepository.findById(1l);

        Assert.assertNull(classRoom);
    }

    @Test
    public void verifyFindById() {
        ClassRoomJpaRepository classRoomJpaRepository = new ClassRoomJpaRepository();
        classRoomJpaRepository.setEntityManager(entityManager);

        ClassRoom classRoom = new ClassRoom("C5.08", "C", "5");
        classRoomJpaRepository.persist(classRoom);

        ClassRoom classRoom2 = classRoomJpaRepository.findById(classRoom.getId());

        Assert.assertNotNull(classRoom2);
        Assert.assertEquals(classRoom, classRoom2);
    }
}
