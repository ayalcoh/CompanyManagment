package Michael_Kogan_Ayal_Cohen_Project.Model;

import java.io.Serializable;

public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;

	private String depName;
	private Preference typeOfWork;
	private Role role;

	private static int ID = 1000;
	private boolean workFromHome = false;
	private int id = 0;

	//Cons
	public Employee(Role role, Preference prefer) {
		this.id = ID++;
		this.depName = role.getDepName();
		this.typeOfWork = prefer;
		if (this.typeOfWork.equals(Preference.home)) {
			setWorkFromHome();
		}
		this.role = role;

	}
	//copyCons
	public Employee(Employee other) {
		this.id = other.id;
		this.depName = other.depName;
		this.typeOfWork = other.typeOfWork;
		this.role = other.role;

	}
	//GET//
	public int getID() {
		return this.id;
	}
	public String getDepName() {
		return depName;
	}
	public Role getRole() {
		return role;
	}
	public Preference getTypeOfWork() {
		return typeOfWork;
	}
	public boolean getWorkFromHome() {
		return workFromHome;
	}
	//Set
	public void setWorkFromHome() {
		workFromHome = true;	
	}	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("----------------------------------\r\n");
		sb.append("ID: " + this.getID() + "\r\n");
		sb.append("Employee Department: " + this.getDepName() + "\r\n");
		sb.append("Employee Role: " + this.getRole().getRoleName() + "\r\n");
		sb.append("Work Type Employee: " + convertFromBooleanToString(this.typeOfWork) );
		sb.append("\n");
		return sb.toString();
	}
	//Methods
	private String convertFromBooleanToString(Preference type) {
		if (type == Preference.early) {
			return "Wants to start early.";
		}else if(type == Preference.late) {
			return "Wants to start late.";
		}else if(type == Preference.regular) {
			return "Wants to keep working regular from 8 AM.";	
		}else if(type == Preference.home) {
			return "Want to work from home.";
		}
		return null;
	}
}