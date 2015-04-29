package application;

/**
 * class to sort the queue based on Triage category 
 * implementing the Comparator interface
 */

import java.util.Collections;
import java.util.Comparator;

public class SortPatientComparator implements Comparator<Patient> {

	/**
	 * method to override the compare method from the comparator class to
	 * compare the patient objects
	 */
	@Override
	public int compare(Patient patient2, Patient patient1) {

		// return statement to compare the patient triage categories in the
		// queue - to be called in the add to queue method
		return Integer.compare(patient2.getTriageCategory(),
				patient1.getTriageCategory());

	}

}
