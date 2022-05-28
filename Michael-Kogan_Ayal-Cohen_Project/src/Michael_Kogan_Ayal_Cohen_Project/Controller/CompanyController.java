package Michael_Kogan_Ayal_Cohen_Project.Controller;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Michael_Kogan_Ayal_Cohen_Project.Model.Company;
import Michael_Kogan_Ayal_Cohen_Project.Model.Department;
import Michael_Kogan_Ayal_Cohen_Project.Model.Employee;
import Michael_Kogan_Ayal_Cohen_Project.Model.EmployeeBaseSalary;
import Michael_Kogan_Ayal_Cohen_Project.Model.EmployeeBaseSalaryWithBonus;
import Michael_Kogan_Ayal_Cohen_Project.Model.EmployeeHourSalary;
import Michael_Kogan_Ayal_Cohen_Project.Model.Preference;
import Michael_Kogan_Ayal_Cohen_Project.Model.Role;
import Michael_Kogan_Ayal_Cohen_Project.View.CompanyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CompanyController {
	private Company model = new Company();
	private File file;
	private CompanyView view;


	public CompanyController(Company c1, CompanyView view) throws Exception {
		this.model = c1;
		this.view = view;
		callHardCoded();
		EventHandler<ActionEvent> addDepToModelEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					int b = 0;
					for(int i = 0; i < getCompany().getNumOfDepartments(); i++) {
						if (view.getTfNameDep().getText().equals(getCompany().getAllDepartments().getCollection().elementAt(i).getDepName())) {
							b = -1;
							getAlertNameExistDep();
						}
					}
					if(b != -1){
						sendDataOfDepartment(view.getTfNameDep().getText(), view.getCmbIsSyncDep().getSelectionModel().getSelectedItem(), view.getCmbIsChangeableDep().getSelectionModel().getSelectedItem(),
								view.getCmbPrefDep().getSelectionModel().getSelectedItem());
					}
				} catch (Exception e) {
					e.getStackTrace();
				}
				//view.updateShowAllDep();
				view.getInputInfoStage().close();
			}
		};
		//add department
		EventHandler<ActionEvent> addButtonDepEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				view.getInputInfoStage().setScene(view.getDepS());
				view.addDepartment(getCompany());
				view.confirmAddDepartment(addDepToModelEvent);
			}
		};

		EventHandler<ActionEvent> addRoleToModelEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try {
					int b = 0;	
					for (int i = 0; i < getCompany().getNumOfRoles(); i++) {
						//getAlertNameExistRole();
						if (view.getTfNameRole().getText().equals(getCompany().getAllRoles().getCollection().elementAt(i).getRoleName())) {

							getAlertNameExistRole();
							b = -1;
						}		

					}


					if(b != -1) {
						sendDataOfRole(view.getTfNameRole().getText(), view.getCmbDepName().getSelectionModel().getSelectedItem(),
								view.getCmbPrefRole().getSelectionModel().getSelectedItem(), 
								view.getCmbIsSyncRole().getSelectionModel().getSelectedItem(),
								view.getCmbIsChangeableRole().getSelectionModel().getSelectedItem());
					}

				} catch (Exception e) {
					e.getStackTrace();
				}
				//view.updateShowAllRoles();
				view.getInputInfoStage().close();

			}

		};

		//add role
		EventHandler<ActionEvent> addButtonToRoleEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				view.getInputInfoStage().setScene(view.getRoleS());
				view.addRole(getCompany());
				view.confirmAddRole(addRoleToModelEvent);

			}
		};
		
		
		EventHandler<ActionEvent> addEmplToModelEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try {
					if(view.getEmploTypeOfWork().getSelectedToggle().equals(view.getTogeleBase())) {
							sendDataEmployeeBase(view.getCmbRoleEmpl().getSelectionModel().getSelectedItem(), view.getCmbPrefEmpl().getSelectionModel().getSelectedItem(), 
									view.getEmployeeBase().getValue());
						}	
					else if(view.getEmploTypeOfWork().getSelectedToggle().equals(view.getTogeleBasaSale())) {
						sendDataEmployeeBaseSales(view.getCmbRoleEmpl().getSelectionModel().getSelectedItem(), view.getCmbPrefEmpl().getSelectionModel().getSelectedItem()
								, view.getEmployeeBase().getValue(), view.getEmployeeBonus().getValue());
					}
					else if(view.getEmploTypeOfWork().getSelectedToggle().equals(view.getTogeleHour())) {
						sendDataEmployeeHour(view.getCmbRoleEmpl().getSelectionModel().getSelectedItem(), view.getCmbPrefEmpl().getSelectionModel().getSelectedItem(), 
								view.getEmployeePerHour().getValue());
					}
				}catch(Exception e) {
					e.getStackTrace();
				}
				//view.updateShowAllEmployees();
				view.getInputInfoStage().close();
			}
		};

		//add employee
		EventHandler<ActionEvent> addButtonToEmployeeEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				view.getInputInfoStage().setScene(view.getEmpl());		
				view.addEmployee(getCompany());
				view.confirmAddEmployee(addEmplToModelEvent);
			}	
		};	
		// button to take me to add departments ,employees & roles
		EventHandler<ActionEvent> addEntities = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				view.addEntities();
				view.addEventToAddDepartment(addButtonDepEvent);
				view.addEventToAddEmployee(addButtonToEmployeeEvent);
				view.addEventToAddRole(addButtonToRoleEvent);
			}
		};
		view.addEventToAddEntities(addEntities);

		EventHandler<ActionEvent> showDepartmentsButtonEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				view.getInputInfoStage().setScene(view.showAllDep());
				view.showAllDepartments(getCompany());

			}
		};

		EventHandler<ActionEvent> showRolesButtonEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				view.getInputInfoStage().setScene(view.showAllRole());
				view.showAllRoles(getCompany());
			}
		};

		EventHandler<ActionEvent> showEmployeesButtonEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				view.getInputInfoStage().setScene(view.showAllEmpl());
				view.showAllEmployees(getCompany());

			}
		};
		
		//show button to take me to 3 more buttons from there to show toString of each
		EventHandler<ActionEvent> showEntitesWindowHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(getCompany() != null) {
					try {
						view.entitiesWindow();
						view.addEventToShowAllDep(showDepartmentsButtonEvent);
						view.addEventToShowAllRoles(showRolesButtonEvent);
						view.addEventToShowAllEmployees(showEmployeesButtonEvent);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}else {
					view.alertCompanyIsEmpty();
				}
			}
		};
		view.addEventToEntitesWindow(showEntitesWindowHandler);

		EventHandler<ActionEvent> saveRoleChageButtonEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				try {
					updateRoleData(view.getPrefRArray().getSelectionModel().getSelectedItem(),view.getCmbPrefRoleChange().getSelectionModel().getSelectedItem());
				} catch (Exception e) {

					e.printStackTrace();
				}
				//view.alertSuccessfuly();

				view.getInputInfoStage().close();	
			}

		};

		EventHandler<ActionEvent> changeRolePrefButtonEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				view.getInputInfoStage().setScene(view.changeRolePref());
				view.changeRolePrefer(getCompany());
				view.saveRoleChangeEvent(saveRoleChageButtonEvent);


			}
		};
		view.addEventToShowRolePrefChange(changeRolePrefButtonEvent);

		EventHandler<ActionEvent> saveDepChangeButtonEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {	
				try {
					updateDepartmentData(view.getPrefDArray().getSelectionModel().getSelectedItem(),view.getCmbPrefDepChange().getSelectionModel().getSelectedItem());
				} catch (Exception e) {

					e.printStackTrace();
				}
				//view.alertSuccessfuly();
				view.getInputInfoStage().close();


			}

		};

		EventHandler<ActionEvent> changeDepPrefButtonEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				view.getInputInfoStage().setScene(view.changeDepPref());
				view.changeDepPrefer(getCompany());
				view.saveDepChangeEvent(saveDepChangeButtonEvent);
			}

		};
		view.addEventToChangeDepPref(changeDepPrefButtonEvent);

		
		//show Result of test in departments and roles with employees
		EventHandler<ActionEvent> showResultsWindowHandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				view.getInputInfoStage().setScene(view.ShowResultsS());
				view.ShowResults(getCompany());
				//view.addEventToShowResults(showResultsWindowHandler);

			}
		};
		view.addEventResults(showResultsWindowHandler);



		//save
		EventHandler<ActionEvent> saveButtonEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					saveCompanyToFile();
				} catch (Exception e) {		
					e.printStackTrace();
				}
				view.getSavedAlert();
				//view.getInputInfoStage().close();
			}
		};
		view.addEventToSaveCompany(saveButtonEvent);
		//	view.addEventToSaveCompany(saveButtonEvent);

		//load
		EventHandler<ActionEvent> loadButtonEvent = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					loadCompanyFromFile();
				} catch (Exception e) {
					getAlertFailed();
					e.printStackTrace();
				}
				view.getLoadAlert();

			}		
		};
		view.addEventToLoadCompany(loadButtonEvent);
	}
	private void getAlertFailed() {
		Alert a = new Alert(AlertType.NONE);
		a.setAlertType(AlertType.INFORMATION);
		a.setTitle("Loading - Failed");
		a.setHeaderText("Could not load from file");
		a.show();	

	}
	private void getAlertNameExistDep() {
		Alert a = new Alert(AlertType.NONE);
		a.setAlertType(AlertType.INFORMATION);
		a.setTitle("Already exsit");
		a.setHeaderText("A department with same name already exsit");
		a.show();
	}
	private void getAlertNameExistRole() {
		Alert a = new Alert(AlertType.NONE);
		a.setAlertType(AlertType.INFORMATION);
		a.setTitle("Already exsit");
		a.setHeaderText("A role with same name already exsit");
		a.show();

	}
	public void sendDataOfDepartment(String depName, String isSync, String isChangeble, String prefer) throws Exception {
		//this.model.createDep(depName, isSync, isChangeble, prefer);
		this.model.addDepartmet(new Department(depName, fromStringToBool(isSync), fromStringToBool(isChangeble), fromStringToType(prefer)));


		//this.model.addDepartmet(new Department(depName, fromStringToBool(isSync), fromStringToBool(isChangeble), fromStringToType(prefer)));
	}
	public void sendDataOfRole(String roleName, String depName, String prefer, String isSync, String isChange) throws Exception {
		this.model.addRole(new Role(roleName, (Department)fromStringToObeject(depName), fromStringToType(prefer), fromStringToBool(isSync), fromStringToBool(isChange)));

	}
	public void sendDataEmployeeHour(String role, String type ,int hourSalary) throws Exception {
		this.model.addEmployee(new EmployeeHourSalary((Role) fromStringToObeject(role), fromStringToType(type) ,hourSalary));
	}
	public void sendDataEmployeeBase(String role, String type, int baseSalary) throws Exception {
		this.model.addEmployee(new EmployeeBaseSalary((Role) fromStringToObeject(role), fromStringToType(type) ,baseSalary));
	}
	public void sendDataEmployeeBaseSales(String role, String type, int baseSalary, int sales) throws Exception {
		this.model.addEmployee(new EmployeeBaseSalaryWithBonus((Role) fromStringToObeject(role), fromStringToType(type), baseSalary, sales));
	}
	public void updateDepartmentData(String depName, String prefer) throws Exception{
		//this.model.updateDep(depInt, prefer, sync, change);
		for (int i = 0; i < this.model.getNumOfDepartments(); i++) {
			if (depName == this.model.getAllDepartments().getCollection().elementAt(i).getDepName()) {
				this.model.getAllDepartments().getCollection().elementAt(i).setDepPref(fromStringToType(prefer));
				this.view.alertSuccessfuly();
			}
		}	

		//this.view.getInputInfoStage().close();
	}
	public void updateRoleData(String roleName, String pref) throws Exception {
		//this.model.updateRole(depInt, pref, sync, change, roleInt);
		for (int i = 0; i < this.model.getNumOfRoles(); i++) {
			if (roleName == this.model.getAllRoles().getCollection().elementAt(i).getRoleName()) {
				this.model.getAllRoles().getCollection().elementAt(i).setRolePref(fromStringToType(pref));
				view.alertSuccessfuly();
			}
		}

		//view.getInputInfoStage();
	}

	public Company getCompany() {
		return this.model;
	}
	public void loadCompanyFromFile() throws Exception {
		ObjectInputStream inFile = new ObjectInputStream(new FileInputStream("Company.dat"));
		Company c = (Company) inFile.readObject();	
		this.model.setNumOfDep(c.getNumOfDepartments());
		this.model.setNumOfRoles(c.getNumOfRoles());
		this.model.setNumOfEmpl(c.getNumOfEmployees());
		this.model.setAllDep(c.getAllDepartments());
		this.model.setAllRoles(c.getAllRoles());
		this.model.setAllEmpl(c.getAllEmployees());
		inFile.close();
		//this.model = new ReadFromFile().readFromFile();
	}
	public void saveCompanyToFile() throws Exception {
		StringBuffer sb =  new StringBuffer();
		this.file = new File("Company.dat");
		ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(this.file));
		outFile.writeObject(this.model);
		outFile.writeObject(sb);
		outFile.close();
	}

	public void callHardCoded() throws Exception{
		//First isSync second isChnagble
		Company c1 = new Company();

		Department d1 = new Department("Graphic design", true,false, Preference.early);
		Department d2 = new Department("Sales", false, false, Preference.dontCare);
		Department d3 = new Department("Programers", true, true, Preference.home);

		c1.addDepartmet(d1);
		c1.addDepartmet(d2);
		c1.addDepartmet(d3);	

		//first isSync second isChangble
		Role r1 = new Role("Artist", d1, Preference.early, false, true);
		Role r2 = new Role("Designer", d1, Preference.regular, true, true);
		Role r3 = new Role("Head Designer", d1, Preference.late, false, true);
		Role r4 = new Role("Sales engineer", d2, Preference.regular, true, false);
		Role r5 = new Role("HelpDesk", d2, Preference.early, false, false);
		Role r6 = new Role("Project Programer", d3, Preference.dontCare, false, true);
		Role r7 = new Role("Programer", d3, Preference.home, false, true);
		Role r8 = new Role("Animation Programer", d3, Preference.dontCare, false, true);

		c1.addRole(r1);
		c1.addRole(r2);
		c1.addRole(r3);
		c1.addRole(r4);
		c1.addRole(r5);
		c1.addRole(r6);
		c1.addRole(r7);
		c1.addRole(r8);

		Employee e1 = new EmployeeBaseSalary(r1, Preference.early, 6400); //d1
		Employee e2 = new EmployeeHourSalary(r2, Preference.home, 35); //d1
		Employee e3 = new EmployeeBaseSalaryWithBonus(r3, Preference.late, 7200, 322); //d1 // last one is number of sales
		Employee e4 = new EmployeeBaseSalary(r4, Preference.regular, 8200); //d2
		Employee e5 = new EmployeeHourSalary(r5, Preference.late,32); //d2
		Employee e6 = new EmployeeBaseSalary(r6, Preference.home,8480); //d3
		Employee e7 = new EmployeeBaseSalaryWithBonus(r7, Preference.regular, 9280, 489); //d3 // last one is number of sales
		Employee e8 = new EmployeeHourSalary(r8, Preference.home,48); //d3

		c1.addEmployee(e1);
		c1.addEmployee(e2);
		c1.addEmployee(e3);
		c1.addEmployee(e4);
		c1.addEmployee(e5);
		c1.addEmployee(e6);
		c1.addEmployee(e7);
		c1.addEmployee(e8);	

		this.model.setNumOfDep(c1.getNumOfDepartments());
		this.model.setNumOfRoles(c1.getNumOfRoles());
		this.model.setNumOfEmpl(c1.getNumOfEmployees());

		this.model.setAllDep(c1.getAllDepartments());
		this.model.setAllRoles(c1.getAllRoles());
		this.model.setAllEmpl(c1.getAllEmployees());

		this.model.setNumOfEff(c1.getNumOfEff());
		this.model.setEff(c1.getEfficiency());
		
	}
	private Object fromStringToObeject(String str) {
		for (int i = 0; i < this.model.getNumOfDepartments(); i++) {
			if (str == this.model.getAllDepartments().getCollection().elementAt(i).getDepName()) {
				Department obj = this.model.getAllDepartments().getCollection().elementAt(i);
				return obj;
			}
		}
		for (int i = 0; i < this.model.getNumOfRoles(); i++) {
			if (str == this.model.getAllRoles().getCollection().elementAt(i).getRoleName()) {
				Role obj = this.model.getAllRoles().getCollection().elementAt(i);
				return obj;
			}
		}
		return null;
	}
	private Preference fromStringToType(String t) {
		if (t == "Early") {
			return Preference.early;
		}else if(t == "Late") {
			return Preference.late;
		}else if(t == "Regular") {
			return Preference.regular;
		}else if(t == "Home") {
			return Preference.home;
		}else if(t == "Doesnt Matter") {
			return Preference.dontCare;
		}
		return null;
	}
	private boolean fromStringToBool(String str) {
		if (str == "Yes") {
			return true;
		}
		return false;
	}
}