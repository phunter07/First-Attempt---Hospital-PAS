package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 * 
 * @author Clare O'Toole
 *
 */
public class HospitalManagerPageControl implements Initializable {

	
	 @FXML
	    private TableColumn<Patient, String> allergies;

	    @FXML
	    private TableColumn<Patient, String> address;

	    @FXML
	    private TableColumn<Patient, Integer> nhs_number;

	    @FXML
	    private TableView<Patient> tableView;

	    @FXML
	    private TableColumn<Patient, String> last_name;

	    @FXML
	    private TableColumn<Patient, Long> waitingTime;

	    @FXML
	    private TableColumn<Patient, String> telephone;

	    @FXML
	    private TableColumn<Patient, String> title;

	    @FXML
	    private Button logOut;


	    @FXML
	    private TableColumn<Patient, String> blood_group;

	    @FXML
	    private TableColumn<Patient, String> first_name;

	    @FXML
	    private TableColumn<Patient, Integer> triage;
	    
	    @FXML
	    private Button staff;
	    
	    @FXML
	    private Button treatmentRooms;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(Limits.REFRESHTIME);
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								refresh();

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

	/**
	 * the method is used to refresh table, update waiting time of every patient
	 * in queue and show the receptionist the next patient and the available
	 * treatment room
	 * 
	 * @author
	 */
	private void refresh() {
		refreshTable();

	}
	
	/**
	 * Log out of system
	 * 
	 * @param event
	 */
	@FXML
	public void onClickLogOut(ActionEvent event) {

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
	
	
	/**
	 * Log out of system
	 * 
	 * @param event
	 */
	@FXML
	public void onClickTreatmentsRooms(ActionEvent event) {

		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/viewTreatmentRooms.fxml"));
			Scene scene = new Scene(root, 1000, 600);
			newStage.setTitle("Hospital Manager");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) treatmentRooms.getScene().getWindow();

		stage.close();
	}
	
	
	
	
	/**
	 * Log out of system
	 * 
	 * @param event
	 */
	@FXML
	public void onClickStaff(ActionEvent event) {

		Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/viewStaff.fxml"));
			Scene scene = new Scene(root, 1000, 600);
			newStage.setTitle("Hospital Manager");
			newStage.setScene(scene);
			newStage.setResizable(false);
			newStage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage stage = (Stage) staff.getScene().getWindow();

		stage.close();
	}
	
	private void refreshTable() {
		if (!GUIMain.patientQueue.isEmpty()) {
			ObservableList<Patient> list = FXCollections.observableArrayList();
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
			triage.setCellValueFactory(new PropertyValueFactory<Patient, Integer>(
					"triage"));
			triage.setCellFactory(new Callback<TableColumn<Patient, Integer>, TableCell<Patient, Integer>>() {

				@Override
				public TableCell<Patient, Integer> call(
						TableColumn<Patient, Integer> param) {

					return new TableCell<Patient, Integer>() {
						@Override
						protected void updateItem(Integer item, boolean empty) {
							super.updateItem(item, empty);
							
							if (item!=null) {
								for(int loop=0;loop<Triage.values().length;loop++){
								if(item==Triage.values()[loop].getLevel()){
									setText(Triage.values()[loop].getTriage());
								}
								}
							}
						}
					};
				}
			});

			waitingTime.setCellValueFactory(new PropertyValueFactory<Patient,Long>("waitingTime"));
			waitingTime
					.setCellFactory(new Callback<TableColumn<Patient, Long>, TableCell<Patient, Long>>() {

						@Override
						public TableCell<Patient, Long> call(
								TableColumn<Patient, Long> param) {

							return new TableCell<Patient, Long>() {
								@Override
								protected void updateItem(Long item,
										boolean empty) {
									super.updateItem(item, empty);
									if (item != null) {
										long seconds = item / 1000;
										if (seconds < 60) {
											setText("00:"
													+ String.format("%02d",
															seconds));
										} else if (seconds >= 60
												&& seconds < 3600) {
											setText(String.format("%02d:",
													seconds / 60)
													+ String.format("%02d",
															seconds % 60));
										} else {
											setText("More than one hour");
										}
									}
								}
							};
						}
					});
			for (Patient patient : GUIMain.patientQueue) {
				list.add(patient);
				tableView.setItems(list);
			}
		} else {
			tableView.setItems(null);
		}
	}
}
