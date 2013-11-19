package at.grueneis.timetable.domain.emp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import at.grueneis.timetable.domain.BasePersistable;

@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee extends BasePersistable {

	private static final long serialVersionUID = -1057318651318869980L;

	private String name;

	private Date startDate;

	protected Employee() {
	}

	public Employee(String name, Date startDate) {
		this.name = name;
		this.startDate = (Date) startDate.clone();
	}

	public String getName() {
		return name;
	}

	public Date getStartDate() {
		return startDate;
	}

}
