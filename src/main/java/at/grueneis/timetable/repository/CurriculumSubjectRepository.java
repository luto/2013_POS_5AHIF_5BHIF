/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repository;

import at.grueneis.timetable.domain.CurriculumSubject;
import org.springframework.data.repository.CrudRepository;

public interface CurriculumSubjectRepository extends CrudRepository<CurriculumSubject, Long> {}
