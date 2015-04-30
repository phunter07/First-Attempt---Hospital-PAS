package receptionistPage;

/**
 * the class represents setTriageControl
 */
import java.net.URL;
import java.util.ResourceBundle;

import application.ExceptionsEnums;
import application.GUIMain;
import application.HospitalPASException;
import application.NurseTriage;
import application.Patient;
import application.SMSAlerts;
import application.SortPatientQueue;
import application.Triage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SetTriageControl implements Initializable {

	/**
	 * declaration of nurseTriage
	 */
	private NurseTriage nurseTriage = new NurseTriage();
	
	/**
	 * 
	 */
	SMSAlerts smsAlert = new SMSAlerts();
	
	/**
	 * declaration of the list of patient needed to be triaged
	 */
	private ObservableList<Patient> patientNeededToBeTriaged;

	/**
	 * declaration of the list of nhs_number needed to be triaged
	 */
	private ObservableList<String> nhsNeededToBeTriage;

	public SetTriageControl() {
	}

	@FXML
	private TableColumn<Patient, String> allergies;

	@FXML
	private TableColumn<Patient, String> address;

	@FXML
	private TableColumn<Patient, Integer> nhs_number;

	@FXML
	private TableColumn<Patient, String> last_name;

	@FXML
	private TableColumn<Patient, String> telephone;

	@FXML
	private TableColumn<Patient, String> title;

	@FXML
	private TableColumn<Patient, String> blood_group;

	@FXML
	private TableColumn<Patient, String> first_name;

	@FXML
	private TableView<Patient> patientTable;

	@FXML
	private ChoiceBox<String> nhsNumber;

	@FXML
	private ChoiceBox<String> triageChoiceBox;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Label warning;

	/**
	 * if OK button is clicked, firstly the system will find the patient in
	 * allPatientList by nhs_number, then set the triage of this patient
	 * 
	 * @author
	 * @param event
	 */
	@FXML
	public void okOnClick(ActionEvent event) {
		warning.setText("");
		if ((nhsNumber.getValue() != null)
				&& (triageChoiceBox.getValue() != null)) {
			try {
				Patient patient = nurseTriage.findPatientByNhsNumber(
						GUIMain.allPatientList, nhsNumber.getValue());
				if (patient != null && patient.getTriageCategory() == 0) {
					if (Triage
							.valueOf(triageChoiceBox.getValue().toUpperCase()) != Triage.EMERGENCY) {
						nurseTriage.categorisePatient(GUIMain.allPatientList,
								GUIMain.patientQueue, patient, Triage
										.valueOf(triageChoiceBox.getValue()
												.toUpperCase()));
						warning.setText(patient.getFirstName()+" is moving to the queue");
					} else {
						patient.setTriageCategory(Triage.EMERGENCY);
						if (GUIMain.sortPatientQueue.redirectEmergencyPatient(GUIMain.allPatientList,
								GUIMain.patientQueue, patient,
								GUIMain.treatmentRoomList,GUIMain.onCall)) {
							warning.setText("Emergency patient is moving to the treatment room");
						}
					}
				} else {
					warning.setText("Can not find this patient");
				}
			} catch (HospitalPASException e) {
				warning.setText(e.getMessage());
			}
		} else {
			warning.setText("Please complete the form");
		}
		refresh();
	}

	/**
	 * close this stage
	 * 
	 * @param event
	 */
	@FXML
	public void cancelOnClick(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

	/**
	 * initialize the stage, set the items of the choice box and refresh the
	 * other components
	 * 
	 * @author
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		triageChoiceBox.setItems(FXCollections.observableArrayList(
				Triage.EMERGENCY.getTriage(), Triage.URGENT.getTriage(),
				Triage.SEMI_URGENT.getTriage(), Triage.NON_URGENT.getTriage()));
		refresh();
	}

	/**
	 * find the patient needed to be triaged and his/her nhsnumber,which can be
	 * added into patient table and nhsNumber choice box, so that triageNurse
	 * can select the nhsnumber to add/alter triage of the patient owning this
	 * nhsnumber
	 * 
	 * @author
	 */
	public void refresh() {
		patientNeededToBeTriaged = FXCollections.observableArrayList();
		nhsNeededToBeTriage = FXCollections.observableArrayList();
		nurseTriage.findPatientNeededToBeTriage(patientNeededToBeTriaged,
				GUIMain.allPatientList);
		nhsOfPatientNeededToBeTriage();
		refreshTable();
		nhsNumber.setItems(nhsNeededToBeTriage);
	}

	/**
	 * refresh the uncategorized patient table
	 * 
	 * @author
	 */
	public void refreshTable() {
		if (!GUIMain.allPatientList.isEmpty()) {
			patientTable.setItems(null);

			nhs_number
					.setCellValueFactory(new PropertyValueFactory<Patient, Integer>(
							"nhsNumber"));
			title.setCellValueFactory(new PropertyValueFactory<Patient, String>(
					"title"));
			first_name
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"firstName"));
			last_name
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"lastName"));
			address.setCellValueFactory(new PropertyValueFactory<Patient, String>(
					"address"));
			telephone
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"contactNum"));
			allergies
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"allergies"));
			blood_group
					.setCellValueFactory(new PropertyValueFactory<Patient, String>(
							"bloodGroup"));

			patientTable.setItems(patientNeededToBeTriaged);

		} else {
			patientTable.setItems(null);
		}
	}

	/**
	 * add the nhs_number of the patient needed to be triaged into a list of
	 * nhs_number
	 * 
	 * @author
	 */
	public void nhsOfPatientNeededToBeTriage() {
		for (Patient patient : patientNeededToBeTriaged) {
			nhsNeededToBeTriage.add(String.valueOf(patient.getNhsNumber()));
		}
	}
}
