/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.app;

import at.grueneis.timetable.repositoryjpa.PersistenceFactory;
import at.grueneis.timetable.servicejpa.ServiceJpa;
import at.grueneis.timetable.servicejpa.ServiceJpaFactory;
import at.grueneis.timetable.servicejpa.TimetableManagementServiceJpa;
import java.util.HashMap;

/**
 * A factory to create the services...
 */
public class ServiceFactoryImpl implements ServiceJpaFactory {

    private final HashMap<Class<?>, ServiceJpa> services = new HashMap<>();

    private PersistenceFactory persistenceFactory;

    public ServiceFactoryImpl(PersistenceFactory persistenceFactory) {
        this.persistenceFactory = persistenceFactory;
    }

    @Override
    public TimetableManagementServiceJpa timetableManagementService() {
        TimetableManagementServiceJpa timetableManagementService = new TimetableManagementServiceJpa();
        timetableManagementService.setTeacherJpaRepository(persistenceFactory.teacherJpaRepository());
        timetableManagementService.setTeachingUnitJpaRepository(persistenceFactory.teachingUnitJpaRepository());
        return timetableManagementService;
    }

}
