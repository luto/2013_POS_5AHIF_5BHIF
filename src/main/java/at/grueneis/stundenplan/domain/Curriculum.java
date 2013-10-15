/**
 * Joachim Grueneis
 * mailto:grueneis@spengergasse.at
 *
 * Copyright (C) 2013
 * All rights reserved.
 */
package at.grueneis.stundenplan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "curriculum")
public class Curriculum extends BasePersistable {

	private static final long serialVersionUID = 7550955629376353786L;

	@NotNull
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@ManyToOne
	private Subject subject;

	@Enumerated(EnumType.STRING)
	private CurriculumYear curriculumYear;

	private int numberOfHours;

	public void setName(String name) {
		this.name = name;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public void setCurriculumYear(CurriculumYear curriculumYear) {
		this.curriculumYear = curriculumYear;
	}

	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
}
