package application;

/**
 * Class to contain the details of the Doctor
 *
 */

public class Doctor extends Staff implements ILogin, ICategorise {

	/**
	 * Default constructor for Doctor Class
	 */
	public Doctor() {

	}
	

	/**
	 * constructor with arguments for doctor Class
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param staffID
	 * @param password
	 */
	public Doctor(String title, String firstName, String lastName, char gender,
			int staffID, String password) {
		super(title, firstName, lastName, gender, staffID, password);

	}


	/**
	 * unimplemented method - to be used only in the NurseTriage Class
	 */
	@Override
	public boolean categorisePatient(Patient patient, Triage category)
			throws HospitalPASException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean recategorisePatient(Patient patient, Triage triage)
			throws HospitalPASException {
		if (patient != null) {
			patient.setTriageCategory(triage);
			return true;
		} else {
			throw new HospitalPASException(ExceptionsEnums.CANTRECOGNISEPATIENT);
		}
	}

}