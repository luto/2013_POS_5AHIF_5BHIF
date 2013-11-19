package at.grueneis.timetable.domain.emp;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends CompanyEmployee {

	private static final long serialVersionUID = -4134852512549159114L;

	private Integer workingHours;

	protected PartTimeEmployee() {
	}

	public PartTimeEmployee(String name, Date startDate, Integer vacationDays,
			Integer workingHours) {
		super(name, startDate, vacationDays);
		this.workingHours = workingHours;
	}

	public Integer getWorkingHours() {
		return workingHours;
	}
}
