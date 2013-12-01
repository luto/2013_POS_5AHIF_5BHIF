/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.servicejpa;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(classes = ServiceTestConfiguration.class)
public class TimetableManagementServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    TimetableManagementServiceJpa timetableManagementService;

    @Test
    public void aTest() {
        Assert.assertNotNull(timetableManagementService);
    }
}
