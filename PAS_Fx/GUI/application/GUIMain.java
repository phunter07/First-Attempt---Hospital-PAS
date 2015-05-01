package application;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import alerts.SMSAlerts;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIMain extends Application {

	private TreatmentRoom treatmentRoom;

	/**
	 * all treatment room in PAS,it is global variable
	 */
	public static ArrayList<TreatmentRoom> treatmentRoomList;

	/**
	 * all patient in PAS,it is global variable
	 */
	public static LinkedList<Patient> allPatientList;

	public static LinkedList<Patient> patientQueue;

	public static WriteToFile writeToFile = new WriteToFile();

	public static SortPatientQueue sortPatientQueue;

	public static int status;

	public static Patient nextPatient;

	public static OnCall onCall = new OnCall();

	public static void main(String[] args) {

		launch(args);

	}

	public void start(Stage primaryStage) {
		initialise();
		try {

			Parent root = FXMLLoader.load(getClass().getResource(
					"/application/LoginScreen.fxml"));

			Scene scene = new Scene(root, 450, 400);

			primaryStage.setTitle("FXML Welcome");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			threadStart();
			alertThread();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void alertThread() {
		System.out.println("alertThread");
		Thread alertThread = new Thread() {

			@Override
			public void run() {

				boolean delay = false;

				try {
					while (true) {
						while (!delay) {
							Thread.sleep(1000);
							
//								sortPatientQueue
//										.thirtyMinuteManagerAlert(patientQueue);
							
							if(sortPatientQueue
									.calculateQueueSize(GUIMain.patientQueue)){
								delay=false;
							}
						}
						delay=true;
						Thread.sleep(10000*600);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		};

		alertThread.setDaemon(true);
		alertThread.start();
	}

	/**
	 * method to start the thread for the whole system
	 */
	private void threadStart() {
		System.out.println("Thread Starting..");
		Thread queueThread = new Thread() {

			@Override
			public void run() {

				int i = 0;

				try {
					while (true) {
						Thread.sleep(1000);
						nextPatient = patientQueue.peek();
						sortPatientQueue.allocatePatientToTreatmentRoom(
								patientQueue, patientQueue.peek(),
								treatmentRoomList);
						// sortPatientQueue.thirtyMinuteManagerAlert(patientQueue);
						sortPatientQueue.movePatientToTopOfQueue(patientQueue);
						// sortPatientQueue
						// .calculateQueueSize(GUIMain.patientQueue);
						for(TreatmentRoom treatmentRoom:treatmentRoomList){
							if(treatmentRoom.isVacant()==false){
								treatmentRoom.removePatientFromTreatmentroomAutomatically();
							}
						}
						try {
							writeToFile.writeQueueToFile(GUIMain.patientQueue);
						} catch (FileNotFoundException e) {

							e.printStackTrace();
						}
						// refresh();
						// updateTreatmentRoomsStatus(patient);
						// sortPatientQueue.movePatientToTopOfQueue(patientQueue,
						// patient);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		};

		queueThread.setDaemon(true);
		queueThread.start();
	}

	public void refresh() {
		// nurseTriage.putPatientIntoQueue(patientQueue, patient);

		try {

			writeToFile.writeQueueToFile(patientQueue);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		sortPatientQueue.calculateStatus(patientQueue);
	}

	/**
	 * method to initialise variables
	 */
	public void initialise() {
		//new SMSAlerts().sendSMSToOnCallTeam();
		patientQueue = new LinkedList<Patient>();
		allPatientList = new LinkedList<Patient>();
		treatmentRoomList = new ArrayList<TreatmentRoom>();
		status = 1;
		nextPatient = new Patient();
		for (int loop = 0; loop < Limits.NUMBERS_OF_ROOM; loop++) {
			treatmentRoomList.add(new TreatmentRoom());
		}
		sortPatientQueue = new SortPatientQueue();

	}

	public static ArrayList<Staff> getAllStaff() {
		ArrayList<Staff> allStaff = new ArrayList<Staff>();
		String url = "jdbc:mysql://web2.eeecs.qub.ac.uk/40108307";
		Connection con;
		Statement stmt; // loading driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		// making the connection
		try {
			con = DriverManager.getConnection(url, "40108307", "CZB6355");
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute

			ResultSet rs = stmt.executeQuery("select * from STAFF");
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setStaffID(Integer.parseInt(rs.getString("STAFF_ID")));
				staff.setTitle(rs.getString("TITLE"));
				staff.setFirstName(rs.getString("FIRST_NAME"));
				staff.setLastName(rs.getString("LAST_NAME"));
				staff.setPassword(rs.getString("STAFF_PASSWORD"));
				staff.setRole(rs.getString("STAFF_ROLE"));
				staff.setTeam(rs.getString("STAFF_TEAM"));
				staff.setEmail(rs.getString("EMAIL_ADDRESS"));
				staff.setTelephone(rs.getString("TELEPHONE"));

				allStaff.add(staff);
			}
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return allStaff;
	}
	
	
} // end of GUIMain Class

