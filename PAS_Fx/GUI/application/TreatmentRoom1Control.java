package application;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class TreatmentRoom1Control implements Initializable {

	public static TreatmentRoom treatmentRoom ;

	private Patient patient;
	@FXML
	private TextArea telephoneTextArea1;

	@FXML
	private Label firstName1;

	@FXML
	private Label bloodGroup1;

	@FXML
	private Button back;

	@FXML
	private TextArea lastNameTextArea1;

	@FXML
	private TextArea textBox21;

	@FXML
	private TextArea allergiesTextArea1;

	@FXML
	private Label lastName1;

	@FXML
	private Button dischargePatient1;

	@FXML
	private Button logOut1;

	@FXML
	private Label triageCategory1;

	@FXML
	private Label timer1;

	@FXML
	private TextArea firstNameTextArea1;

	@FXML
	private Label address1;

	@FXML
	private Button furtherAction1;

	@FXML
	private Label title1;

	@FXML
	private TextArea bloodGroupTextArea1;

	@FXML
	private Button recategorisePatient1;

	@FXML
	private Label nhsNumber;

	@FXML
	private TextArea textBox11;

	@FXML
	private TextArea triageCategoryTextArea1;

	@FXML
	private TextArea nhsNumberTextArea;

	@FXML
	private Button allocateExtraTime1;

	@FXML
	private Label telephoneNumber1;

	@FXML
	private Label patientDetails1;

	@FXML
	private TextArea addressTextArea1;

	@FXML
	private Label treatmentRoom11;

	@FXML
	private TextArea titleTextArea1;

	@FXML
	private Label allergies1;

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
		Stage stage = (Stage) logOut1.getScene().getWindow();

		stage.close();

	}

	@FXML
	void onClickDischargePatient(ActionEvent event) {
		treatmentRoom.dischargePatient(GUIMain.allPatientList, patient);
	}

	@FXML
	void onClickFurtherAction(ActionEvent event) {

	}

	@FXML
	void onClickRecategorisePatient(ActionEvent event) {

	}

	@FXML
	void onClickAllocateExtraTime(ActionEvent event) {
		treatmentRoom.allocateExtraTime();
	}

	@FXML
	void onClickBack(ActionEvent event) {
		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/DoctorPage.fxml"));
			Scene scene = new Scene(root, 1000, 600);
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		patient = treatmentRoom.getPatientInTreatmentRoom();
		refreshThread();

	}

	private void refreshThread() {
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								patient=treatmentRoom.patientInTreatmentRoom;
								refreshPatientInformation();

							}
						});

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		myThread.setDaemon(true);
		myThread.start();
	}

	private void refreshPatientInformation() {

		if (patient != null) {
			nhsNumberTextArea.setText(String.valueOf(patient.getNhsNumber()));
			titleTextArea1.setText(patient.getTitle());
			firstNameTextArea1.setText(patient.getFirstName());
			lastNameTextArea1.setText(patient.getLastName());
			addressTextArea1.setText(patient.getAddress());
			telephoneTextArea1.setText(String.valueOf(patient.getNhsNumber()));
			allergiesTextArea1.setText(patient.getAllergies());
			bloodGroupTextArea1.setText(patient.getBloodGroup());
			int triage = patient.getTriage();
			for (int loop = 0; loop < Triage.values().length; loop++) {
				if (triage == Triage.values()[loop].getLevel()) {
					triageCategoryTextArea1.setText(Triage.values()[loop]
							.getTriage());
				}
			}
			String time = setTime(treatmentRoom.getTimeOutOfTreatmentRoom()
					.getTime() - new Date().getTime());
			timer1.setText(time);
		}else{
			nhsNumberTextArea.setText("");
			titleTextArea1.setText("");
			firstNameTextArea1.setText("");
			lastNameTextArea1.setText("");
			addressTextArea1.setText("");
			telephoneTextArea1.setText("");
			allergiesTextArea1.setText("");
			bloodGroupTextArea1.setText("");
			triageCategoryTextArea1.setText("");
			timer1.setText("00:00");
		}
	}

	private String setTime(long time) {
		if (time != 0) {
			long seconds = time / 1000;
			if (seconds < 60) {
				return ("00:" + String.format("%02d", seconds));
			} else if (seconds >= 60 && seconds < 3600) {
				return (String.format("%02d:", seconds / 60) + String.format(
						"%02d", seconds % 60));
			} else {
				return ("More than one hour");
			}
		}
		return "00:00";
	}

}
