/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.ClassRoom;
import at.grueneis.timetable.domain.QClassRoom;
import com.mysema.query.jpa.impl.JPAQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class WhenUsingQueryDslTest extends AbstractJUnit4SpringContextTests {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ClassRoomRepository classRoomRepository;

    @Before
    public void setup() {
        classRoomRepository.deleteAll();
    }

    @Test
    public void testFindByName() {
        // given
        classRoomRepository.save(new ClassRoom("C5.08", "C", "5"));
        classRoomRepository.save(new ClassRoom("B5.08", "B", "5"));
        classRoomRepository.save(new ClassRoom("A5.08", "A", "5"));

        // when
        JPAQuery query = new JPAQuery(entityManager);
        QClassRoom classRoom = QClassRoom.classRoom;
        query.from(classRoom).
                where(classRoom.building.eq("B")).
                orderBy(classRoom.name.asc());

        ClassRoom result = query.singleResult(classRoom);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals("B5.08", result.getName());
    }
}
