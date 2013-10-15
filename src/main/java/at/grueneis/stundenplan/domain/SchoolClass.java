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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "school_classes")
public class SchoolClass extends BasePersistable {
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "curriculum_year", nullable = false)
	private CurriculumYear curriculumYear;

	@Size(max = 255)
	@NotNull
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	public SchoolClass() {
	}

	public SchoolClass(CurriculumYear curriculumYear, String name) {
		this.curriculumYear = curriculumYear;
		this.name = name;
	}

	public CurriculumYear getCurriculumYear() {
		return curriculumYear;
	}

	public void setCurriculumYear(CurriculumYear curriculumYear) {
		this.curriculumYear = curriculumYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
