package Michael_Kogan_Ayal_Cohen_Project.Model;

import java.io.Serializable;

public class Role implements IsSync, IsChangeble, Serializable {


	private static final long serialVersionUID = 1L;
	
	private boolean isSync;
	private boolean isChangeble;
	private Preference preferForRole;
	private String roleName;
	private String depName;
	private Department department;

	public Role(String roleName, Department depName, Preference prefer, boolean isSync, boolean isChangeble) {
		this.roleName = roleName;
		this.department = depName;
		this.depName = depName.getDepName();
		this.preferForRole = prefer;
		this.isSync = isSync;
		this.isChangeble = isChangeble;
	}
	public Role(Role other) {
		this.roleName = other.roleName;
		this.department = other.department;
		this.depName = other.depName;
		this.preferForRole = other.preferForRole;
		this.isSync = other.isSync;
		this.isChangeble = other.isChangeble;
	}
	//Get//
	public Preference getPreferForRole() {
		return preferForRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getDepName() {
		return depName;
	}
	public Department getDepartment() {
		return department;
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
	public void setRolePref(Preference prefer) {
		this.preferForRole = prefer;
		
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
		sb.append("---------------------------\r\n");
		sb.append("Role: " + this.getRoleName() + "\r\n");
		sb.append("Roles' Department: " + this.getDepName() + "\r\n");
		sb.append("Is Sync? " + converToString(this.isSync(), null, true) + "\r\n");
		sb.append("Is Changeble? " + converToString(this.isChangeble(), null, true) + "\r\n");
		sb.append("What is the preference? " + converToString(false ,this.getPreferForRole(), false) + "\r\n");
		sb.append("----------------------------\r\n");
		return sb.toString();
	}
	//Methods
	private String converToString(boolean bool, Preference prefer, boolean boolCheck) {
		if (boolCheck == true) {
			if (bool == true) {
				return "Yes";
			}else if(bool == false) {
				return "No";
			}
		}else if(boolCheck == false) {
			if (prefer == Preference.early) {
				return "All employees with same roles start early.";
			}
			if (prefer == Preference.late) {
				return "All employees with same roles start late.";
			}
			if (prefer == Preference.regular) {
				return "All employees with same roles Start in 8:00 AM.";
			}
			if (prefer == Preference.home) {
				return "All employees with same roles work from home.";
			}
			if (prefer == Preference.dontCare) {
				return "All employees work by what thier Departments require.";
			}
		}
		return null;
	}
}