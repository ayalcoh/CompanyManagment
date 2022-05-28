package Michael_Kogan_Ayal_Cohen_Project.Model;

public class EmployeeBaseSalary extends Employee {


	private static final long serialVersionUID = 1L;
	
	private int baseSalary;
	private double hourSalary;
	private final int NUMBER_OF_WORK_HOUR_IN_MONTH = 160;
	public EmployeeBaseSalary(Role role,  Preference typeOfWork ,int baseSalary) {
		super(role, typeOfWork);
		this.baseSalary = baseSalary;
		this.hourSalary = baseSalary / NUMBER_OF_WORK_HOUR_IN_MONTH;
	}
	public EmployeeBaseSalary(EmployeeBaseSalary other) {
		super(other);
		this.baseSalary = other.baseSalary;
		this.hourSalary = other.hourSalary;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public double getHourSalary() {
		return this.hourSalary;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Employee Base Salary: " + this.baseSalary + "\r\n");
		sb.append("Employee Hour Salary: " + this.hourSalary + "\r\n");
		sb.append("----------------------------------\r\n");
		return super.toString() + sb.toString();
	}
}
