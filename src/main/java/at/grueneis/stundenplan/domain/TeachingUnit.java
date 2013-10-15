/**
 * Joachim Grueneis
 * mailto:grueneis@spengergasse.at
 *
 * Copyright (C) 2013
 * All rights reserved.
 */
package at.grueneis.stundenplan.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teaching_units")
public class TeachingUnit extends BasePersistable {

	private static final long serialVersionUID = -5889761023218222369L;

	protected static final String ATTR_TEACHER = "teacher";

	@ManyToOne
	private Teacher teacher;

	@ManyToOne
	private Subject subject;

	@Enumerated(EnumType.STRING)
	private Weekday weekday;

	private int lessonNumber;

	protected TeachingUnit() {
	}

	public TeachingUnit(Subject subject, Teacher teacher, Weekday weekday,
			int lessonNumber) {
		this.teacher = teacher;
		this.subject = subject;
		this.weekday = weekday;
		this.lessonNumber = lessonNumber;
	}

	public Subject getSubject() {
		return subject;
	}

	public Weekday getWeekday() {
		return weekday;
	}

	public int getLessonNumber() {
		return lessonNumber;
	}
}
