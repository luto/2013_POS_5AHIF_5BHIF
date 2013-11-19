package at.grueneis.timetable.domain.emp;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends CompanyEmployee {

	private static final long serialVersionUID = -6336598104631359242L;

	private Long salary;

	protected FullTimeEmployee() {
	}

	public FullTimeEmployee(String name, Date startDate, Integer vacationDays,
			Long salary) {
		super(name, startDate, vacationDays);
		this.salary = salary;
	}

	public Long getSalary() {
		return salary;
	}
}
