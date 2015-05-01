package alerts;

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

/**
 * class to send the Alert to the OnCall Team when the queue size reaches the
 * upper limit of 10 and when all treatment rooms are full of emergency patients
 *
 */

public class OnCallSMSAlert implements IAlert {
	
	
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
	 * method to get the First doctor On Call Phone Number
	 * @return
	 */
	public String getFirstDoctorOnCall() {
		return firstDoctorOnCall;
	}

	/**
	 * method to get the second doctor On Call Phone Number
	 * @return
	 */
	public String getSecondDoctorOnCall() {
		return secondDoctorOnCall;

	}

	/**
	 * method to get the First nurse On Call Phone Number
	 * @return
	 */
	public String getFirstNurseOnCall() {
		return firstNurseOnCall;
	}

	/**
	 * method to get the second nurse On Call Phone Number
	 * @return
	 */
	public String getSecondNurseOnCall() {
		return secondNurseOnCall;
	}

	/**
	 * method to get the third nurse On Call Phone Number
	 * @return
	 */
	public String getThirdNurseOnCall() {
		return thirdNurseOnCall;
	}


	/**
	 * method to send the alert to the on call team - to be called in the GUI Main 
	 */
	@Override
	public void sendSMSToOnCallTeam() {
		

	}
	
	/**
	 * method to set the telephone number to send the Alert to the first on call
	 * doctor - pulled from database
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
	 * alerts - pulled from database
	 * 
	 * @param secondDoctorOnCall
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
	 * alert -  pulled from database
	 * 
	 * @return
	 * @param firstNurseOnCall
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
	 * SMS alert - pulled from database
	 * 
	 * @param secondNurseOnCall
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
	 * method to set the telephone number for the third on call nurse to receive
	 * SMS - pulled from database
	 * 
	 * @param thirdNurseOnCall
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
	 * unimplemented method to be to be used in managerSMSAlert Class 
	 */
	@Override
	public void sendSSMSManagerOnCallFullyEngaged() {

	}

	/**
	 * unimplemented method to be to be used in managerSMSAlert Class
	 */
	@Override
	public void sendSSMSManagerTwoPatientsWaitingThirtyMinutes() {
		// TODO Auto-generated method stub
	}

	/**
	 * unimplemented method to be to be used in managerEmailAlert class
	 */
	@Override
	public void generateAndSendEmailOnCallFullyEngaged()
			throws AddressException, MessagingException {
		
	}

	/**
	 * unimplemented method to be to be used in managerEmailAlert Class
	 */
	@Override
	public void generateAndSendEmailPatientsWaitingThirtyMinutes()
			throws AddressException, MessagingException {
	

	}

}
