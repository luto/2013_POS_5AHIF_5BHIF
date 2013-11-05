package at.grueneis.timetable.app;

import at.grueneis.timetable.repositoryjpa.PersistenceFactory;
import at.grueneis.timetable.service.ServiceFactory;
import at.grueneis.timetable.service.TimetableManagementService;
import java.util.HashMap;

public class ServiceFactoryImpl implements ServiceFactory {
    private PersistenceFactory persistenceFactory;

    public ServiceFactoryImpl(PersistenceFactory persistenceFactory) {
        this.persistenceFactory = persistenceFactory;
    }

    @Override
    public TimetableManagementService timetableManagementService() {
        return new TimetableManagementService();
    }

}
