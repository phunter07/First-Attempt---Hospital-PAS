package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class staffDatabase {

	
	private static List<Staff> getAllStaff() {
		List<Staff> allStaff = new ArrayList<Staff>();
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
			Staff staff = new Staff();
			ResultSet rs = stmt.executeQuery("select * from STAFF");
			while (rs.next()) {
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
	
}
