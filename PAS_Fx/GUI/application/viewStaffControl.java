package PAS_Fx;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

import pasCode.Staff;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class viewStaffControl extends Application {

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
	private TableColumn<Staff, String> staffIDColumn;

	@FXML
	private TableColumn<Staff, String> staffRoleColumn;

	@FXML
	private TableColumn<Staff, String> staffTelephoneNumColumn;

	@Override
	public void start(Stage primaryStage) throws Exception {

		
	}

	
	public void populateTable() {
		if (!GUI_Main.allStaff.isEmpty()) {
			staffTableManager.setItems(null);
			staffIDColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"staff_id"));
			staffTitleColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>(
					"title"));
			staffFirstNameColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"first_name"));
			staffLastNameColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"last_name"));
			staffRoleColumn.setCellValueFactory(new PropertyValueFactory<Staff, String>(
					"staff_role"));
			staffTeamColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"staff_team"));
			staffEmailColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"email_address"));
			staffTelephoneNumColumn
					.setCellValueFactory(new PropertyValueFactory<Staff, String>(
							"telephone"));

			staffTableManager.setItems(GUI_Main.allStaff);

		} else {
			staffTableManager.setItems(null);
		}
	}
}

	