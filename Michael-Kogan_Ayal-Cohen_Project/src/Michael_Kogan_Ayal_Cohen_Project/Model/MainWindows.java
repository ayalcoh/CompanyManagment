package Michael_Kogan_Ayal_Cohen_Project.Model;
	
import javafx.application.Application;
import javafx.stage.Stage;
import Michael_Kogan_Ayal_Cohen_Project.Controller.CompanyController;
import Michael_Kogan_Ayal_Cohen_Project.View.CompanyView;

// ID Michael Kogan 318974672
// ID   Ayal Cohen  316018282

        public class MainWindows extends Application {
	   @Override
	    public void start(Stage primaryStage) throws Exception {
		 //First isSync second isChnagble
			Company c1 = new Company();
	    	CompanyView view = new CompanyView(primaryStage);
	    	CompanyController controller = new CompanyController(c1, view);
	    }
	    public static void main(String[] args) {
	        launch(args);
	    }
	}

