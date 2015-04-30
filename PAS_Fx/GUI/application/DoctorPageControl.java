package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DoctorPageControl {

	  @FXML
	    private Button treatmentRoom1;

	    @FXML
	    private Button treatmentRoom2;

	    @FXML
	    private Button treatmentRoom5;

	    @FXML
	    private Button logOut;

	    @FXML
	    private Button treatmentRoom3;

	    @FXML
	    private Button treatmentRoom4;

	    @FXML
	    void OnClickTreatmentRoom1(ActionEvent event) {
	    	Stage newStage = new Stage();

			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource(
						"/application/TreatmentRoom1.fxml"));
				Scene scene = new Scene(root, 687, 488);
				newStage.setTitle("Treatment Room 1");
				newStage.setScene(scene);
				newStage.setResizable(false);
				newStage.show();

			} catch (IOException e) {

				e.printStackTrace();
			}
	    }

	    @FXML
	    void onClickTreatmentRoom2(ActionEvent event) {

	    }

	    @FXML
	    void onClickTreatmentRoom3(ActionEvent event) {

	    }

	    @FXML
	    void onClickTreatmentRoom4(ActionEvent event) {

	    }

	    @FXML
	    void onClickTreatmentRoom5(ActionEvent event) {

	    }

	 

	
	
}
