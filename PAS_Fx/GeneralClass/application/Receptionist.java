package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Receptionist extends Staff implements IReceptionist {

	/**
	 * default constructor
	 */
	public Receptionist() {
			
	}

	
	/**
	 * constructor with arguments
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param staffID
	 * @param password
	 */
	public Receptionist(String title, String firstName, String lastName, char gender,
			int staffID, String password) {
		super(title, firstName, lastName, gender, staffID, password);

	}

	public boolean queryPAS(Patient patient) {
		boolean queryPAS = false;
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

			// set these to constants
			ResultSet rs = stmt
					.executeQuery("select NHS_number,title, first_name,last_name,address,telephone,allergies,blood_group from PATIENT");
			while (rs.next()) {
				String nhs = rs.getString("NHS_number");
				if (nhs.equals(String.valueOf(patient.getNhsNumber()))) {
					patient.setTitle(rs.getString("title"));
					patient.setFirstName(rs.getString("first_name"));
					patient.setLastName(rs.getString("last_name"));
					patient.setAddress(rs.getString("address"));
					patient.setContactNum(rs.getString("telephone"));
					patient.setBloodGroup(rs.getString("blood_group"));
					patient.setAllergies(rs.getString("allergies"));
					queryPAS = true;
					break;
				} else {
					queryPAS = false;
				}
			}
			// close statement object
			stmt.close();
			// close connection
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return queryPAS;

	}
	

	/**
	 * Method to check if the patient has already been registered to A and E by
	 * the receptionist
	 * 
	 * @param patientList
	 * @param patient
	 * @return
	 */
	@Override
	public boolean isPatientRegistered(List<Patient> patientList,
			Patient patient) {
		for (Patient pa : patientList) {
			if (pa.getNhsNumber() == patient.getNhsNumber()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to register the Patient to A and E
	 * 
	 * @param prePatientQueue
	 *            -the prePatientQueue in PAS
	 * @param newPatient
	 *            -the new patient
	 * @throws HospitalPASException
	 *             -in the case of fail
	 */
	@Override
	public void registerPatientToAandE(List<Patient> patientList,
			Patient newPatient) throws HospitalPASException {

		if (patientList.size() < Limits.PATIENT_LIMIT_IN_PAS) {

			// creating the patient object with the details obtained from the
			// queryPAS method
			if (queryPAS(newPatient)) {

				// if statement to check if the patient being searched for
				// hasn't been registered to a and e already - if not the
				// patient is
				// added to the patient list - calling method
				// isPatientRegistered
				if (!isPatientRegistered(patientList, newPatient)) {
					patientList.add(newPatient);
				} else {
					// needs to be changed
					throw new HospitalPASException(ExceptionsEnums.PATIENTALREADYREGISTERED.getException());
				}
			} else {
				// new exceptions
				throw new HospitalPASException(ExceptionsEnums.PATIENTNOTINDATABASE.getException());
			}
		} else {
			// new exceptions
			throw new HospitalPASException(ExceptionsEnums.QUEUELIMITEXCEEDED.getException());
		}
	}

}
	

	