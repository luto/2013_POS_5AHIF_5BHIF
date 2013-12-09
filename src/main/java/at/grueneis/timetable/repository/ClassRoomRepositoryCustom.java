/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.ClassRoom;
import java.util.List;

/**
 *
 */
public interface ClassRoomRepositoryCustom {

    List<ClassRoom> findWithQueryDsl(String building);

    List<ClassRoom> findWithJqlQuery(String building);

    List<ClassRoom> findWithCriteriaApi(String building);
}
