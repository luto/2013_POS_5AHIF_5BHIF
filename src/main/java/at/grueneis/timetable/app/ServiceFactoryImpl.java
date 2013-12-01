/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.app;

import at.grueneis.timetable.repositoryjpa.PersistenceFactory;
import at.grueneis.timetable.service.Service;
import at.grueneis.timetable.service.ServiceFactory;
import at.grueneis.timetable.service.TimetableManagementService;
import java.util.HashMap;

/**
 * A factory to create the services...
 */
public class ServiceFactoryImpl implements ServiceFactory {

    private final HashMap<Class<?>, Service> services = new HashMap<>();

    private PersistenceFactory persistenceFactory;

    public ServiceFactoryImpl(PersistenceFactory persistenceFactory) {
        this.persistenceFactory = persistenceFactory;
    }

    @Override
    public TimetableManagementService timetableManagementService() {
        TimetableManagementService timetableManagementService = new TimetableManagementService();
        timetableManagementService.setTeacherRepository(persistenceFactory.teacherRepository());
        timetableManagementService.setTeachingUnitJpaRepository(persistenceFactory.teachingUnitRepository());
        return timetableManagementService;
    }

}
