package at.grueneis.timetable.app;

import at.grueneis.timetable.repository.PersistenceFactory;
import at.grueneis.timetable.service.ServiceFactory;
import at.grueneis.timetable.service.TimetableManagementService;

public class ServiceFactoryImpl implements ServiceFactory {

    private PersistenceFactory persistenceFactory;

    public ServiceFactoryImpl(PersistenceFactory persistenceFactory) {
        this.persistenceFactory = persistenceFactory;
    }

    @Override
    public TimetableManagementService timetableManagementService() {
        return new TimetableManagementService(persistenceFactory.teacherRepository());
    }

}
