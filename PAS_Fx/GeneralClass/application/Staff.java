package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Staff extends Person implements ILogin {

	/**
	 * declaration of var staff ID
	 */
	private int staffID;

	/**
	 * declaration of var password
	 */
	private String password;

	/**
	 * declaration of role
	 */
	private String role;

	/**
	 * declaration of email
	 */
	private String email;

	/**
	 * declaration of telephone
	 */
	private String telephone;

	/**
	 * declaration of team
	 */
	private String team;

	/**
	 * default constructor
	 */

	public Staff() {

	}

	/**
	 * constructor with args
	 * 
	 * @param title
	 * 
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param staffID
	 * @param password
	 */
	public Staff(String title, String firstName, String lastName, char gender,
			int staffID, String password) {
		super(title, firstName, lastName, gender);
		this.staffID = staffID;
		this.password = password;

	}

	/**
	 * method to get the staff id
	 * 
	 * @return the staff id
	 */
	public int getStaffID() {
		return staffID;
	}

	/**
	 * sets the staff ID
	 * 
	 * @param staffID
	 * @throws IllegalArgumentException
	 *             if a staff id is not entered
	 */
	public void setStaffID(int staffID) throws IllegalArgumentException {
		if (staffID == 0) {
			throw new IllegalArgumentException("A staff ID must be entered");
		} else {
			this.staffID = staffID;
		}
	}

	/**
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * sets password
	 * 
	 * @author Jiang Zhe Heng
	 * @param password
	 * @throws NullPointerException
	 *             if a null value is entered into the string
	 */
	public void setPassword(String password) throws NullPointerException {
		if (password.isEmpty()) {
			throw new NullPointerException();
		} else {
			this.password = password;
		}
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * method to get whether the staff member is part of the onCall team or
	 * AandE team
	 * 
	 * @return
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * method to set whether the staff member is part of the onCall team or
	 * AandE team
	 * 
	 * @param
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * login method to allow the staff members to log into the system
	 */
	@Override
	public Staff login(String staffID, String password) {
		String url = "jdbc:mysql://web2.eeecs.qub.ac.uk/40108307";
		Connection con;
		Statement stmt;
		// loading driver
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
				String stfID = rs.getString("STAFF_ID");
				String staffPas = rs.getString("STAFF_PASSWORD");
				if (stfID.equals(staffID) && staffPas.equals(password)) {
					this.setStaffID(Integer.parseInt(rs.getString("STAFF_ID")));
					this.setTitle(rs.getString("TITLE"));
					this.setFirstName(rs.getString("FIRST_NAME"));
					this.setLastName(rs.getString("LAST_NAME"));
					this.setPassword(rs.getString("STAFF_PASSWORD"));
					this.setRole(rs.getString("STAFF_ROLE"));
					this.setTeam(rs.getString("STAFF_TEAM"));
					this.setEmail(rs.getString("EMAIL_ADDRESS"));
					this.setTelephone(rs.getString("TELEPHONE"));
					return this;
				}
			}
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return null;
	}

}
