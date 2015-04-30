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
	    private Button treatmentRoom3;

	    @FXML
	    private Button treatmentRoom4;
	    
	    @FXML
	    private Button logOut;

	    @FXML
	    void OnClickLogOut(ActionEvent event) {
	    
	    	Stage newStage = new Stage();

			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource(
						"/application/LoginScreen.fxml"));
				Scene scene = new Scene(root, 450, 400);
				newStage.setTitle("Doctor");
				newStage.setScene(scene);
				newStage.setResizable(false);
				newStage.show();

			} catch (IOException e) {

				e.printStackTrace();
			}
			Stage stage = (Stage) logOut.getScene().getWindow();

			stage.close();
		}
		
	    
	    
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
			Stage stage = (Stage) treatmentRoom1.getScene().getWindow();

			stage.close();
	    }

	    @FXML
	    void onClickTreatmentRoom2(ActionEvent event) {
	    	Stage newStage = new Stage();

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource(
							"/application/TreatmentRoom2.fxml"));
					Scene scene = new Scene(root, 687, 488);
					newStage.setTitle("Treatment Room 2");
					newStage.setScene(scene);
					newStage.setResizable(false);
					newStage.show();

				} catch (IOException e) {

					e.printStackTrace();
				}
				Stage stage = (Stage) treatmentRoom2.getScene().getWindow();

				stage.close();
	    }

	    @FXML
	    void onClickTreatmentRoom3(ActionEvent event) {
	    	Stage newStage = new Stage();

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource(
							"/application/TreatmentRoom3.fxml"));
					Scene scene = new Scene(root, 687, 488);
					newStage.setTitle("Treatment Room 3");
					newStage.setScene(scene);
					newStage.setResizable(false);
					newStage.show();

				} catch (IOException e) {

					e.printStackTrace();
				}
				Stage stage = (Stage) treatmentRoom3.getScene().getWindow();

				stage.close();
	    }

	    @FXML
	    void onClickTreatmentRoom4(ActionEvent event) {
	    	Stage newStage = new Stage();

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource(
							"/application/TreatmentRoom4.fxml"));
					Scene scene = new Scene(root, 687, 488);
					newStage.setTitle("Treatment Room 4");
					newStage.setScene(scene);
					newStage.setResizable(false);
					newStage.show();

				} catch (IOException e) {

					e.printStackTrace();
				}
				Stage stage = (Stage) treatmentRoom4.getScene().getWindow();

				stage.close();
	    }

	    @FXML
	    void onClickTreatmentRoom5(ActionEvent event) {
	    	Stage newStage = new Stage();

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource(
							"/application/TreatmentRoom5.fxml"));
					Scene scene = new Scene(root, 687, 488);
					newStage.setTitle("Treatment Room 5");
					newStage.setScene(scene);
					newStage.setResizable(false);
					newStage.show();

				} catch (IOException e) {

					e.printStackTrace();
				}
				Stage stage = (Stage) treatmentRoom5.getScene().getWindow();

				stage.close();
	    }

	 

	
	
}
