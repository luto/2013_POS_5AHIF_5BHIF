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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curriculum_subjects")
public class CurriculumSubject extends BasePersistable {

    private static final long serialVersionUID = 7550955629376353786L;

    @ManyToOne
    private Curriculum curriculum;

    @ManyToOne
    private Subject subject;

    @Enumerated(EnumType.STRING)
    private CurriculumYear curriculumYear;

    private int numberOfHours;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curriculumSubject")
    private Collection<TeachingUnit> teachingUnits;

    protected CurriculumSubject() {
        // required for JPA
    }

    public CurriculumSubject(Curriculum curriculum, Subject subject, CurriculumYear curriculumYear, int numberOfHours) {
        Ensure.notNull("curriculum", curriculum);
        Ensure.notNull("subject", subject);
        Ensure.notNull("curriculumYear", curriculumYear);
        this.curriculum = curriculum;
        this.subject = subject;
        this.curriculumYear = curriculumYear;
        this.numberOfHours = numberOfHours;
        this.teachingUnits = new ArrayList<>();
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public Subject getSubject() {
        return subject;
    }

    public CurriculumYear getCurriculumYear() {
        return curriculumYear;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public Collection<TeachingUnit> getTeachingUnits() {
        return Collections.unmodifiableCollection(teachingUnits);
    }
}
