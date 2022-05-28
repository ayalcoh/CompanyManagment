package Michael_Kogan_Ayal_Cohen_Project.View;

import Michael_Kogan_Ayal_Cohen_Project.Model.Company;
import Michael_Kogan_Ayal_Cohen_Project.Model.Preference;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CompanyView {
	TextArea depString = new TextArea();
	private ToggleGroup depGrp;
	private ToggleGroup roleGrp;
	private ToggleGroup employeeGruop;
	private Stage inputInfoStage;
	private Scene inputInfoScene;
	private Scene eScene;
	private Scene roleS;
	private Scene employeeS;

	private RadioButton[] dArray; 
	private RadioButton[] rArray;

	private Button[] menuButtons;




	//add all
	private Button addRole;
	private Button addDep;
	private Button addEmpl;

	//private Button confirmEmplo;
	private Button continuePrefDep;
	private Button continuePrefRole;
	//private Button changeRoleBt;
	private Button confirmAddEmBt;
	private Stage primaryStage;
	private Scene primaryScene;
	private Scene depS;
	private Scene RoleS;
	private Group root;
	private Text nameText;
	private ComboBox<String> prefRArray;
	private ComboBox<String> prefDArray;
	private Button confirmAddRoleBt;
	private Button confirmAddDepBt;
	private Button returnBt;


	//show all
	private Scene showAllEmplS;
	private Scene showAllDepS;
	private Scene showAllRoleS;
	private Button showAllDep;
	private Button showAllRole;
	private Button showAllEmpl;

	//Confirm add
	private Button confirmAddRole;
	private Button confirmAddEmpl;
	private Button confirmAddDep;




	//private CompanyModel control;


	//for Dep
	private TextField tfNameDep;
	private ComboBox<String> cmbPrefDep;
	private ComboBox<String> cmbIsSyncDep;
	private ComboBox<String> cmbIsChangeableDep;

	//for role
	private TextField tfNameRole;
	private ComboBox<String> cmbDepName;
	private ComboBox<String> cmbPrefRole;
	private ComboBox<String> cmbIsSyncRole;
	private ComboBox<String> cmbIsChangeableRole;

	//for employee
	private ComboBox<String> cmbRoleEmpl;
	private ComboBox<String> cmbPrefEmpl;
	private Spinner<Integer> employeePerHour;
	private Spinner<Integer> employeeBonus;
	private Spinner<Integer> employeeBase;
	private ToggleGroup emploTypeOfWork;
	private RadioButton RBase;
	private RadioButton RBaseSale;
	private RadioButton RBHour;
	private TextArea taAllDep;
	private TextArea taAllRoles;
	private TextInputControl taAllEmpl;

	//for change role
	private Scene changeRoleS;
	private Button confirmChangeRole;
	private ComboBox<String> cmbPrefRoleChange;

	//for change department
	private Scene changeDepS;
	private Button confirmChangeDep;
	private ComboBox<String> cmbPrefDepChange;
	private Scene showResultsS;
	private TextArea showRes;


	public CompanyView (Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.root = new Group();


		this.primaryScene = new Scene(root, 640, 400);


		Text title = new Text("Please select an option");
		title.setTranslateX(170);
		title.setTranslateY(31);
		title.setStyle("-fx-font: 25 arial;");
		title.setStroke(Color.BROWN);
		title.setFill(Color.BLACK);

		menuButtons = new Button[7];
		menuButtons[0] = new Button("Add Entities");
		menuButtons[0].setPrefSize(119, 35);
		menuButtons[0].setTranslateX(149);
		menuButtons[0].setTranslateY(61);
		menuButtons[1] = new Button("Show Entities");
		menuButtons[1].setPrefSize(119, 35);
		menuButtons[1].setTranslateX(330);
		menuButtons[1].setTranslateY(61);
		menuButtons[2] = new Button("Change Role Preference");
		menuButtons[2].setPrefSize(239, 41);
		menuButtons[2].setTranslateX(35);
		menuButtons[2].setTranslateY(142);
		menuButtons[3] = new Button("Change Department Preference");
		menuButtons[3].setPrefSize(239, 41);
		menuButtons[3].setTranslateX(327);
		menuButtons[3].setTranslateY(142);
		menuButtons[4] = new Button("Show Results");
		menuButtons[4].setPrefSize(200, 100);
		menuButtons[4].setTranslateX(200);
		menuButtons[4].setTranslateY(230);
		menuButtons[5] = new Button("Save");
		menuButtons[5].setPrefSize(90, 50);
		menuButtons[5].setTranslateX(410);
		menuButtons[5].setTranslateY(273);	
		menuButtons[6] = new Button("Load");
		menuButtons[6].setPrefSize(90, 50);
		menuButtons[6].setTranslateX(100);
		menuButtons[6].setTranslateY(270);


		root.getChildren().addAll(menuButtons);
		root.getChildren().add(title);


		this.primaryStage.setTitle("Ayal's and Michael's Project");
		this.primaryStage.setScene(primaryScene);
		this.primaryStage.show();


	}

	public void addEntities() {
		inputInfoStage = new Stage();
		inputInfoStage.setTitle("Input Entites information");
		Group companyPopWindow = new Group();
		VBox vb = new VBox();



		addDep = new Button("Add department");
		addDep.setTranslateX(200);
		addDep.setTranslateY(150);
		addDep.setPrefSize(200, 40);

		addEmpl = new Button("Add Employee");
		addEmpl.setTranslateX(200);
		addEmpl.setTranslateY(160);
		addEmpl.setPrefSize(200, 40);

		addRole = new Button("Add Role");
		addRole.setTranslateX(200);
		addRole.setTranslateY(170);
		addRole.setPrefSize(200, 40);

		//	addDep.disableProperty().bind(tfNameField.textProperty().isEmpty().or(tfNameField.textProperty().isEqualTo("[a-Az-Z)]+")));

		vb.getChildren().addAll(addDep,addEmpl,addRole);
		companyPopWindow.getChildren().add(vb);
		inputInfoScene = new Scene(companyPopWindow, 620, 350);
		inputInfoStage.setScene(inputInfoScene);
		inputInfoStage.show();

	}

	public void addDepartment(Company company) {
		Group depPopWindow = new Group();
		Text depInfo = new Text("Input department information");
		depInfo.setTranslateX(50);
		depInfo.setTranslateY(40);

		inputInfoStage.setTitle("Input Entites department information");
		HBox rHb = new HBox();
		HBox markBoxHb = new HBox();
		HBox rHb2 = new HBox();
		HBox rHb3 = new HBox();
		//VBox vb = new VBox();

		markBoxHb.setTranslateX(200);
		markBoxHb.setTranslateY(35);

		rHb.setTranslateX(200);
		rHb.setTranslateY(120);

		rHb2.setTranslateX(200);
		rHb2.setTranslateY(70);

		rHb3.setTranslateX(50);
		rHb3.setTranslateY(170);


		Label lName = new Label("Enter department name:");
		lName.setTranslateX(10);
		lName.setTranslateY(30);

		tfNameDep = new TextField();
		tfNameDep.setTranslateX(20);
		tfNameDep.setTranslateY(30);

		cmbIsSyncDep = new ComboBox<String>();
		cmbIsChangeableDep = new ComboBox<String>();
		cmbPrefDep = new ComboBox<String>();
		cmbIsSyncDep.getItems().add("Yes");
		cmbIsSyncDep.getItems().add("No");
		cmbIsChangeableDep.getItems().add("Yes");
		cmbIsChangeableDep.getItems().add("No");
		for (int i = 0; i < Preference.values().length; i++) {
			cmbPrefDep.getItems().add(getStringFromType(Preference.values()[i]));
		}


		Label isSync = new Label("Is sync? ");
		Label isChangable = new Label("Is changeable? ");
		Label Pref = new Label("What is your department preference? ");

		isSync.setTranslateX(50);
		isSync.setTranslateY(30);
		cmbIsSyncDep.setTranslateX(107);
		cmbIsSyncDep.setTranslateY(30);

		isChangable.setTranslateX(50);
		isChangable.setTranslateY(30);
		cmbIsChangeableDep.setTranslateX(70);
		cmbIsChangeableDep.setTranslateY(30);

		Pref.setTranslateX(50);
		Pref.setTranslateY(30);
		cmbPrefDep.setTranslateX(70);
		cmbPrefDep.setTranslateY(30);

		confirmAddDep = new Button("Confirm");
		confirmAddDep.setTranslateX(215);
		confirmAddDep.setTranslateY(300);
		confirmAddDep.setPrefSize(250,40);

		confirmAddDep.disableProperty().bind(tfNameDep.textProperty().isEmpty().or(tfNameDep.textProperty().isEqualTo("[a-z A-Z)]+")).or(cmbIsSyncDep.valueProperty().isNull()).
				or(cmbIsChangeableDep.valueProperty().isNull()).or(cmbPrefDep.valueProperty().isNull()));


		markBoxHb.getChildren().addAll(lName,tfNameDep);
		rHb.getChildren().addAll(isSync,cmbIsSyncDep);
		rHb2.getChildren().addAll(isChangable,cmbIsChangeableDep);
		rHb3.getChildren().addAll(Pref,cmbPrefDep);

		depPopWindow.getChildren().addAll(depInfo,rHb3,rHb2,rHb,markBoxHb,confirmAddDep);
		depS = new Scene(depPopWindow,660,390);
		inputInfoStage.setScene(depS);
		inputInfoStage.show();
	}



	private String getStringFromType(Preference preference) {
		if (preference == Preference.early) {
			return "Early";
		}else if(preference == Preference.late) {
			return "Late";
		}else if(preference == Preference.regular) {
			return "Regular";
		}else if(preference == Preference.home) {
			return "Home";
		}else if(preference == Preference.dontCare) {
			return "Doesnt Matter";
		}
		return null;
	}

	public void addEmployee(Company c1) {
		Group employeePopWindow = new Group();

		Text employeeInfo = new Text("Please Enter emplyoee information");
		employeeInfo.setTranslateX(200);
		employeeInfo.setTranslateY(40);

		inputInfoStage.setTitle("Add Employee");
		HBox markBoxHb = new HBox();
		HBox rHb = new HBox();
		VBox vb = new VBox();

		markBoxHb.setPadding(new Insets(15, 11, 15, 11));
		markBoxHb.setSpacing(12);
		rHb.setPadding(new Insets(15, 11, 15, 11));
		rHb.setSpacing(12);


		vb.setTranslateX(140);
		vb.setTranslateY(50);
		rHb.setTranslateY(100);

		Label lName = new Label("Choose role: ");
		lName.setTranslateX(10);
		lName.setTranslateY(30);

		cmbRoleEmpl = new ComboBox<String>();
		for (int i = 0; i < c1.getNumOfRoles() ; i++) {
			cmbRoleEmpl.getItems().add(c1.getAllRoles().getCollection().elementAt(i).getRoleName());
		}
		cmbRoleEmpl.setTranslateX(-190);
		cmbRoleEmpl.setTranslateY(50);

		Label lPref = new Label("Choose preference: ");
		lPref.setTranslateX(120);
		lPref.setTranslateY(30);
		cmbPrefEmpl = new ComboBox<String>();
		for (int i = 0; i < Preference.values().length-1; i++) {
			cmbPrefEmpl.getItems().add(getStringFromType(Preference.values()[i]));
		}

		cmbPrefEmpl.setTranslateX(-145);
		cmbPrefEmpl.setTranslateY(50);


		emploTypeOfWork = new ToggleGroup();

		RBase = new RadioButton("Base Employee");
		RBase.setToggleGroup(emploTypeOfWork);

		RBaseSale = new RadioButton("Base+Bonus Employee");
		RBaseSale.setToggleGroup(emploTypeOfWork);

		RBHour = new RadioButton("Hourly Employee");
		RBHour.setToggleGroup(emploTypeOfWork);

		Text txBase = new Text("What is your base salary?");
		Text txBonux = new Text("How many Sales?");
		Text txHourly = new Text("What is your hourly salary?");

		employeeBase = new Spinner<>(5500, 12000, 6000, 150);
		employeeBonus = new Spinner<>(0, 1500, 150, 50);
		employeePerHour = new Spinner<>(1, 80, 1);

		HBox bonus = new HBox();
		HBox perHour = new HBox();
		HBox base = new HBox();

		bonus.getChildren().addAll(txBonux, employeeBonus);
		perHour.getChildren().addAll(txHourly, employeePerHour);
		base.getChildren().addAll(txBase,employeeBase);

		RBase.selectedProperty()
		.addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
			if (new_val == true)
				vb.getChildren().addAll(base);
			else {
				vb.getChildren().removeAll(base);
			}
		});

		RBaseSale.selectedProperty()
		.addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
			if (new_val == true)
				vb.getChildren().addAll(bonus,base);
			else {
				vb.getChildren().removeAll(bonus,base);
			}
		});

		RBHour.selectedProperty()
		.addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
			if (new_val == true)
				vb.getChildren().addAll(perHour);
			else {
				vb.getChildren().removeAll(perHour,bonus,base);
			}
		});




		confirmAddEmpl = new Button("Confirm");
		confirmAddEmpl.setTranslateX(215);
		confirmAddEmpl.setTranslateY(300);
		confirmAddEmpl.setPrefSize(250,40);

		confirmAddEmpl.disableProperty().bind(cmbRoleEmpl.valueProperty().isNull().or(cmbPrefEmpl.valueProperty().isNull()));
		markBoxHb.getChildren().addAll(lName,lPref,cmbRoleEmpl,cmbPrefEmpl);
		rHb.getChildren().addAll(RBase,RBaseSale,RBHour);
		vb.getChildren().addAll(markBoxHb,rHb);
		employeePopWindow.getChildren().addAll(employeeInfo,vb,confirmAddEmpl);
		RBase.setSelected(true);
		employeeS = new Scene(employeePopWindow,660,390);
		inputInfoStage.setScene(employeeS);
		inputInfoStage.show();

	}


	public void addRole(Company c1) {
		Group rolePopWindow = new Group();
		Text informationRole = new Text("Please enter role information");
		informationRole.setTranslateX(200);
		informationRole.setTranslateY(40);

		inputInfoStage.setTitle("Please enter role info entites");
		HBox markBoxHb = new HBox();
		HBox rHb = new HBox();
		HBox rHb2 = new HBox();
		HBox rHb3 = new HBox();
		HBox rHb4 = new HBox();
		VBox vb = new VBox();


		Label lName = new Label("Role name: ");
		lName.setTranslateX(10);
		lName.setTranslateY(10);

		tfNameRole = new TextField();
		tfNameRole.setTranslateX(42);
		tfNameRole.setTranslateY(10);



		Label ldepName = new Label("Chose Department: ");
		cmbDepName = new ComboBox<String>();
		for (int i = 0; i < c1.getNumOfDepartments(); i++) {
			cmbDepName.getItems().add(c1.getAllDepartments().getCollection().elementAt(i).getDepName());
		}
		ldepName.setTranslateX(10);
		ldepName.setTranslateY(35);
		cmbDepName.setTranslateX(20);
		cmbDepName.setTranslateY(30);

		Label lPref = new Label("Choose preference: ");
		lPref.setTranslateX(10);
		lPref.setTranslateY(35);
		cmbPrefRole = new ComboBox<String>();
		for (int i = 0; i < Preference.values().length; i++) {
			cmbPrefRole.getItems().add(getStringFromType(Preference.values()[i]));
		}
		cmbPrefRole.setTranslateX(20);
		cmbPrefRole.setTranslateY(30);

		Label lIsSync = new Label("Is Sync? ");

		lIsSync.setTranslateX(120);
		lIsSync.setTranslateY(20);

		Label lIsChange = new Label("Is Changeble? ");
		lIsChange.setTranslateX(120);
		lIsChange.setTranslateY(25);

		cmbIsSyncRole = new ComboBox<String>();
		cmbIsChangeableRole = new ComboBox<String>();
		cmbIsSyncRole.getItems().add("Yes");
		cmbIsSyncRole.getItems().add("No");
		cmbIsChangeableRole.getItems().add("Yes");
		cmbIsChangeableRole.getItems().add("No");

		cmbIsSyncRole.setTranslateX(160);
		cmbIsSyncRole.setTranslateY(20);
		cmbIsChangeableRole.setTranslateX(128);
		cmbIsChangeableRole.setTranslateY(20);

		confirmAddRole = new Button("Confirm");
		confirmAddRole.setTranslateX(215);
		confirmAddRole.setTranslateY(300);
		confirmAddRole.setPrefSize(250,40);

		confirmAddRole.disableProperty().bind(tfNameRole.textProperty().isEmpty().or(tfNameRole.textProperty().isEqualTo("[a-z A-Z)]+")).or(cmbDepName.valueProperty().isNull())
				.or(cmbPrefRole.valueProperty().isNull()).or(cmbIsSyncRole.valueProperty().isNull()).or(cmbIsChangeableRole.valueProperty().isNull()));


		//markBoxHb.setPadding(new Insets(15, 11, 15, 11));
		//markBoxHb.setSpacing(12);
		rHb.setPadding(new Insets(15, 11, 15, 11));
		rHb.setSpacing(12);

		//markBoxHb.setTranslateX(20);
		markBoxHb.setTranslateY(-85);

		rHb2.setTranslateY(20);
		rHb3.setTranslateX(-78);
		rHb3.setTranslateY(45);
		rHb4.setTranslateX(-78);
		rHb4.setTranslateY(50);

		vb.setTranslateX(140);
		vb.setTranslateY(50);
		rHb.setTranslateY(5);

		rHb.getChildren().addAll(lName,tfNameRole);
		markBoxHb.getChildren().addAll(ldepName,cmbDepName);
		rHb2.getChildren().addAll(lPref, cmbPrefRole);
		rHb3.getChildren().addAll(lIsSync, cmbIsSyncRole);
		rHb4.getChildren().addAll(lIsChange, cmbIsChangeableRole);

		//markBoxHb.getChildren().addAll(b1,b2,b3,b4);
		vb.getChildren().addAll(rHb, rHb2, rHb3, rHb4, markBoxHb);
		rolePopWindow.getChildren().addAll(informationRole, vb,confirmAddRole);
		roleS = new Scene(rolePopWindow,660,390);
		inputInfoStage.setScene(roleS);
		inputInfoStage.show();			
	}


	public void entitiesWindow() throws Exception {
		inputInfoStage = new Stage();
		inputInfoStage.setTitle("Show Entites information");
		Group showEntitiesPopWindow = new Group();
		VBox vb = new VBox();

		showAllDep = new Button("Show all Departments");
		showAllDep.setTranslateX(200);
		showAllDep.setTranslateY(50);
		showAllDep.setPrefSize(200, 40);

		showAllRole = new Button("Show all Roles");
		showAllRole.setTranslateX(200);
		showAllRole.setTranslateY(100);
		showAllRole.setPrefSize(200, 40);

		showAllEmpl = new Button("Show all Employees");
		showAllEmpl.setTranslateX(200);
		showAllEmpl.setTranslateY(150);
		showAllEmpl.setPrefSize(200, 40);

		vb.setTranslateX(30);
		vb.setTranslateY(35);


		vb.getChildren().addAll(showAllDep,showAllRole,showAllEmpl);
		showEntitiesPopWindow.getChildren().addAll(vb);


		inputInfoScene = new Scene(showEntitiesPopWindow, 650, 380);
		inputInfoStage.setScene(inputInfoScene);
		inputInfoStage.show();	
	}

	//	public void showRolePrefChange(Company c) {
	//		inputInfoStage = new Stage();
	//		inputInfoStage.setTitle("Choose which role to change preference");
	//
	//		Group entitesPopWindow = new Group();
	//		VBox vb = new VBox();
	//		VBox rVb = new VBox();
	//		prefRArray = new Vector<RadioButton>();
	//
	//		Line l = new Line(0,1,600,2);
	//		entitesPopWindow.getChildren().add(l);
	//
	//		for (int i = 0; i < c.getAllDepartments().getSize(); i++) {
	//			for (int j = 0; j < c.getAllDepartments().getCollection().elementAt(i).getRoles().getSize(); j++) {
	//				if (c.getAllDepartments().getCollection().elementAt(i).getRoles().getCollection().elementAt(j).isChangeble() == true) {
	//					RadioButton tempRadioButton = new RadioButton(
	//							c.getAllDepartments().getCollection().elementAt(i).getRoles().getCollection().elementAt(j).getClass().getSimpleName() + " number "
	//									+ (j + 1) + " (of department number " + (i + 1) + ")");
	//					tempRadioButton.setToggleGroup(roleGrp);
	//					prefRArray.add(tempRadioButton);
	//				}
	//
	//			}
	//		}
	//
	//
	//		if(prefRArray.size() == 0) {
	//			Alert none = new Alert(AlertType.NONE);
	//			none.setAlertType(AlertType.ERROR);
	//			none.setContentText("No roles to change");
	//			none.show();
	//			return;
	//		}
	//
	//		continuePrefRole = new Button("Click to Continue");
	//		continuePrefRole.setTranslateX(215);
	//		continuePrefRole.setTranslateY(300);
	//		continuePrefRole.setPrefSize(250,40);
	//
	//		rArray = prefRArray.toArray(new RadioButton[0]);
	//		rVb.getChildren().addAll(rArray);
	//		vb.getChildren().addAll(rVb);
	//		entitesPopWindow.getChildren().addAll(continuePrefRole, vb);
	//
	//		inputInfoScene = new Scene(entitesPopWindow, 660, 390);
	//		inputInfoStage.setScene(inputInfoScene);
	//		inputInfoStage.show();
	//	}

	public void changeDepPrefer(Company c1) {
		inputInfoStage = new Stage();
		inputInfoStage.setTitle("Choose which deparment to change preference");

		Group entitesPopWindow = new Group();
		VBox vb = new VBox();
		HBox markHb = new HBox();
		HBox rHb = new HBox();

		markHb.setTranslateX(50);
		markHb.setTranslateY(20);
		rHb.setTranslateX(50);
		rHb.setTranslateY(10);
		vb.setTranslateY(100);


		Label lDepName = new Label("Choose department: ");
		lDepName.setTranslateX(100);
		lDepName.setTranslateY(0);

		prefDArray = new ComboBox<String>();
		for (int i = 0; i < c1.getNumOfDepartments(); i++) {
			if (c1.getAllDepartments().getCollection().elementAt(i).isChangeble() == true) {
				prefDArray.getItems().add(c1.getAllDepartments().getCollection().elementAt(i).getDepName());
			}
		}

		Label lPref = new Label("Choose preference: ");
		lPref.setTranslateX(100);
		lPref.setTranslateY(0);


		if (prefDArray.getItems().size() == 0) {
			Alert none = new Alert(AlertType.NONE);
			none.setAlertType(AlertType.ERROR);
			none.setContentText("No departments to change");
			none.show();
			inputInfoStage.close();
			return;
		}

		prefDArray.setTranslateX(105);
		prefDArray.setTranslateY(-5);
		cmbPrefDepChange = new ComboBox<String>();
		for (int i = 0; i < Preference.values().length; i++) {
			cmbPrefDepChange.getItems().add(getStringFromType(Preference.values()[i]));
		}

		cmbPrefDepChange.setTranslateX(105);
		cmbPrefDepChange.setTranslateY(-3);

		confirmChangeDep = new Button("Click to Continue");
		confirmChangeDep.setTranslateX(215);
		confirmChangeDep.setTranslateY(300);
		confirmChangeDep.setPrefSize(250,40);

		confirmChangeDep.disableProperty().bind(prefDArray.valueProperty().isNull().or(cmbPrefDepChange.valueProperty().isNull()));

		markHb.getChildren().addAll(lPref,cmbPrefDepChange);
		rHb.getChildren().addAll(lDepName,prefDArray);
		vb.getChildren().addAll(rHb,markHb);
		entitesPopWindow.getChildren().addAll(vb, confirmChangeDep );

		changeDepS = new Scene(entitesPopWindow, 660, 390);
		inputInfoStage.setScene(changeDepS);
		inputInfoStage.show();

	}

	public void changeRolePrefer(Company c) {
		inputInfoStage = new Stage();
		inputInfoStage.setTitle("Choose which role to change preference");

		Group entitesPopWindow1 = new Group();
		VBox vb = new VBox();
		HBox markHb = new HBox();
		HBox rHb = new HBox();

		markHb.setTranslateX(50);
		markHb.setTranslateY(20);
		rHb.setTranslateX(50);
		rHb.setTranslateY(10);
		vb.setTranslateY(100);

		Label lDepName = new Label("Choose Role: ");
		lDepName.setTranslateX(100);
		lDepName.setTranslateY(0);

		prefRArray = new ComboBox<String>();
		for (int i = 0; i < c.getNumOfRoles(); i++) {
			if (c.getAllRoles().getCollection().elementAt(i).isChangeble() == true) {
				prefRArray.getItems().add(c.getAllRoles().getCollection().elementAt(i).getRoleName());
			}
		}


		if(prefRArray.getItems().size() == 0) {
			Alert none = new Alert(AlertType.NONE);
			none.setAlertType(AlertType.ERROR);
			none.setContentText("No roles to change");
			none.show();
			return;
		}

		prefRArray.setTranslateX(105);
		prefRArray.setTranslateY(-5);

		Label lPref = new Label("Choose preference: ");
		lPref.setTranslateX(100);
		lPref.setTranslateY(0);

		cmbPrefRoleChange = new ComboBox<String>();
		for (int i = 0; i < Preference.values().length; i++) {
			cmbPrefRoleChange.getItems().add(getStringFromType(Preference.values()[i]));
		}

		cmbPrefRoleChange.setTranslateX(105);
		cmbPrefRoleChange.setTranslateY(-3);

		confirmChangeRole = new Button("Click to Continue");
		confirmChangeRole.setTranslateX(215);
		confirmChangeRole.setTranslateY(300);
		confirmChangeRole.setPrefSize(250,40);

		confirmChangeRole.disableProperty().bind(prefRArray.valueProperty().isNull().or(cmbPrefRoleChange.valueProperty().isNull()));



		markHb.getChildren().addAll(lPref,cmbPrefRoleChange);
		rHb.getChildren().addAll(lDepName,prefRArray);
		vb.getChildren().addAll(rHb,markHb);
		entitesPopWindow1.getChildren().addAll(vb,confirmChangeRole);

		changeRoleS = new Scene(entitesPopWindow1, 660, 390);
		inputInfoStage.setScene(changeRoleS);
		inputInfoStage.show();
	}

	public ComboBox<String> getCmbPrefRoleChange() {
		return cmbPrefRoleChange;
	}

	public ComboBox<String> getCmbPrefDepChange() {
		return cmbPrefDepChange;
	}

	public Scene changeRolePref() {
		return changeRoleS;
	}
	public Scene changeDepPref() {
		return changeDepS;	
	}



	public Scene showAllRole() {
		return showAllRoleS;
	}

	public Scene showAllDep() {
		return showAllDepS;
	}


	public Scene showAllEmpl() {
		return showAllEmplS;
	}


	public Stage getInputInfoStage() {
		return inputInfoStage;
	}

	public Scene getScene() {
		return eScene;
	}

	public Scene getDepS() {
		return depS;
	}

	public Scene getRoleS() {
		return RoleS;
	}
	public Scene getEmpl() {
		return employeeS;
	}

	public void addEventContinueBt(EventHandler<ActionEvent> v1, EventHandler<ActionEvent> v2,
			EventHandler<ActionEvent> v3, EventHandler<ActionEvent> v4) {
		confirmAddEmBt.setOnAction(v1);
		confirmAddRoleBt.setOnAction(v2);
		confirmAddDepBt.setOnAction(v3);
		returnBt.setOnAction(v4);

	}


	public void addEventToAddEntities(EventHandler<ActionEvent> event) {
		menuButtons[0].setOnAction(event);
	}

	public void addEventToEntitesWindow(EventHandler<ActionEvent> event) {
		menuButtons[1].setOnAction(event);
	}

	public void addEventToShowRolePrefChange(EventHandler<ActionEvent> event) {
		menuButtons[2].setOnAction(event);
	}

	public void addEventToChangeDepPref(EventHandler<ActionEvent> event) {
		menuButtons[3].setOnAction(event);
	}
	public void addEventResults(EventHandler<ActionEvent> event) {
		menuButtons[4].setOnAction(event);
	}

	public void addEventToAddDepartment(EventHandler<ActionEvent> event) {
		addDep.setOnAction(event);
	}

	public void addEventToAddRole(EventHandler<ActionEvent> event) {
		addRole.setOnAction(event);
	}

	public void addEventToAddEmployee(EventHandler<ActionEvent> event) {
		addEmpl.setOnAction(event);
	}

	//	public void addEventToSubmitEmployee(EventHandler<ActionEvent> event) {
	//		confirmEmplo.setOnAction(event);
	//	}

	public void addEventContinueDepPrefBt(EventHandler<ActionEvent> event) {
		continuePrefDep.setOnAction(event);
	}

	public void addEventContinueRolePrefBt(EventHandler<ActionEvent> event) {
		continuePrefRole.setOnAction(event);
	}

	public void saveRoleChangeEvent(EventHandler<ActionEvent> event) {
		confirmChangeRole.setOnAction(event);

	}
	public void saveDepChangeEvent(EventHandler<ActionEvent> event) {
		confirmChangeDep.setOnAction(event);
	}

	public ComboBox<String> getPrefRArray() {
		return prefRArray;
	}

	public ComboBox<String> getPrefDArray() {
		return prefDArray;
	}

	public void alertSuccessfuly() {
		Alert a = new Alert(AlertType.NONE);
		a.setAlertType(AlertType.INFORMATION);
		a.setTitle("Success");
		a.setContentText("Preference edited successfuly.");		
		a.show();
	}

	public void addEventToSaveCompany(EventHandler<ActionEvent> saveButtonEvent) {
		menuButtons[5].setOnAction(saveButtonEvent);
	}

	public void addEventToLoadCompany(EventHandler<ActionEvent> loadButtonEvent) {
		menuButtons[6].setOnAction(loadButtonEvent);
	}

	public void addEventToShowAllDep(EventHandler<ActionEvent> showDepartmentsButtonEvent) {
		showAllDep.setOnAction(showDepartmentsButtonEvent);

	}

	public void addEventToShowAllRoles(EventHandler<ActionEvent> showRolesButtonEvent) {
		showAllRole.setOnAction(showRolesButtonEvent);

	}

	public void addEventToShowAllEmployees(EventHandler<ActionEvent> showEmployeesButtonEvent) {
		showAllEmpl.setOnAction(showEmployeesButtonEvent);

	}

	public void confirmAddDepartment(EventHandler<ActionEvent> event)  {
		confirmAddDep.setOnAction(event);
		//		m.createDep(tfNameDep.getText(), cmbIsSyncDep.getSelectionModel().getSelectedItem(), cmbIsChangeableDep.getSelectionModel().getSelectedItem()
		//				, cmbPrefDep.getSelectionModel().getSelectedItem());
		//		
	}

	public void confirmAddEmployee(EventHandler<ActionEvent> event) {
		confirmAddEmpl.setOnAction(event);
		//				if (emploTypeOfWork.getSelectedToggle().equals(getTogeleBase())) {
		//					m.createEmployeeBase(cmbRoleEmpl.getSelectionModel().getSelectedItem(), cmbPrefEmpl.getSelectionModel().getSelectedItem(), employeeBase.getValue());
		//				}else if (emploTypeOfWork.getSelectedToggle().equals(b6)) {
		//					m.createEmployeeBaseSales(cmbRoleEmpl.getSelectionModel().getSelectedItem(), cmbPrefEmpl.getSelectionModel().getSelectedItem(), 
		//							employeeBase.getValue(), employeeBonus.getValue());
		//				}else if(emploTypeOfWork.getSelectedToggle().equals(b7)) {
		//					m.createEmployeeHour(cmbRoleEmpl.getSelectionModel().getSelectedItem(), cmbPrefEmpl.getSelectionModel().getSelectedItem(), 
		//							employeePerHour.getValue());
		//		}
	}

	public void confirmAddRole(EventHandler<ActionEvent> event) {
		confirmAddRole.setOnAction(event);
		//		m.createRole(tfNamedRole.getText(), cmbDepName.getSelectionModel().getSelectedItem(), cmbPrefRole.getSelectionModel().getSelectedItem(), 
		//				cmbIsSyncRole.getSelectionModel().getSelectedItem(), cmbIsChangeableRole.getSelectionModel().getSelectedItem());
	}

	public void showAllDepartments(Company c1) {
		Group allDep = new Group();
		VBox vb = new VBox();

		taAllDep = new TextArea();
		taAllDep.appendText(c1.showAllDepartments());

		vb.getChildren().addAll(taAllDep);
		allDep.getChildren().addAll(vb);
		inputInfoScene = new Scene(allDep,480,185);
		inputInfoStage.setScene(inputInfoScene);
		inputInfoStage.show();


	}


	public void showAllRoles(Company c1) {
		Group allRoles = new Group();
		VBox vb = new VBox();

		taAllRoles = new TextArea();
		taAllRoles.appendText(c1.showAllRoles());

		vb.getChildren().addAll(taAllRoles);
		allRoles.getChildren().addAll(vb);
		inputInfoScene = new Scene(allRoles,480,185);
		inputInfoStage.setScene(inputInfoScene);
		inputInfoStage.show();

	}


	public void showAllEmployees(Company c1) {
		Group allEmpl = new Group();
		VBox vb = new VBox();

		taAllEmpl = new TextArea();
		taAllEmpl.appendText(c1.showAllEmployees());

		vb.getChildren().addAll(taAllEmpl);
		allEmpl.getChildren().addAll(vb);
		inputInfoScene = new Scene(allEmpl,480,185);
		inputInfoStage.setScene(inputInfoScene);
		inputInfoStage.show();


	}

	public TextArea getDepString() {
		return depString;
	}

	public ToggleGroup getDepGrp() {
		return depGrp;
	}

	public ToggleGroup getRoleGrp() {
		return roleGrp;
	}

	public ToggleGroup getEmployeeGruop() {
		return employeeGruop;
	}

	public Scene getInputInfoScene() {
		return inputInfoScene;
	}

	public Scene geteScene() {
		return eScene;
	}

	public Scene getEmployeeS() {
		return employeeS;
	}

	public RadioButton[] getdArray() {
		return dArray;
	}

	public RadioButton[] getrArray() {
		return rArray;
	}

	public Button[] getMenuButtons() {
		return menuButtons;
	}

	public Button getShowAllDep() {
		return showAllDep;
	}

	public Button getShowAllRole() {
		return showAllRole;
	}

	public Button getShowAllEmpl() {
		return showAllEmpl;
	}

	public Button getAddRole() {
		return addRole;
	}

	public Button getAddDep() {
		return addDep;
	}

	public Button getAddEmpl() {
		return addEmpl;
	}

	//	public Button getConfirmEmplo() {
	//		return confirmEmplo;
	//	}

	public Button getContinuePrefDep() {
		return continuePrefDep;
	}

	public Button getContinuePrefRole() {
		return continuePrefRole;
	}

	//	public Button getChangeRoleBt() {
	//		return changeRoleBt;
	//	}

	public Button getConfirmAddEmBt() {
		return confirmAddEmBt;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public Scene getPrimaryScene() {
		return primaryScene;
	}

	public Group getRoot() {
		return root;
	}

	public Text getNameText() {
		return nameText;
	}

	public Button getConfirmAddRoleBt() {
		return confirmAddRoleBt;
	}

	public Button getConfirmAddDepBt() {
		return confirmAddDepBt;
	}

	public Button getReturnBt() {
		return returnBt;
	}

	public Scene getShowAllEmplS() {
		return showAllEmplS;
	}

	public Scene getShowAllDepS() {
		return showAllDepS;
	}

	public Scene getShowAllRoleS() {
		return showAllRoleS;
	}

	public Button getConfirmAddRole() {
		return confirmAddRole;
	}

	public Button getConfirmAddEmpl() {
		return confirmAddEmpl;
	}

	public Button getConfirmAddDep() {
		return confirmAddDep;
	}

	//	public CompanyModel getM() {
	//		return control;
	//	}

	public TextField getTfNameDep() {
		return tfNameDep;
	}

	public ComboBox<String> getCmbPrefDep() {
		return cmbPrefDep;
	}

	public ComboBox<String> getCmbIsSyncDep() {
		return cmbIsSyncDep;
	}

	public ComboBox<String> getCmbIsChangeableDep() {
		return cmbIsChangeableDep;
	}

	public TextField getTfNameRole() {
		return tfNameRole;
	}

	public ComboBox<String> getCmbDepName() {
		return cmbDepName;
	}

	public ComboBox<String> getCmbPrefRole() {
		return cmbPrefRole;
	}

	public ComboBox<String> getCmbIsSyncRole() {
		return cmbIsSyncRole;
	}

	public ComboBox<String> getCmbIsChangeableRole() {
		return cmbIsChangeableRole;
	}

	public ComboBox<String> getCmbRoleEmpl() {
		return cmbRoleEmpl;
	}

	public ComboBox<String> getCmbPrefEmpl() {
		return cmbPrefEmpl;
	}

	public Spinner<Integer> getEmployeePerHour() {
		return employeePerHour;
	}

	public Spinner<Integer> getEmployeeBonus() {
		return employeeBonus;
	}

	public Spinner<Integer> getEmployeeBase() {
		return employeeBase;
	}

	public ToggleGroup getEmploTypeOfWork() {
		return emploTypeOfWork;
	}
	public RadioButton getTogeleBase() {
		return RBase;
	}
	public RadioButton getTogeleBasaSale() {
		return RBaseSale;
	}
	public RadioButton getTogeleHour() {
		return RBHour;
	}

	public void alertCompanyIsEmpty() {
		Alert a = new Alert(AlertType.NONE);
		a.setAlertType(AlertType.INFORMATION);
		a.setTitle("Company is Empty");
		a.setContentText("Add Entities First"); 		
		a.show();	
	}

	public void getLoadAlert() {
		Alert a = new Alert(AlertType.NONE);
		a.setAlertType(AlertType.INFORMATION);
		a.setTitle("Loaded - Success");
		a.setHeaderText("Your company has been successfully loaded from the file"); 
		a.show();

	}

	public void getSavedAlert() {
		Alert a = new Alert(AlertType.NONE);
		a.setAlertType(AlertType.INFORMATION);
		a.setTitle("Saved");
		a.setContentText("Company saved to file.");		
		a.show();

	}

	public Scene ShowResultsS() {
		return showResultsS;
	}

	public void ShowResults(Company c) {	
		Group showResG = new Group();
		VBox vb = new VBox();

		showRes = new TextArea();
		showRes.appendText(c.showResult());

		vb.getChildren().addAll(showRes);
		showResG.getChildren().addAll(vb);
		inputInfoScene = new Scene(showResG,480,185);
		inputInfoStage.setScene(inputInfoScene);
		inputInfoStage.show();		
	}



	//	public void confirmWindow() {
	//
	//		Group confirmWindow = new Group();
	//		Text employeeAdded = new Text("We added new Employee");
	//		employeeAdded.setTranslateX(10);
	//		employeeAdded.setTranslateY(40);
	//
	//		inputInfoStage.setTitle("Choose an option");
	//		Line l = new Line(0,1,600,2);
	//		confirmWindow.getChildren().add(l);
	//
	//		VBox vb = new VBox();
	//		HBox hb = new HBox();
	//		HBox hb2 = new HBox();
	//
	//		hb.setPadding(new Insets(15, 11, 15, 11));
	//		hb.setSpacing(12);
	//		hb2.setPadding(new Insets(15, 11, 15, 11));
	//		hb2.setSpacing(12);
	//
	//		vb.setTranslateX(35);
	//		vb.setTranslateY(65);
	//
	//		confirmAddEmBt = new Button("Click to add another employee in current company");
	//		confirmAddEmBt.setPrefSize(270, 55);
	//
	//		confirmAddRoleBt = new Button("Click to add another role in current company");
	//		confirmAddRoleBt.setPrefSize(270,55);
	//
	//		confirmAddDepBt = new Button("Click to add new department in current company");
	//		confirmAddDepBt.setPrefSize(270, 55);
	//
	//		returnBt = new Button("Ive done, return to main menu");
	//		returnBt.setPrefSize(270, 55);
	//
	//		hb.getChildren().addAll(confirmAddEmBt, confirmAddRoleBt);
	//		hb2.getChildren().addAll(confirmAddDepBt,returnBt);
	//		vb.getChildren().addAll(hb,hb2);
	//
	//		confirmWindow.getChildren().addAll(employeeAdded, vb);
	//		inputInfoScene = new Scene(confirmWindow,660,390);
	//		inputInfoStage.setScene(inputInfoScene);
	//		inputInfoStage.show();
	//
	//
	//	}




}