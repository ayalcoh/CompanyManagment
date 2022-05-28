package Michael_Kogan_Ayal_Cohen_Project.Model;

public class EmployeeHourSalary extends Employee {
	

	private static final long serialVersionUID = 1L;
	
	private int hourSalry;
	private static final int WORK_HOURS_PER_DAY = 8;
	private int salary;

	public EmployeeHourSalary(Role role, Preference prefEmpl ,int hourSalary) {
		super(role, prefEmpl);
		this.hourSalry = hourSalary;
		this.salary = hourSalary * WORK_HOURS_PER_DAY;
	}
	public EmployeeHourSalary(EmployeeHourSalary other) {
		super(other);
		this.hourSalry = other.hourSalry;
		this.salary = other.salary;
	}
	public int getHourSalry() {
		return hourSalry;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Employee Hour Salary: " + hourSalry + ", And all day salary " + this.salary + "\r\n");
		sb.append("----------------------------------\r\n");
		return super.toString() + sb.toString();
	}
}