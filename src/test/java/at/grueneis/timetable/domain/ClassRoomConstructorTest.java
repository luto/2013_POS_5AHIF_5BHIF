/*
 * Jumio Inc.
 *
 * Copyright (C) 2010 - 2011
 * All rights reserved.
 */
package at.grueneis.timetable.domain;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class ClassRoomConstructorTest {

    private String name;

    private String building;

    private String floor;

    public ClassRoomConstructorTest(String name, String building, String floor) {
        this.name = name;
        this.building = building;
        this.floor = floor;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{ //
                {null, null, null}, //
                {null, "Hugo", null}, //
                {null, null, "Hugo"}, //
                {null, "Building", "Hugo"}};
        return Arrays.asList(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreatingWithNullArguments() {
        new ClassRoom(name, building, floor);
    }
}
