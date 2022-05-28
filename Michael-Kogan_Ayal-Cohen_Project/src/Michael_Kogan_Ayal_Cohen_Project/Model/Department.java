package Michael_Kogan_Ayal_Cohen_Project.Model;

import java.io.Serializable;
import java.util.Iterator;

public class Department implements IsSync, IsChangeble, Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean isSync;
	private boolean isChangeble;
	private String depName;
	private Preference preferForDep;
	private int numOfEmployeesPerDep;
	private int numOfRolesPerDep;
	private Set<Employee> employees;
	private Set<Role> roles;
	
	public Department(String DepName, boolean isSync,boolean isChangeble, Preference prefer) {
		this.depName = DepName;
		this.isSync = isSync;
		this.isChangeble = isChangeble;
		this.preferForDep = prefer;
		this.employees = new Set<Employee>();
		this.roles = new Set<Role>();
		this.numOfEmployeesPerDep = 0;
		this.numOfRolesPerDep = 0;
	}
	public Department(Department other) throws Exception {
		this.depName = other.depName;
		this.isSync = other.isSync;
		this.isChangeble = other.isChangeble;
		this.preferForDep = other.preferForDep;
		Iterator<? extends Employee> iterEmp = other.employees.iterator();
		while(iterEmp.hasNext()) {
			this.employees.add((Employee) iterEmp);
		}
		Iterator<? extends Role> iterRole = other.roles.iterator();
		while(iterRole.hasNext()) {
			this.roles.add((Role) iterRole);
		}
		this.numOfEmployeesPerDep = other.numOfEmployeesPerDep;
		this.numOfRolesPerDep = other.numOfRolesPerDep;

	}
	//Get//
	public String getDepName() {
		return depName;
	}
	public Preference getPrefer() {
		return preferForDep;
	}
	public int getNumOfEmployeesPerDep() {
		return numOfEmployeesPerDep;
	}
	public int getNumOfRolesPerDep() {
		return numOfRolesPerDep;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	@Override
	public boolean isChangeble() {
		return this.isChangeble;
	}
	@Override
	public boolean isSync() {
		return this.isSync;
	}
	//Set//
	public void setNumOfEmployees(int raise) {
		this.numOfEmployeesPerDep += raise;
	}
	public void setEmployeesForDepartment(Set<Employee> emloyeesArray) {
		this.employees = emloyeesArray;	
	}
	public void setNumOfRoles(int raise) {
		this.numOfRolesPerDep += raise;		
	}
	public void setRolesForDepartment(Set<Role> rolesArray) {
		this.roles = rolesArray;	
	}
	public void setDepPref(Preference prefer) {
		this.preferForDep = prefer;	
	}
	public void setIsChangeble(boolean isChangeble) {
		this.isChangeble = isChangeble;	
	}
	public void setIsSync(boolean isSync) {
		this.isSync = isSync;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("----------------------------------\r\n");
		sb.append("Department Name: " + getDepName() + "\r\n");
		sb.append("Is Sync? " + TypeString(this.isSync(),null, true) + "\r\n");
		sb.append("Work Preference In Department " + TypeString(false, this.getPrefer(), false) + "\r\n");
		sb.append("Is Changeble? " + TypeString(this.isChangeble(), null, true) + "\r\n");
		sb.append("Number of Employees " + getNumOfEmployeesPerDep() + "\r\n");
		sb.append("Number of Roles: " + this.getNumOfRolesPerDep() + "\r\n");
		sb.append("  Roles List: \r\n");
		sb.append("----------------------------------\r\n");
		for (int i = 0; i < this.getNumOfRolesPerDep(); i++) {
			sb.append("   Role " + (i + 1)  + ": "  + roles.getCollection().elementAt(i).getRoleName() + "\r\n");
		}
		sb.append("----------------------------------\r\n");
		sb.append("  Employees List: \r\n");
		sb.append("----------------------------------\r\n");
		for (int i = 0; i < this.getNumOfEmployeesPerDep(); i++) {
			sb.append("   Employee ID: "+ employees.getCollection().elementAt(i).getID() + "\r\n");
			sb.append("   Employee Role: " + employees.getCollection().elementAt(i).getRole().getRoleName() + "\r\n");
		}
		sb.append("----------------------------------");
		return sb.toString();
	}
	//Methods
	private String TypeString(boolean bool ,Preference type, boolean boolCheck) {
		if (boolCheck == true) {
			if (bool == true) {
				return "Yes";
			}else if(bool == false) {
				return "No";
			}
		}
		if (boolCheck == false) {
			if (type == Preference.early) {
				return "All employees start early.";
			}else if(type == Preference.late) {
				return "All employees start late.";
			}else if(type == Preference.regular) {
				return "All employees Start in 8:00 AM.";
			}else if(type == Preference.home) {
				return "All employees work from home.";
			}else if(type == Preference.dontCare) {
				return "All employees work by what thier roles require.";
			}
		}
		return null;
	}
}