package application;

/**
 * @author Hannah McDade, Clare O'Toole, Catherine Geddis
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

public class SMSAlerts implements IAlert {


	/**
	 * String to hold managerPhoneNumber
	 */
	private String managerPhoneNumber;

	/**
	 * String to hold first doctor on call telephone number
	 */
	private String firstDoctorOnCall;

	/**
	 * String to hold second doctor on call telephone number
	 */
	private String secondDoctorOnCall;

	/**
	 * String to hold first nurse on call telephone number
	 */
	private String firstNurseOnCall;

	/**
	 * String to hold second nurse on call telephone number
	 */
	private String secondNurseOnCall;

	/**
	 * String to hold third nurse on call telephone number
	 */
	private String thirdNurseOnCall;

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
			con = DriverManager.getConnection(url, DatabaseENums.DATABASEUSERNAME.getDatabase(),
					DatabaseENums.DATABASEPASSWORD.getDatabase());
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			ResultSet rs = stmt
					.executeQuery(DatabaseENums.DATABASEMANAGERTELEPHONESELECTQUERY.getDatabase());
			managerPhoneNumber = rs
					.getString(DatabaseENums.DATABASESTAFFTELEPHONE.getDatabase());
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
	 * method to set the number for the on call team
	 * 
	 * @return
	 */
	public String setOnCallPhoneNumbers() {
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
			con = DriverManager.getConnection(url, DatabaseENums.DATABASEUSERNAME.getDatabase(),
					DatabaseENums.DATABASEPASSWORD.getDatabase());
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			boolean hasResults = stmt
					.execute(DatabaseENums.DATABASEONCALLTELEPHONESELECTQUERY.getDatabase());
			while (hasResults) {
				ResultSet rs = stmt.getResultSet();
				firstDoctorOnCall = rs.getString(1);
				secondDoctorOnCall = rs.getString(2);
				firstNurseOnCall = rs.getString(3);
				secondNurseOnCall = rs.getString(4);
				thirdNurseOnCall = rs.getString(5);

			}
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return firstDoctorOnCall;

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

	public String sendDataToManager(String user, String hash, String message,
			String sender, String numbers) {

		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(
					AlertsENums.SMS_CONNECTION.getAlert()).openConnection();

			// data to be sent
			String data = user + hash + numbers + message + sender;
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
	 * method to get on call numbers from database
	 * 
	 * @param user
	 * @param hash
	 * @param message
	 * @param sender
	 * @param firstDoctorOnCall
	 * @param secondDoctorOnCall
	 * @param firstNurseOnCall
	 * @param secondNurseOnCall
	 * @param thirdNurseOnCall
	 * @return
	 */
	public String sendDataToOnCall(String user, String hash, String message,
			String sender, String firstDoctorOnCall, String secondDoctorOnCall,
			String firstNurseOnCall, String secondNurseOnCall,
			String thirdNurseOnCall) {

		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(
					AlertsENums.SMS_CONNECTION.getAlert()).openConnection();

			// data to be sent
			String data = user + hash + firstDoctorOnCall + secondDoctorOnCall
					+ firstNurseOnCall + secondNurseOnCall + thirdNurseOnCall
					+ message + sender;
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
	 * method to construct the SMS message to the on call team when the queue
	 * capacity reaches 10 and send them
	 */
	@Override
	public void sendSMSToOnCallTeam() {

		// Construct data from TxtLocal
		String user = "username=" + AlertsENums.SMSUSERNAME.getAlert();
		String hash = "&hash=" + AlertsENums.SMSHASHKEY.getAlert();
		String message = "&message=" + AlertsENums.SMSALERTONCALLTEAM;
		String sender = "&sender=" + AlertsENums.SMS_SENDER.getAlert();
		String number1 = "&numbers=" + firstDoctorOnCall;
		String number2 = "&numbers=" + secondDoctorOnCall;
		String number3 = "&numbers=" + firstNurseOnCall;
		String number4 = "&numbers=" + secondNurseOnCall;
		String number5 = "&numbers=" + thirdNurseOnCall;

		// calling the method to send the data to all 5 on call staff
		sendDataToOnCall(user, hash, message, sender, number1, number2,
				number3, number4, number5);

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
		String numbers = "&numbers=" + managerPhoneNumber;

		// calling the method to send the data
		sendDataToManager(user, hash, message, sender, numbers);

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
		String message = "&message="
				+ AlertsENums.ALERTMANAGERWAITINGTIME;
		String sender = "&sender=" + AlertsENums.SMSSENDER.getAlert();
		String numbers = "&numbers=" + managerPhoneNumber;

		// calling the method to send the data
		sendDataToManager(user, hash, message, sender, numbers);

	}
	/**
	 * unimplemented methods used in managerEmail class
	 */
	@Override
	public void generateAndSendEmailOnCallFullyEngaged()
			throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * unimplemented methods used in managerEmail class
	 */
	@Override
	public void generateAndSendEmailPatientsWaitingThirtyMinutes()
			throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		
	}



}
