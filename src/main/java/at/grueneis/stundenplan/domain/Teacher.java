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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teachers")
public class Teacher extends BasePersistable {

	private static final long serialVersionUID = -6667520361999134030L;

	@Size(max = 255)
	@NotNull
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@OneToMany(targetEntity = TeachingUnit.class, mappedBy = "teacher")
	private Collection<TeachingUnit> teachingUnits;

	protected Teacher() {
	}

	public Teacher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
