package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

	public class TreatmentRoom1Control {

		 @FXML
		    private TextArea lastNameTextArea;

		    @FXML
		    private TextArea triageCategoryTextArea;

		    @FXML
		    private TextArea titleTextArea;

		    @FXML
		    private Label patientDetails;

		    @FXML
		    private TextArea textBox21;

		    @FXML
		    private TextArea firstNameTextArea;

		    @FXML
		    private Label bloodGroup;

		    @FXML
		    private TextArea allergiesTextArea1;

		    @FXML
		    private Label lastName1;

		    @FXML
		    private TextArea firstNameTextArea1;

		    @FXML
		    private Label title1;

		    @FXML
		    private TextArea bloodGroupTextArea1;

		    @FXML
		    private Button recategorisePatient1;

		    @FXML
		    private Label firstName;

		    @FXML
		    private TextArea textBox2;

		    @FXML
		    private TextArea triageCategoryTextArea1;

		    @FXML
		    private TextArea telephoneTextArea;

		    @FXML
		    private TextArea textBox1;

		    @FXML
		    private Button furtherAction;

		    @FXML
		    private TextArea bloodGroupTextArea;

		    @FXML
		    private TextArea addressTextArea1;

		    @FXML
		    private Label treatmentRoom11;

		    @FXML
		    private TextArea titleTextArea1;

		    @FXML
		    private Label allergies1;

		    @FXML
		    private Label allergies;

		    @FXML
		    private TextArea telephoneTextArea1;

		    @FXML
		    private Label lastName;

		    @FXML
		    private Label telephoneNumber;

		    @FXML
		    private Label firstName1;

		    @FXML
		    private Label bloodGroup1;

		    @FXML
		    private Button back;

		    @FXML
		    private Label title;

		    @FXML
		    private Button allocateExtraTime;

		    @FXML
		    private TextArea lastNameTextArea1;

		    @FXML
		    private Label timer;

		    @FXML
		    private Label triageCategory;

		    @FXML
		    private TextArea allergiesTextArea;

		    @FXML
		    private Button dischargePatient1;

		    @FXML
		    private Button dischargePatient;

		    @FXML
		    private Button logOut1;

		    @FXML
		    private Label triageCategory1;

		    @FXML
		    private Label timer1;

		    @FXML
		    private Label address;

		    @FXML
		    private Label address1;

		    @FXML
		    private Button furtherAction1;

		    @FXML
		    private TextArea addressTextArea;

		    @FXML
		    private Label treatmentRoom1;

		    @FXML
		    private TextArea textBox11;

		    @FXML
		    private Button recategorisePatient;

		    @FXML
		    private Button allocateExtraTime1;

		    @FXML
		    private Label telephoneNumber1;

		    @FXML
		    private Label patientDetails1;

		    @FXML
		    private Button logOut;

		    
		    
		    
		    @FXML
		    void onClickLogOut(ActionEvent event) {
		    	Stage newStage = new Stage();

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource(
							"/application/LoginScreen.fxml"));
					Scene scene = new Scene(root, 450, 400);
					newStage.setTitle("Hospital Manager");
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
		    void onClickDischargePatient(ActionEvent event) {

		    }

		    @FXML
		    void onClickFurtherAction(ActionEvent event) {

		    }

		    @FXML
		    void onClickRecategorisePatient(ActionEvent event) {

		    }

		    @FXML
		    void onClickAllocateExtraTime(ActionEvent event) {

		    }


		    @FXML
		    void onClickBack(ActionEvent event) {
		    	Stage newStage = new Stage();

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource(
							"/application/DoctorPage.fxml"));
					Scene scene = new Scene(root, 450, 400);
					newStage.setTitle("Hospital Manager");
					newStage.setScene(scene);
					newStage.setResizable(false);
					newStage.show();

				} catch (IOException e) {

					e.printStackTrace();
				}
				Stage stage = (Stage) back.getScene().getWindow();

				stage.close();
		    }

}
