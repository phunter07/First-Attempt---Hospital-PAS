package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class viewStaffControl implements Initializable {

	@FXML
	private TableColumn<Staff, String> staffFirstNameColumn;

	@FXML
	private TableColumn<Staff, String> staffTeamColumn;

	@FXML
	private TableColumn<Staff, String> staffEmailColumn;

	@FXML
	private TableView<Staff> staffTableManager;

	@FXML
	private TableColumn<Staff, String> staffTitleColumn;

	@FXML
	private TableColumn<Staff, String> staffLastNameColumn;

	@FXML
	private Button back;

	@FXML
	private TableColumn<Staff, Integer> staffIDColumn;

	@FXML
	private TableColumn<Staff, String> staffRoleColumn;

	@FXML
	private TableColumn<Staff, String> staffTelephoneNumColumn;

	public void populateStaffTable() {
		List<Staff> staffList = GUIMain.getAllStaff();

		if (!staffList.isEmpty()) {
			staffTableManager.setItems(null);
			staffIDColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, Integer>(
							"staffID"));
			staffTitleColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"title"));
			staffFirstNameColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"firstName"));
			staffLastNameColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"lastName"));
			staffRoleColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"role"));
			staffTeamColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"team"));
			staffEmailColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"email"));
			staffTelephoneNumColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"telephone"));

			staffTableManager.setItems(FXCollections
					.observableArrayList(staffList));

		} else {
			staffTableManager.setItems(null);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		populateStaffTable();

	}
	
    @FXML
    void onClickBack(ActionEvent event) {
    	Stage newStage = new Stage();

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(
					"/application/HospitalManagerPage.fxml"));
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
    
}