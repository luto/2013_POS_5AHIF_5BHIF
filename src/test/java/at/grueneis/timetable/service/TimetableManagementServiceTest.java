/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TimetableManagementServiceTest {

    @Test
    public void aTest() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ServiceTestConfiguration.class);

        TimetableManagementService timetableManagementService = context.getBean(TimetableManagementService.class);
        Assert.assertNotNull(timetableManagementService);
    }
}
