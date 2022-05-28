package Michael_Kogan_Ayal_Cohen_Project.Model;


public class EmployeeBaseSalaryWithBonus extends Employee {

	private static final long serialVersionUID = 1L;
	
	private double baseSalary;
	private double hourSalary;
	private final int NUMBER_OF_WORK_HOUR_IN_MONTH = 160;
	public EmployeeBaseSalaryWithBonus(Role role, Preference typeOfWork ,int baseSalary, int numberOfSales) {
		super(role, typeOfWork);
		this.baseSalary = baseSalary + numberOfSales * Math.random();
		this.hourSalary = this.baseSalary / NUMBER_OF_WORK_HOUR_IN_MONTH;
	}
	public EmployeeBaseSalaryWithBonus(EmployeeBaseSalaryWithBonus other) {
		super(other);
		this.baseSalary = other.baseSalary;
		this.hourSalary = other.hourSalary;
	}
	
	public double getBaseSalaryWithBouns() {
		return this.baseSalary;
	}
	public double getHourSalary() {
		return this.hourSalary;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Employee Base Salary With Bonus: " + this.getBaseSalaryWithBouns() + "\r\n");
		sb.append("Employee hour Salary with Bonus: " + this.hourSalary + "\r\n");
		sb.append("----------------------------------\r\n");
		return super.toString() + sb.toString();
	}


}
