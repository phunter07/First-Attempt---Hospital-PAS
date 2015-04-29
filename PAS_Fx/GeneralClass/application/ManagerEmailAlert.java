package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * class to send the email alerts to the hospital manager
 * 
 * @author Catherine Geddis, Hannah McDade, Clare O'Toole
 * 
 */

public class ManagerEmailAlert implements IAlert {

	
	/**
	 * String to hold the managerEmailAddres once pulled from database
	 */
	private static String managerEmailAddress;
	
	
	static Properties mailServerProperties;

	static Session getMailSession;

	static MimeMessage generateMailMessage;
	
	/**
	 * method to connect to database and pull the managers email address
	 * from the staff table this method then sets the manager email address
	 * to be used when sending alerts via email
	 * @param mangerEmailAddress
	 * @return
	 */
	public String setManagerEmailAddress(String mangerEmailAddress) {
		DatabaseENums url = DatabaseENums.DATABASEURL;
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
			con = DriverManager.getConnection(url.getDatabase(), DatabaseENums.DATABASEUSERNAME.getDatabase(), DatabaseENums.DATABASEPASSWORD.getDatabase());
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			ResultSet rs = stmt.executeQuery(DatabaseENums.DATABASEMANAGEREMAILSELECTQUERY.getDatabase());
			managerEmailAddress=rs.getString(DatabaseENums.DATABASESTAFFEMAIL.getDatabase());
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return managerEmailAddress;
	

	}
	/**
	 * method to return managerEmailAddress
	 * @return
	 */
	public String getMangerEmailAddress(){
		return managerEmailAddress;
	}
	
	
	public static void getProperties(){
		
		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		
	}
	
	/**
	 * method to send email 
	 * @param getMailSession
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void transport(Session getMailSession) throws AddressException, MessagingException{

		Transport transport = getMailSession.getTransport("smtp");
		transport.connect(AlertsENums.EMAILSENDERSMTP.getAlert(), AlertsENums.EMAILSENDER.getAlert(),
				AlertsENums.EMAILSENDERPASSWORD.getAlert());
		transport.sendMessage(generateMailMessage,
				generateMailMessage.getAllRecipients());
		transport.close();
		
	}

	/**
	 * method to generate and send email alerts to the Hospital Manager
	 * 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void generateAndSendEmailPatientsWaitingThirtyMinutes() throws AddressException,
			MessagingException {

		getProperties();

		
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress(managerEmailAddress));
		generateMailMessage.addRecipient(Message.RecipientType.CC,
				new InternetAddress(managerEmailAddress));
		generateMailMessage.setSubject(AlertsENums.EMAILSUBJECTMESSAGE.getAlert());
		AlertsENums emailBody = AlertsENums.ALERTMANAGERWAITINGTIME;
		generateMailMessage.setContent(emailBody, "text/html");

		
		transport(getMailSession);
	}

	/**
	 * method to send the email to the Manager when on call team is fully engaged 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void generateAndSendEmailOnCallFullyEngaged() throws AddressException,
			MessagingException {

		//calling method to get the properties 
		getProperties();

		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress(managerEmailAddress));
		generateMailMessage.addRecipient(Message.RecipientType.CC,
				new InternetAddress(managerEmailAddress));
		generateMailMessage.setSubject(AlertsENums.EMAILSUBJECTMESSAGE.getAlert());
		AlertsENums emailBody = AlertsENums.ALERTMANAGERONCALLFULLYENGAGED;
		generateMailMessage.setContent(emailBody, "text/html");

		//calling the method to transport the email message
		transport(getMailSession);
		
	}

	/**
	 * unimplemented method from IAlert interface
	 */
	@Override
	public void sendSMSToOnCallTeam() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * unimplemented method from IAlert interface
	 */
	@Override
	public void sendSSMSManagerOnCallFullyEngaged() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * unimplemented method from IAlert interface
	 */
	@Override
	public void sendSSMSManagerTwoPatientsWaitingThirtyMinutes() {
		// TODO Auto-generated method stub
		
	}
}
