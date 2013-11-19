/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class TeacherConstructorTest {

    private final String name;

    private final Date birthDate;

    public TeacherConstructorTest(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{ //
                {null, null}, //
                {"Hugo", null}, //
                {null, new Date()}};
        return Arrays.asList(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreatingWithNullArguments() {
        new Teacher(this.name, this.birthDate);
    }
}
