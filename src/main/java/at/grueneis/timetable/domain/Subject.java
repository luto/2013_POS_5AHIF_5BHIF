/**
 * Joachim Grueneis
 * mailto:grueneis@spengergasse.at
 *
 * Copyright (C) 2013
 * All rights reserved.
 */
package at.grueneis.timetable.domain;

import at.grueneis.timetable.Ensure;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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

    private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Teacher> teachers;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<CurriculumSubject> curriculumSubjects;

	protected Subject() {
		// required for JPA
	}

	public Subject(String name, String description) {
        Ensure.notNull("name", name);
		this.name = name;
        this.description = description;
        this.teachers = new ArrayList<>();
        this.curriculumSubjects = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

    public String getDescription() {
        return description;
    }

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	public Collection<Teacher> getTeachers() {
		return Collections.unmodifiableCollection(teachers);
	}

	public void addCurriculumSubject(CurriculumSubject curriculumSubject) {
        curriculumSubjects.add(curriculumSubject);
	}

	public Collection<CurriculumSubject> getCurriculumSubjects() {
		return Collections.unmodifiableCollection(curriculumSubjects);
	}
}
