/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.ClassRoom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends
        ClassRoomRepositoryCustom,
        JpaRepository<ClassRoom, Long> {

    List<ClassRoom> findByName(String name);

    List<ClassRoom> findByBuilding(String building);
}
