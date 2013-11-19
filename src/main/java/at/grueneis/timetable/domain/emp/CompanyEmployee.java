package at.grueneis.timetable.domain.emp;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CompanyEmployee extends Employee {

	private static final long serialVersionUID = -6840029311453842362L;

	private Integer vacationDays;

	protected CompanyEmployee() {
	}

	public CompanyEmployee(String name, Date startDate, Integer vacationDays) {
		super(name, startDate);
		this.vacationDays = vacationDays;
	}

	public Integer getVacationDays() {
		return vacationDays;
	}
}
