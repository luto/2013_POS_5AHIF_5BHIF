/**
 * Joachim Grueneis
 * mailto:grueneis@spengergasse.at
 *
 * Copyright (C) 2013
 * All rights reserved.
 */
package at.grueneis.stundenplan.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "scheduled_lessons")
public class ScheduledLesson extends BasePersistable {

	private static final long serialVersionUID = 2373404211277359145L;

	@ManyToOne(targetEntity = Teacher.class)
	private Teacher teacher;

	@ManyToOne(targetEntity = TeachingUnit.class)
	private TeachingUnit teachingUnit;

	@ManyToOne(targetEntity = ClassRoom.class)
	private ClassRoom classRoom;
}
