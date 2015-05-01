package alerts;

/**
 * Class containing the SMS Alerts to the Hospital Manager - to be sent when two patients have been waiting 30 minutes and when the On Call team are fully engaged
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import eNums.AlertsENums;
import eNums.DatabaseENums;

public class ManagerSMSAlerts implements IAlert {

	/**
	 * String to hold managerPhoneNumber
	 */
	private String managerPhoneNumber;

	
	/**
	 * Method to connect to database and pull manager phone number from staff
	 * table then set the String managerPhoneNumber
	 * 
	 * @param mangerPhoneNumber
	 * @return
	 */
	public String setManagerPhoneNumber(String mangerPhoneNumber) {
		String url = DatabaseENums.DATABASEURL.getDatabase();
		Connection con;
		Statement stmt;
		// loading driver
		try {
			Class.forName(DatabaseENums.DATABASECLASS.getDatabase());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		// making the connection
		try {
			con = DriverManager.getConnection(url,
					DatabaseENums.DATABASEUSERNAME.getDatabase(),
					DatabaseENums.DATABASEPASSWORD.getDatabase());
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			ResultSet rs = stmt
					.executeQuery(DatabaseENums.DATABASEMANAGERTELEPHONESELECTQUERY
							.getDatabase());
			managerPhoneNumber = rs
					.getString(DatabaseENums.DATABASESTAFFTELEPHONE
							.getDatabase());
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return managerPhoneNumber;

	}


	/**
	 * 
	 * @return
	 */
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	

	/**
	 * method to send the relevant SMS when called to the hospital manager
	 * 
	 * @param user
	 * @param hash
	 * @param message
	 * @param sender
	 * @param numbers
	 * @return
	 */

	public String sendData(String user, String hash, String message,
			String sender, String number) {
		System.out.println(sender);
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(
					AlertsENums.SMSCONNECTION.getAlert()).openConnection();

			// data to be sent
			String data = user + hash + number + message + sender;
			System.out.println(data);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length",
					Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			// user exception to go here
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

	/**
	 * method to generate and send email to manager when on call team is fully
	 * engaged with patient
	 */
	@Override
	public void sendSSMSManagerOnCallFullyEngaged() {
		// Construct data from TxtLocal
		String user = "username=" + AlertsENums.SMSUSERNAME.getAlert();
		String hash = "&hash=" + AlertsENums.SMSHASHKEY.getAlert();
		String message = "&message="
				+ AlertsENums.ALERTMANAGERONCALLFULLYENGAGED;
		String sender = "&sender=" + AlertsENums.SMSSENDER.getAlert();
		String number = "&numbers=" + getManagerPhoneNumber();

		// calling the method to send the data
		sendData(user, hash, message, sender, number);

	}

	/**
	 * method to generate and send email to manager if 2 patients waiting longer
	 * than 30 minutes
	 */
	@Override
	public void sendSSMSManagerTwoPatientsWaitingThirtyMinutes() {
		// Construct data from TxtLocal
		String user = "username=" + AlertsENums.SMSUSERNAME.getAlert();
		String hash = "&hash=" + AlertsENums.SMSHASHKEY.getAlert();
		String message = "&message=" + AlertsENums.ALERTMANAGERWAITINGTIME;
		String sender = "&sender=" + AlertsENums.SMSSENDER.getAlert();
		String number = "&numbers=" + getManagerPhoneNumber();

		// calling the method to send the data
		sendData(user, hash, message, sender, number);

	}
	
	/**
	 * unimplemented method to be used in OnCallSMSAlerts Class
	 */
	@Override
	public void sendSMSToOnCallTeam() {

		
	}

	/**
	 * unimplemented methods used in managerEmail class
	 */
	@Override
	public void generateAndSendEmailOnCallFullyEngaged()
			throws AddressException, MessagingException {

	}

	/**
	 * unimplemented methods used in managerEmail class
	 */
	@Override
	public void generateAndSendEmailPatientsWaitingThirtyMinutes()
			throws AddressException, MessagingException {

	}

}
