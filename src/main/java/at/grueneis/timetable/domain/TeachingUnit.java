/**
 * Joachim Grueneis
 * mailto:grueneis@spengergasse.at
 *
 * Copyright (C) 2013
 * All rights reserved.
 */
package at.grueneis.timetable.domain;

import at.grueneis.timetable.Ensure;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teaching_units")
public class TeachingUnit extends BasePersistable {

    private static final long serialVersionUID = -5889761023218222369L;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "curriculum_subject_id")
    private CurriculumSubject curriculumSubject;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClass;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_room_id")
    private ClassRoom classRoom;

    @Enumerated(EnumType.STRING)
    private Weekday weekday;

    private int lessonNumber;

    protected TeachingUnit() {
        // required for JPA
    }

    public TeachingUnit(CurriculumSubject curriculumSubject, Teacher teacher, SchoolClass schoolClass,
            ClassRoom classRoom, Weekday weekday, int lessonNumber) {
        Ensure.notNull("curriculumSubject", curriculumSubject);
        Ensure.notNull("teacher", teacher);
        Ensure.notNull("schoolClass", schoolClass);
        Ensure.notNull("classRoom", classRoom);
        Ensure.notNull("weekday", weekday);
        Ensure.notNull("lessonNumber", lessonNumber);
        this.curriculumSubject = curriculumSubject;
        this.teacher = teacher;
        this.schoolClass = schoolClass;
        this.classRoom = classRoom;
        this.weekday = weekday;
        this.lessonNumber = lessonNumber;
    }

    public CurriculumSubject getCurriculumSubject() {
        return curriculumSubject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }
}
