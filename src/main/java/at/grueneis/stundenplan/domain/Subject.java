/**
 * Joachim Grueneis
 * mailto:grueneis@spengergasse.at
 *
 * Copyright (C) 2013
 * All rights reserved.
 */
package at.grueneis.stundenplan.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "subjects")
public class Subject extends BasePersistable {

	private static final long serialVersionUID = 1127398350055088704L;

	@Size(max = 255)
	@NotNull
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	private int hoursPerWeek;

	@Enumerated(EnumType.STRING)
	private CurriculumYear curriculumYear;

	@OneToMany(fetch = FetchType.LAZY)
	private Collection<TeachingUnit> teachingUnits;

	protected Subject() {
	}

	public Subject(String name, int hoursPerWeek) {
		this.name = name;
		this.hoursPerWeek = hoursPerWeek;
	}

	public String getName() {
		return name;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public CurriculumYear getCurriculumYear() {
		return curriculumYear;
	}

	public Collection<TeachingUnit> getTeachingUnits() {
		return teachingUnits;
	}
}
