/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repository;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 */
public class AbstractRepositoryTest {

    @BeforeClass
    public static void beforeClass() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(RepositoryTestConfiguration.class);
    }
}
