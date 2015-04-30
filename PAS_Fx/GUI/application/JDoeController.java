package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Patient;
import application.NurseTriage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class JDoeController implements Initializable {
	
	
	@FXML
	private Button MALEBUTT;
	
	@FXML
	private Button FEMALEBUTT;
	
	@FXML
	private Label warning;

	/**
	 * Default constructor
	 */
	public JDoeController() {
		
	}
	@FXML
	public void MaleOnClick(){
		
		Stage stage = (Stage) MALEBUTT.getScene().getWindow();
		
		Patient patient = new Patient();
		NurseTriage nurse = new NurseTriage();
		nurse.allocateJDoeDetails(GUIMain.patientQueue, patient, 2);
		warning.setText(patient.getEmergencyNHSNumber() + patient.getFirstName() + patient.getLastName() + " sent to treatment room.");

		stage.close();
	}
	
	
	@FXML
	public void FemaleOnClick(){
		
        Stage stage = (Stage) FEMALEBUTT.getScene().getWindow();
		
		int num = 0;
		Patient patient = new Patient();
		patient.setEmergencyNHSNumber(num);
		num = patient.getEmergencyNHSNumber();
		NurseTriage nurse = new NurseTriage();
		nurse.allocateJDoeDetails(GUIMain.patientQueue, patient, 1);
		warning.setText(patient.getFirstName() + patient.getLastName() + " sent to treatment room.");

		stage.close();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
	}

}
