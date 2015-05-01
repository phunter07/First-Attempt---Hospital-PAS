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
	public String getFirstDoctorOnCall() {
		return firstDoctorOnCall;
	}

	/**
	 * 
	 * @return
	 */
	public String getSecondDoctorOnCall() {
		return secondDoctorOnCall;

	}

	/**
	 * 
	 * @return
	 */
	public String getFirstNurseOnCall() {
		return firstNurseOnCall;
	}

	/**
	 * 
	 * @return
	 */
	public String getSecondNurseOnCall() {
		return secondNurseOnCall;
	}

	/**
	 * 
	 * @return
	 */
	public String getThirdNurseOnCall() {
		return thirdNurseOnCall;
	}

	/**
	 * 
	 * @return
	 */
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	/**
	 * method to set the telephone number to send the Alert to the first on call
	 * doctor
	 * 
	 * @param firstDoctorOnCall
	 * @return
	 */
	public void setFirstDoctorOnCallPhoneNumber() {

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
		try {
			// making the connection
			con = DriverManager.getConnection(url,
					DatabaseENums.DATABASEUSERNAME.getDatabase(),
					DatabaseENums.DATABASEPASSWORD.getDatabase());
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			ResultSet rs = stmt
					.executeQuery(DatabaseENums.DATABASEONCALLDOCTORTELEHPONESELECTQUERY
							.getDatabase());
			while (rs.next()) {
				this.firstDoctorOnCall = rs
						.getString(DatabaseENums.DATABASESTAFFTELEPHONE
								.getDatabase());

			}
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());

		}

	}

	/**
	 * Method to set the telephone for the second on call nurse to receive
	 * alerts
	 * 
	 * @return
	 */
	public void setSecondDoctorOnCallPhoneNumber(String secondDoctorOnCall) {
		String url = DatabaseENums.DATABASEURL.getDatabase();
		Connection con;
		Statement stmt;
		// loading driver
		try {

			Class.forName(DatabaseENums.DATABASECLASS.getDatabase());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());

			try {
				// making the connection
				con = DriverManager.getConnection(url,
						DatabaseENums.DATABASEUSERNAME.getDatabase(),
						DatabaseENums.DATABASEPASSWORD.getDatabase());
				// create a statement object
				stmt = con.createStatement();
				// supply the statement object with a string to execute
				ResultSet rs = stmt
						.executeQuery(DatabaseENums.DATABASEONCALLDOCTORTWOTELEHPONESELECTQUERY
								.getDatabase());
				secondDoctorOnCall = rs
						.getString(DatabaseENums.DATABASESTAFFTELEPHONE
								.getDatabase());
				// close statement object
				stmt.close();
				// close connection
				con.close();
			} catch (SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());

			}

		}

	}

	/**
	 * method to set telephone number for the first on call nurse to receive SMS
	 * alert
	 * 
	 * @return
	 */
	public void setFirstNurseOnCallPhoneNumber(String firstNurseOnCall) {
		String url = DatabaseENums.DATABASEURL.getDatabase();
		Connection con;
		Statement stmt;
		// loading driver
		try {

			Class.forName(DatabaseENums.DATABASECLASS.getDatabase());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());

			try {
				// making the connection
				con = DriverManager.getConnection(url,
						DatabaseENums.DATABASEUSERNAME.getDatabase(),
						DatabaseENums.DATABASEPASSWORD.getDatabase());
				// create a statement object
				stmt = con.createStatement();
				// supply the statement object with a string to execute
				ResultSet rs = stmt
						.executeQuery(DatabaseENums.DATABASEONCALLNURSETELEHPONESELECTQUERY
								.getDatabase());
				firstNurseOnCall = rs
						.getString(DatabaseENums.DATABASESTAFFTELEPHONE
								.getDatabase());
				// close statement object
				stmt.close();
				// close connection
				con.close();
			} catch (SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());

			}

		}

	}

	/**
	 * method to set telephone number for the second on call nurse to receive
	 * SMS alert
	 * 
	 * @return
	 */
	public void setSecondNurseOnCallPhoneNumber(String secondNurseOnCall) {
		String url = DatabaseENums.DATABASEURL.getDatabase();
		Connection con;
		Statement stmt;
		// loading driver
		try {

			Class.forName(DatabaseENums.DATABASECLASS.getDatabase());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());

			try {
				// making the connection
				con = DriverManager.getConnection(url,
						DatabaseENums.DATABASEUSERNAME.getDatabase(),
						DatabaseENums.DATABASEPASSWORD.getDatabase());
				// create a statement object
				stmt = con.createStatement();
				// supply the statement object with a string to execute
				ResultSet rs = stmt
						.executeQuery(DatabaseENums.DATABASEONCALLNURSETWOTELEHPONESELECTQUERY
								.getDatabase());
				secondNurseOnCall = rs
						.getString(DatabaseENums.DATABASESTAFFTELEPHONE
								.getDatabase());
				// close statement object
				stmt.close();
				// close connection
				con.close();
			} catch (SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());

			}

		}

	}

	/**
	 * method to set the telephone number for the third on call nurse to receive
	 * SMS
	 * 
	 * @return
	 */
	public void setThirdNurseOnCallPhoneNumber(String thirdNurseOnCall) {
		String url = DatabaseENums.DATABASEURL.getDatabase();
		Connection con;
		Statement stmt;
		// loading driver
		try {

			Class.forName(DatabaseENums.DATABASECLASS.getDatabase());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());

			try {
				// making the connection
				con = DriverManager.getConnection(url,
						DatabaseENums.DATABASEUSERNAME.getDatabase(),
						DatabaseENums.DATABASEPASSWORD.getDatabase());
				// create a statement object
				stmt = con.createStatement();
				// supply the statement object with a string to execute
				ResultSet rs = stmt
						.executeQuery(DatabaseENums.DATABASEONCALLNURSETHREETELEHPONESELECTQUERY
								.getDatabase());
				thirdNurseOnCall = rs
						.getString(DatabaseENums.DATABASESTAFFTELEPHONE
								.getDatabase());
				// close statement object
				stmt.close();
				// close connection
				con.close();
			} catch (SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());

			}

		}

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
	 * method to construct the SMS message to the on call team when alert is
	 * called
	 */
	@Override
	public void sendSMSToOnCallTeam() {

		// Construct data from TxtLocal
		String user = "username=" + AlertsENums.SMSUSERNAME.getAlert();
		String hash = "&hash=" + AlertsENums.SMSHASHKEY.getAlert();
		String message = "&message="
				+ AlertsENums.SMSALERTONCALLTEAM.getAlert();
		String sender = "&sender=" + AlertsENums.SMSSENDER.getAlert();
		setFirstDoctorOnCallPhoneNumber();
		String number1 = "&numbers=" + getFirstDoctorOnCall();
		
		String number2 = "&numbers=" + getSecondDoctorOnCall();
		String number3 = "&numbers=" + getFirstNurseOnCall();
		String number4 = "&numbers=" + getSecondNurseOnCall();
		String number5 = "&numbers=" + getThirdNurseOnCall();

		// calling the method to send the data to all 5 on call staff
		sendData(user, hash, message, sender, number1);
		sendData(user, hash, message, sender, number2);
		sendData(user, hash, message, sender, number3);
		sendData(user, hash, message, sender, number4);
		sendData(user, hash, message, sender, number5);
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
