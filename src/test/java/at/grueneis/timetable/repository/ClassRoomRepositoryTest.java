/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.ClassRoom;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class ClassRoomRepositoryTest extends AbstractJUnit4SpringContextTests {

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
        List<ClassRoom> byName = classRoomRepository.findByName("C5.08");

        // then
        Assert.assertNotNull(byName);
        Assert.assertEquals(1, byName.size());
        Assert.assertNotNull(byName.get(0));
    }

    @Test
    public void testFindByBuilding() {
        // given
        classRoomRepository.save(new ClassRoom("C5.08", "C", "5"));
        classRoomRepository.save(new ClassRoom("B5.08", "B", "5"));
        classRoomRepository.save(new ClassRoom("A5.08", "A", "5"));

        // when
        List<ClassRoom> byName = classRoomRepository.findByBuilding("C");

        // then
        Assert.assertNotNull(byName);
        Assert.assertEquals(1, byName.size());
        Assert.assertNotNull(byName.get(0));
    }
}
