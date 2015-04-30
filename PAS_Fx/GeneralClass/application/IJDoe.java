package application;

import java.util.LinkedList;

/**
 * JDoe interface to allocate emergency details to a patient who arrives while
 * unconscious. To be implemented by TriageNurse
 *
 */

public interface IJDoe {

	/**
	 * method to allocate emergency details to an unconscious patient -
	 * incrementing values
	 * 
	 * @return
	 */
	public void allocateJDoeDetails(LinkedList<Patient> patientQueue, Patient patient, int GenderSwap);

}
