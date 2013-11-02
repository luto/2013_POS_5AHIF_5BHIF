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
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teachers")
    private Collection<Subject> subjects;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacher")
    private Collection<TeachingUnit> teachingUnits;

    protected Teacher() {
        // required for JPA
    }

    public Teacher(String name, Date birthDate) {
        Ensure.notEmpty("name", name);
        Ensure.notNull("birthDate", birthDate);
        this.name = name;
        this.birthDate = (Date)birthDate.clone();
        this.subjects = new ArrayList<>();
        this.teachingUnits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return (Date)birthDate.clone();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public Collection<Subject> getSubjects() {
        return Collections.unmodifiableCollection(subjects);
    }

    public void addTeachingUnit(TeachingUnit teachingUnit) {
        teachingUnits.add(teachingUnit);
    }

    public Collection<TeachingUnit> getTeachingUnits() {
        return Collections.unmodifiableCollection(teachingUnits);
    }
}
