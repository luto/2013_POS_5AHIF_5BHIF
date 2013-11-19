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
@Table(name = "school_classes")
public class SchoolClass extends BasePersistable {

    private static final long serialVersionUID = -3987457976754795091L;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "curriculum_year", nullable = false)
    private CurriculumYear curriculumYear;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "schoolClass")
    private Collection<TeachingUnit> teachingUnits;

    protected SchoolClass() {
        // required for JPA
    }

    public SchoolClass(CurriculumYear curriculumYear, String name) {
        Ensure.notNull("curriculumYear", curriculumYear);
        Ensure.notEmpty("name", name);
        this.curriculumYear = curriculumYear;
        this.name = name;
        this.teachingUnits = new ArrayList<>();
    }

    public CurriculumYear getCurriculumYear() {
        return curriculumYear;
    }

    public String getName() {
        return name;
    }

    public Collection<TeachingUnit> getTeachingUnits() {
        return Collections.unmodifiableCollection(teachingUnits);
    }
}
