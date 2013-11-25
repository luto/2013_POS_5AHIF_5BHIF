/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.Teacher;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Teacher findByName(String name);
}
