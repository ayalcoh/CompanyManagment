package Michael_Kogan_Ayal_Cohen_Project.Model;

import java.io.Serializable;
import java.util.Vector;

public class Company implements Serializable{


	private static final long serialVersionUID = 1L;

	private Set<Department> allDepartments = new Set<Department>();
	private Set <Employee> allEmployees = new Set<Employee>();
	private Set <Role> allRoles = new Set<Role>();
	private int numOfDepartments = 0;
	private int numOfEmployees = 0;
	private int numOfRoles = 0;

	//old eff
	private Vector<Float> emplEff = new Vector<Float>();
	private int numOfEff = 0;


	//new eff 
	private Vector<Float> newEmplEff = new Vector<Float>();
	private int newNumOfEff = 0;




	// ((new eff - old eff) / old eff) * 100 
	public String showResult() {

		StringBuffer sb = new StringBuffer();
		sb.append("---------------------\r\n");
		sb.append("Employees Profit/Loss\r\n");
		for (int i = 0; i < this.numOfEmployees; i++) {
			newEmployeeEff(allEmployees.getCollection().elementAt(i));
			sb.append("Employee ID " + allEmployees.getCollection().elementAt(i).getID() + " " + ( (newEmplEff.elementAt(i) - emplEff.elementAt(i)) / emplEff.elementAt(i) ) * 100 + "%\r\n");
		}
		sb.append("---------------------\r\n");
		sb.append("Departmetns Profit/Loss\r\n");
		float eff = 0;
		float effCompany = 0;
		for (int i = 0; i < this.numOfDepartments; i++) {
			for (int j = 0; j < this.numOfEmployees; j++) {
				if (allEmployees.getCollection().elementAt(j).getDepName().equals(allDepartments.getCollection().elementAt(i).getDepName()))  {
					eff += ( (newEmplEff.elementAt(j) - emplEff.elementAt(j )) / emplEff.elementAt(j ) ) * 100;
					
				}
			}
			sb.append(allDepartments.getCollection().elementAt(i).getDepName() + " " + (eff / allDepartments.getCollection().elementAt(i).getNumOfEmployeesPerDep()) + "%\r\n");
			effCompany += eff;
			eff = 0;
		}
		sb.append("---------------------\r\n");
		sb.append("Company Profit/Loss " + (effCompany / this.numOfDepartments) + "%\r\n") ;
		this.newNumOfEff = 0;
		return sb.toString();
	}
	//cons
	public Company() {

	}
	//copy cons
	public Company(Company other) throws Exception{
		for(int i = 0 ; i < other.numOfDepartments ; i++) {
			this.allDepartments.add(new Department(other.allDepartments.getCollection().elementAt(i)));
		}
		for(int i = 0 ; i < other.numOfEmployees ; i++) {
			this.allEmployees.add(new Employee(other.allEmployees.getCollection().elementAt(i)));
		}
		for (int i = 0; i < other.numOfRoles; i++) {
			this.allRoles.add(new Role(other.allRoles.getCollection().elementAt(i)));
		}
		this.numOfEmployees = other.numOfEmployees;
		this.numOfDepartments = other.numOfDepartments;
		this.numOfRoles = other.numOfRoles;
	}
	//add department
	public boolean addDepartmet(Department d1) throws Exception {
		if (this.allDepartments.contains(d1)) {
			return false;
		}
		for (int i = 0; i < this.numOfDepartments; i++) {
			if (d1.getDepName().equals(this.allDepartments.getCollection().elementAt(i).getDepName())) {
				return false;
			}
		}
		this.allDepartments.add(d1);
		this.numOfDepartments++;
		return true;
	}
	//add role
	public boolean addRole(Role r1) throws Exception {
		if (this.allRoles.contains(r1)) {
			return false;
		}
		for (int i = 0; i < this.numOfRoles; i++) {
			if (r1.getRoleName().equals(this.allRoles.getCollection().elementAt(i).getRoleName())) {
				return false;
			}
		}
		this.allRoles.add(r1);
		this.numOfRoles++;

		for (int i = 0; i < this.numOfDepartments; i++) {
			if (r1.getDepartment().equals(this.allDepartments.getCollection().elementAt(i))) {
				Department d1 = this.allDepartments.getCollection().elementAt(i);
				return addRoleToDepartment(d1, r1);
			}
		}
		return true;
	}
	//add role to a specific department
	public boolean addRoleToDepartment(Department d1, Role r1) throws Exception {
		Set<Role> roles = new Set<Role>();
		for (int i = 0; i < this.numOfRoles; i++) {
			if (this.allRoles.getCollection().elementAt(i).getDepartment().equals(d1)) {
				roles.add(this.allRoles.getCollection().elementAt(i));
			}
		}
		d1.setRolesForDepartment(roles);
		d1.setNumOfRoles(1);
		return true;
	}
	//add employee
	public boolean addEmployee(Employee e1) throws Exception{
		if (this.allEmployees.contains(e1)) {
			return false;
		}
		for (int i = 0; i < this.numOfEmployees; i++) {
			if (e1.getID() == this.allEmployees.getCollection().elementAt(i).getID()) {
				return false;
			}
		}
		if (e1 instanceof EmployeeHourSalary) {
			this.allEmployees.add((EmployeeHourSalary)e1);
			this.numOfEmployees++;
			for (int i = 0; i < this.numOfDepartments; i++) {
				if (e1.getDepName() == this.allDepartments.getCollection().elementAt(i).getDepName()) {
					Department d1 = this.allDepartments.getCollection().elementAt(i);
					employeeEff(e1);
					return addEmployeeToDepartment(d1, (EmployeeHourSalary)e1);
				}
			}
		}
		if (e1 instanceof EmployeeBaseSalary) {
			this.allEmployees.add((EmployeeBaseSalary)e1);
			this.numOfEmployees++;
			for (int i = 0; i < this.numOfDepartments; i++) {
				if (e1.getDepName() == this.allDepartments.getCollection().elementAt(i).getDepName()) {
					Department d1 = this.allDepartments.getCollection().elementAt(i);
					employeeEff(e1);
					return addEmployeeToDepartment(d1, (EmployeeBaseSalary)e1);
				}
			}
		}
		if (e1 instanceof EmployeeBaseSalaryWithBonus) {
			this.allEmployees.add((EmployeeBaseSalaryWithBonus)e1);
			this.numOfEmployees++;
			for (int i = 0; i < this.numOfDepartments; i++) {
				if (e1.getDepName() == this.allDepartments.getCollection().elementAt(i).getDepName()) {
					Department d1 = this.allDepartments.getCollection().elementAt(i);
					employeeEff(e1);
					return addEmployeeToDepartment(d1, (EmployeeBaseSalaryWithBonus)e1);
				}
			}
		}
		return false;
	}
	//add employee to a specific department
	private boolean addEmployeeToDepartment(Department d1, Employee e1) throws Exception{
		Set<Employee> employees = new Set<Employee>();
		for (int i = 0; i < this.numOfEmployees; i++) {
			if (allEmployees.getCollection().elementAt(i).getDepName() == d1.getDepName()) {
				employees.add(allEmployees.getCollection().elementAt(i));
			}
		}
		d1.setEmployeesForDepartment(employees);
		d1.setNumOfEmployees(1);
		return true;
	}
	//Get//
	public Set<Department> getAllDepartments() {
		return allDepartments;
	}
	public Set<Employee> getAllEmployees() {
		return allEmployees;
	}
	public Set<Role> getAllRoles() {
		return allRoles;
	}
	public int getNumOfDepartments() {
		return numOfDepartments;
	}
	public int getNumOfEmployees() {
		return numOfEmployees;
	}
	public int getNumOfRoles() {
		return numOfRoles;
	}
	public Vector<Float> getEfficiency() {
		return this.emplEff;
	}
	//Show
	public String showAllDepartments() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < this.numOfDepartments; i++) {
			sb.append(getAllDepartments().getCollection().elementAt(i).toString());
		}

		return sb.toString();
	}
	public String showAllEmployees() {
		StringBuffer sb =  new StringBuffer();
		for (int i = 0; i < this.numOfEmployees; i++) {
			sb.append(getAllEmployees().getCollection().elementAt(i).toString());		
		}
		return sb.toString();
	}
	public String showAllRoles() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < this.numOfRoles; i++) {
			sb.append(getAllRoles().getCollection().elementAt(i).toString());
		}
		return sb.toString();
	}
	//Methods
	public void setNumOfDep(int numOfDepartments) {
		this.numOfDepartments = numOfDepartments;

	}
	public void setNumOfRoles(int numOfRoles) {
		this.numOfRoles = numOfRoles;

	}
	public void setNumOfEmpl(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;

	}
	public void setAllDep(Set<Department> allDepartments) {
		this.allDepartments = allDepartments;

	}
	public void setAllRoles(Set<Role> allRoles) {
		this.allRoles = allRoles;

	}
	public void setAllEmpl(Set<Employee> allEmployees) {
		this.allEmployees = allEmployees;

	}
	public void setEff(Vector<Float> eff) {
		this.emplEff = eff;

	}

	public int getNumOfEff(){
		
		return numOfEff;

	}

	private void employeeEff(Employee e1) {

		for (int i = 0; i < this.numOfDepartments; i++) {
			if (e1.getDepName().equals(allDepartments.getCollection().elementAt(i).getDepName())) {
				Department d1 = allDepartments.getCollection().elementAt(i);
				Role r1  = e1.getRole();
				Preference depPref = d1.getPrefer();
				Preference emplPref = e1.getTypeOfWork();
				Preference rolePref = r1.getPreferForRole();
				boolean workFromHome = e1.getWorkFromHome();
				if (e1 instanceof EmployeeHourSalary) {
					if (workFromHome) {
						if (depPref.equals(Preference.home)) {
							emplEff.add(numOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 1.1));
							numOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(Preference.home) || rolePref.equals(Preference.dontCare)) {
								emplEff.add(numOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 1.1));
								numOfEff++;
							}else if(!rolePref.equals(Preference.home) && !rolePref.equals(Preference.dontCare)){
								emplEff.add(numOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 0.8));
								numOfEff++;
							}
						}else if(!depPref.equals(Preference.home) && !depPref.equals(Preference.dontCare)){
							emplEff.add(numOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 0.8));
							numOfEff++;
						}
					}else {
						if (emplPref.equals(depPref)) {
							emplEff.add(numOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 1.2));
							numOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(emplPref) || rolePref.equals(Preference.dontCare)) {
								emplEff.add(numOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 1.2));
								numOfEff++;
							}else if(!rolePref.equals(emplPref) && !rolePref.equals(Preference.dontCare)){
								emplEff.add(numOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 0.8));
								numOfEff++;
							}
						}else if(!depPref.equals(Preference.dontCare) && emplPref.equals(depPref)){
							emplEff.add(numOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 0.8));
							numOfEff++;
						}
					}
				}else if (e1 instanceof EmployeeBaseSalary) {
					if (workFromHome) {
						if (depPref.equals(Preference.home)) {
							emplEff.add(numOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 1.1));
							numOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(Preference.home) || rolePref.equals(Preference.dontCare)) {
								emplEff.add(numOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 1.1));
								numOfEff++;
							}else if(!rolePref.equals(Preference.home) && !rolePref.equals(Preference.dontCare)){
								emplEff.add(numOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 0.8));
								numOfEff++;
							}
						}else if(!depPref.equals(Preference.home) && !depPref.equals(Preference.dontCare)){
							emplEff.add(numOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 0.8));
							numOfEff++;
						}
					}else {
						if (emplPref.equals(depPref)) {
							emplEff.add(numOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 1));
							numOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(emplPref) || rolePref.equals(Preference.dontCare)) {
								emplEff.add(numOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 1.2));
								numOfEff++;
							}else if(!rolePref.equals(emplPref) && !rolePref.equals(Preference.dontCare)){
								emplEff.add(numOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 0.8));
								numOfEff++;
							}
						}else if(!depPref.equals(Preference.dontCare) && emplPref.equals(depPref)){
							emplEff.add(numOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 0.8));
							numOfEff++;
						}
					}
				}else if(e1 instanceof EmployeeBaseSalaryWithBonus) {
					if (workFromHome) {
						if (depPref.equals(Preference.home)) {
							emplEff.add(numOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 1.1));
							numOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(Preference.home) || rolePref.equals(Preference.dontCare)) {
								emplEff.add(numOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 1.1));
								numOfEff++;
							}else if(!rolePref.equals(Preference.home) && !rolePref.equals(Preference.dontCare)){
								emplEff.add(numOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 0.8));
								numOfEff++;
							}
						}else if(!depPref.equals(Preference.home) && !depPref.equals(Preference.dontCare)){
							emplEff.add(numOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 0.8));
							numOfEff++;
						}
					}else {
						if (emplPref.equals(depPref)) {
							emplEff.add(numOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 1));
							numOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(emplPref) || rolePref.equals(Preference.dontCare)) {
								emplEff.add(numOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 1.2));
								numOfEff++;
							}else if(!rolePref.equals(emplPref) && !rolePref.equals(Preference.dontCare)){
								emplEff.add(numOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 0.8));
								numOfEff++;
							}
						}else if(!depPref.equals(Preference.dontCare) && !emplPref.equals(depPref)){
							emplEff.add(numOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 0.8));
							numOfEff++;
						}
					}
				}
			}	

		}
	}

	private void newEmployeeEff(Employee e1) {
		for (int i = 0; i < this.numOfDepartments; i++) {

			if (e1.getDepName().equals(allDepartments.getCollection().elementAt(i).getDepName())) {
				Department d1 = allDepartments.getCollection().elementAt(i);
				Role r1  = e1.getRole();
				Preference depPref = d1.getPrefer();
				Preference emplPref = e1.getTypeOfWork();
				Preference rolePref = r1.getPreferForRole();
				boolean workFromHome = e1.getWorkFromHome();
				if (e1 instanceof EmployeeHourSalary) {
					if (workFromHome) {
						if (depPref.equals(Preference.home)) {
							newEmplEff.add(newNumOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 1.1));
							newNumOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(Preference.home) || rolePref.equals(Preference.dontCare)) {
								newEmplEff.add(newNumOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 1.1));
								newNumOfEff++;
							}else if(!rolePref.equals(Preference.home) && !rolePref.equals(Preference.dontCare)){
								newEmplEff.add(newNumOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 0.8));
								newNumOfEff++;
							}
						}else if(!depPref.equals(Preference.home) && !depPref.equals(Preference.dontCare)){
							newEmplEff.add(newNumOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 0.8));
							newNumOfEff++;
						}
					}else {
						if (emplPref.equals(depPref)) {
							newEmplEff.add(newNumOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 1.2));
							newNumOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(emplPref) || rolePref.equals(Preference.dontCare)) {
								newEmplEff.add(newNumOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 1.2));
								newNumOfEff++;
							}else if(!rolePref.equals(emplPref) && !rolePref.equals(Preference.dontCare)){
								newEmplEff.add(newNumOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 0.8));
								newNumOfEff++;
							}
						}else if(!depPref.equals(Preference.dontCare) && emplPref.equals(depPref)){
							newEmplEff.add(newNumOfEff, (float) (((EmployeeHourSalary) e1).getHourSalry() * 0.8));
							newNumOfEff++;
						}
					}
				}else if (e1 instanceof EmployeeBaseSalary) {
					if (workFromHome) {
						if (depPref.equals(Preference.home)) {
							newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 1.1));
							newNumOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(Preference.home) || rolePref.equals(Preference.dontCare)) {
								newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 1.1));
								newNumOfEff++;
							}else if(!rolePref.equals(Preference.home) && !rolePref.equals(Preference.dontCare)){
								newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 0.8));
								newNumOfEff++;
							}
						}else if(!depPref.equals(Preference.home) && !depPref.equals(Preference.dontCare)){
							newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 0.8));
							newNumOfEff++;
						}
					}else {
						if (emplPref.equals(depPref)) {
							newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 1));
							newNumOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(emplPref) || rolePref.equals(Preference.dontCare)) {
								newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 1.2));
								newNumOfEff++;
							}else if(!rolePref.equals(emplPref) && !rolePref.equals(Preference.dontCare)){
								newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 0.8));
								newNumOfEff++;
							}
						}else if(!depPref.equals(Preference.dontCare) && emplPref.equals(depPref)){
							newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalary) e1).getHourSalary() * 0.8));
							newNumOfEff++;
						}
					}
				}else if(e1 instanceof EmployeeBaseSalaryWithBonus) {
					if (workFromHome) {
						if (depPref.equals(Preference.home)) {
							newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 1.1));
							newNumOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(Preference.home) || rolePref.equals(Preference.dontCare)) {
								newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 1.1));
								newNumOfEff++;
							}else if(!rolePref.equals(Preference.home) && !rolePref.equals(Preference.dontCare)){
								newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 0.8));
								newNumOfEff++;
							}
						}else if(!depPref.equals(Preference.home) && !depPref.equals(Preference.dontCare)){
							newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 0.8));
							newNumOfEff++;
						}
					}else {
						if (emplPref.equals(depPref)) {
							newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 1));
							newNumOfEff++;
						}else if(depPref.equals(Preference.dontCare)) {
							if (rolePref.equals(emplPref) || rolePref.equals(Preference.dontCare)) {
								newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 1.2));
								newNumOfEff++;
							}else if(!rolePref.equals(emplPref) && !rolePref.equals(Preference.dontCare)){
								newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 0.8));
								newNumOfEff++;
							}
						}else if(!depPref.equals(Preference.dontCare) && !emplPref.equals(depPref)){
							newEmplEff.add(newNumOfEff, (float) (((EmployeeBaseSalaryWithBonus) e1).getHourSalary() * 0.8));
							newNumOfEff++;
						}
					}
				}

			}
		}

	}
	public void setNumOfEff(int numOfEff) {
		this.numOfEff = numOfEff;
		
	}

}