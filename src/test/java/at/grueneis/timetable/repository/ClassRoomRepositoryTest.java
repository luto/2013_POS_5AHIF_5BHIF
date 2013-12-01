/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.ClassRoom;
import java.util.List;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ClassRoomRepositoryTest {

    @Test
    public void testMe() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(RepositoryTestConfiguration.class);

        ClassRoomRepository classRoomRepository = context.getBean(ClassRoomRepository.class);
        classRoomRepository.save(new ClassRoom("C5.08", "C", "5"));

        List<ClassRoom> byName = classRoomRepository.findByName("C5.08");
    }
}
