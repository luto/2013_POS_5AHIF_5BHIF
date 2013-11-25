/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.Curriculum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends CrudRepository<Curriculum, Long> {
    Curriculum findByName(String name);
}
