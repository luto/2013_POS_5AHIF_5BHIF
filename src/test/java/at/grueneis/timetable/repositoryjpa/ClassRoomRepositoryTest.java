/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repositoryjpa;

import at.grueneis.timetable.domain.ClassRoom;
import org.junit.Assert;
import org.junit.Test;

public class ClassRoomRepositoryTest extends AbstractJpaRepositoryTest {
    @Test
    public void verifyFindByUnknownId() {
        ClassRoomRepository classRoomRepository = new ClassRoomRepository(entityManager);

        ClassRoom classRoom = classRoomRepository.findById(1l);

        Assert.assertNull(classRoom);
    }

    @Test
    public void verifyFindById() {
        ClassRoomRepository classRoomRepository = new ClassRoomRepository(entityManager);

        ClassRoom classRoom = new ClassRoom("C5.08", "C", "5");
        classRoomRepository.persist(classRoom);

        ClassRoom classRoom2 = classRoomRepository.findById(classRoom.getId());

        Assert.assertNotNull(classRoom2);
        Assert.assertEquals(classRoom, classRoom2);
    }
}
