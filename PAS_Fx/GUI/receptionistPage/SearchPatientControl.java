/**
 * @author Paul 40133443
 */

package receptionistPage;

import application.GUIMain;
import application.Patient;
import application.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * View-Controller for the Patient table.
 * 
 * @author Paul Hunter
 */
public class SearchPatientControl {

	@FXML
	private TextField filterField;
	@FXML
	private TableView<PatientForSearch> patientTable;

	@FXML
	private TableColumn<PatientForSearch, String> nhsNumberColumn;
	
	@FXML
	private TableColumn<PatientForSearch, String> titleColumn;
	
	@FXML
	private TableColumn<PatientForSearch, String> firstNameColumn;
	@FXML
	private TableColumn<PatientForSearch, String> lastNameColumn;

	@FXML
	private TableColumn<PatientForSearch, String> addressColumn;
	@FXML
	private TableColumn<PatientForSearch, String> contactNumberColumn;
	@FXML
	private TableColumn<PatientForSearch, String> bloodGroupColumn;

	@FXML
	private TableColumn<PatientForSearch, String> triageCategoryColumn;

	@FXML
	private TableColumn<PatientForSearch, String> waitingTimeColumn;

	private ObservableList<PatientForSearch> masterData = FXCollections
			.observableArrayList();

	/**
	 * Just add some sample data in the constructor.
	 */
	public SearchPatientControl() {
		for (Patient patient : GUIMain.patientQueue) {
			PatientForSearch patientForSearch = new PatientForSearch(
					String.valueOf(patient.getNhsNumber()), patient.getTitle(),
					patient.getFirstName(), patient.getLastName(),
					patient.getAddress(),
					String.valueOf(patient.getNhsNumber()),
					patient.getBloodGroup(),String.valueOf(patient.getTriageCategory()),String.valueOf(
					patient.getWaitingTime()));
					masterData.add(patientForSearch);
			
		
		}
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 * 
	 * Initializes the table columns and sets up sorting and filtering.
	 */
	@FXML
	private void initialize() {
		// 0. Initialize the columns.
		nhsNumberColumn.setCellValueFactory(cellData -> cellData.getValue()
				.nhsNumberProperty());
		titleColumn.setCellValueFactory(cellData -> cellData.getValue()
				.titleProperty());
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue()
				.firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue()
				.lastNameProperty());
		addressColumn.setCellValueFactory(cellData -> cellData.getValue()
				.addressProperty());
		contactNumberColumn.setCellValueFactory(cellData -> cellData.getValue()
				.contactNumberProperty());
		bloodGroupColumn.setCellValueFactory(cellData -> cellData.getValue()
				.bloodGroupProperty());
		triageCategoryColumn.setCellValueFactory(cellData -> cellData.getValue()
				.triageCategoryProperty());
		waitingTimeColumn.setCellValueFactory(cellData -> cellData.getValue()
				.waitingTimeProperty());
		
		// 1. Wrap the ObservableList in a FilteredList (initially display all
		// data).
		FilteredList<PatientForSearch> filteredData = new FilteredList<>(
				masterData, p -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener(
				(observable, oldValue, newValue) -> {
					filteredData.setPredicate(Patient -> {
						// If filter text is empty, display all Patients.
							if (newValue == null || newValue.isEmpty()) {
								return true;
							}

							// Compare first name and last name of every Patient
							// with filter text.
							String lowerCaseFilter = newValue.toLowerCase();

							if (Patient.getFirstName().toLowerCase()
									.indexOf(lowerCaseFilter) != -1) {
								return true; // Filter matches first name.
							} else if (Patient.getLastName().toLowerCase()
									.indexOf(lowerCaseFilter) != -1) {
								return true; // Filter matches last name.
							} else if (Patient.getNhsNumber().toLowerCase()
									.indexOf(lowerCaseFilter) != -1) {
								return true;
							} else if (Patient.getAddress().toLowerCase()
									.indexOf(lowerCaseFilter) != -1) {
								return true;
							} else if (Patient.getBloodGroup().toLowerCase()
									.indexOf(lowerCaseFilter) != -1) {
								return true;
							}
							return false; // Does not match.
						});
				});

		// 3. Wrap the FilteredList in a SortedList.
		SortedList<PatientForSearch> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		// Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(patientTable.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		patientTable.setItems(sortedData);
	}
}
