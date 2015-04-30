package application;

/**
 * Class containing the staff database connection and method to display all staff - to be implemented by Hospital manager
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBController {

	/**
	 * method to return the AllStaffList for the Hspital Manager GUI screen
	 * @return
	 */
	private static List<Staff> getAllStaff() {
		List<Staff> allStaff = new ArrayList<Staff>();
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
			con = DriverManager.getConnection(url, DatabaseENums.DATABASEUSERNAME.getDatabase(), DatabaseENums.DATABASEPASSWORD.getDatabase());
			// create a statement object
			stmt = con.createStatement();
			// supply the statement object with a string to execute
			Staff staff = new Staff();
			ResultSet rs = stmt.executeQuery(DatabaseENums.DATABASESTAFFSELECTQUERY.getDatabase());
			while (rs.next()) {
				staff.setStaffID(Integer.parseInt(rs.getString(DatabaseENums.DATABASESTAFFID.getDatabase())));
				staff.setTitle(rs.getString(DatabaseENums.DATABASESTAFFTITLE.getDatabase()));
				staff.setFirstName(rs.getString(DatabaseENums.DATABASESTAFFFIRSTNAME.getDatabase()));
				staff.setLastName(rs.getString(DatabaseENums.DATABASESTAFFLASTNAME.getDatabase()));
				staff.setPassword(rs.getString(DatabaseENums.DATABASESTAFFPASSWORD.getDatabase()));
				staff.setRole(rs.getString(DatabaseENums.DATABASESTAFFROLE.getDatabase()));
				staff.setTeam(rs.getString(DatabaseENums.DATABASESTAFFTEAM.getDatabase()));
				staff.setEmail(rs.getString(DatabaseENums.DATABASESTAFFEMAIL.getDatabase()));
				staff.setTelephone(rs.getString(DatabaseENums.DATABASESTAFFTELEPHONE.getDatabase()));
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
