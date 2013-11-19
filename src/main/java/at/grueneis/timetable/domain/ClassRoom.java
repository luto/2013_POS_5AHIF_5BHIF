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
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "class_rooms")
public class ClassRoom extends BasePersistable {

    private static final long serialVersionUID = 6812918095609408451L;

    @NotNull
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    private String building;

    private String floor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classRoom")
    private Collection<TeachingUnit> teachingUnits;

    protected ClassRoom() {
        // required for JPA
    }

    public ClassRoom(String name, String building, String floor) {
        Ensure.notEmpty("name", name);
        this.name = name;
        this.building = building;
        this.floor = floor;
        this.teachingUnits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBuilding() {
        return building;
    }

    public String getFloor() {
        return floor;
    }

    public Collection<TeachingUnit> getTeachingUnits() {
        return Collections.unmodifiableCollection(teachingUnits);
    }
}
