/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */

package at.grueneis.timetable.domain;

import at.grueneis.timetable.Ensure;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "curriculums")
public class Curriculum extends BasePersistable {

    private static final long serialVersionUID = 7550955629376353786L;

    @NotNull
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @OneToMany
    private Collection<CurriculumSubject> curriculumSubjects;

    protected Curriculum() {
        // required for JPA
    }

    public Curriculum(String name) {
        Ensure.notEmpty("name", name);
        this.name = name;
        this.curriculumSubjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Collection<CurriculumSubject> getCurriculumSubjects() {
        return Collections.unmodifiableCollection(curriculumSubjects);
    }

    public void addCurriculumSubject(CurriculumSubject curriculumSubject) {
        this.curriculumSubjects.add(curriculumSubject);
    }
}
