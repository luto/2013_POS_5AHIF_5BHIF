package at.grueneis.timetable.domain.emp;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ContractEmployee extends Employee {

	private static final long serialVersionUID = 719588602700076248L;

	private Integer dailyRate;

	protected ContractEmployee() {
	}

	public ContractEmployee(String name, Date startDate, Integer dailyRate) {
		super(name, startDate);
		this.dailyRate = dailyRate;
	}

	public Integer getDailyRate() {
		return dailyRate;
	}
}
