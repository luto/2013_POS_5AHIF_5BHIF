/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.Subject;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface SubjectRepository extends CrudRepository<Subject, Long> {
    Subject findByName(String name);
}
