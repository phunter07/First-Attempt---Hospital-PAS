package application;

/**
 * class to control the on call team in situ
 */
import java.util.LinkedList;

public class InSitu {

	/**
	 * default constructor
	 */
	public InSitu() {

	}

	/**
	 * constructor with args
	 */

	public InSitu(Patient patient) {
		this.patient = patient;
	}

	/**
	 * instance var to hold emergency patient
	 */
	private Patient patient;

	/**
	 * method to allow the on call team to treat non-urgent patients in situ
	 * 
	 * @param patientQueue
	 * @param patient
	 */
	public static void controlInSitu(LinkedList<Patient> patientQueue,
			Patient patient) {

		// for loop to iterate through the queue and to return a patient with a
		// triage category of non urgent
		for (int loop = 0; loop <= patientQueue.size(); loop++) {
			if (patient.getTriageCategory() != Triage.EMERGENCY.getLevel()) {
				// remove patient from queue
				patientQueue.remove(patient);
				//put patient in situ
				//treat patient in situ
				//discharge patient
				// need to write patient leaving time to file
			}
		}
	}

	/**
	 * method to check if there is an emergency patient currently inSitu
	 * 
	 * @return
	 */
	public boolean checkEmergencyPatient() {
		if (getPatient() != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * method to set the patient object
	 * 
	 * @param patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;

	}

	/**
	 * method to return the patient object
	 * 
	 * @return
	 */
	public Patient getPatient() {
		return patient;
	}

}
