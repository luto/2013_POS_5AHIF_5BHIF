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

    private final String shortName;

    private final String name;

    private final Date birthDate;

    public TeacherConstructorTest(String shortName, String name, Date birthDate) {
        this.shortName = shortName;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {null, null, null},
                {"HG", "Hugo", null},
                {null, "Hugo", null},
                {null, "Hugo", new Date()},
                {"HG", null, new Date()}
            };
        return Arrays.asList(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreatingWithNullArguments() {
        new Teacher(this.shortName, this.name, this.birthDate);
    }
}
