package at.grueneis.timetable.domain;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SchoolClassConstructorTest {

	private final CurriculumYear curriculumYear;
	private final String name;

	public SchoolClassConstructorTest(CurriculumYear curriculumYear, String name) {
		this.curriculumYear = curriculumYear;
		this.name = name;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { null, null },
				{ CurriculumYear.I, null }, { null, "Hugo" } };
		return Arrays.asList(data);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenCreatingWithNullArguments() {
		new SchoolClass(this.curriculumYear, this.name);
	}
}
