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
	public int compare(Patient p1, Patient p2) {
		if (p1.getWaitingTime() <= Limits.MOVE_TO_FRONT_MINUTES
				* Limits.MULTIPLY_MINUTES_TO_SECONDS * 1000
				&& p2.getWaitingTime() <= Limits.MOVE_TO_FRONT_MINUTES
						* Limits.MULTIPLY_MINUTES_TO_SECONDS * 1000) {
			if (Integer.compare(p1.getTriage(), p2.getTriage()) == 0) {
				return p1.getTimePatientJoinsQueue().compareTo(
						p2.getTimePatientJoinsQueue());
			} else {
				return Integer.compare(p1.getTriage(), p2.getTriage());
			}
		} else {
			if (p1.getTimePatientJoinsQueue().compareTo(
					p2.getTimePatientJoinsQueue()) == 0) {
				return Integer.compare(p1.getTriage(), p2.getTriage());
			} else {
				return p1.getTimePatientJoinsQueue().compareTo(
						p2.getTimePatientJoinsQueue());
			}
		}
	}

}
