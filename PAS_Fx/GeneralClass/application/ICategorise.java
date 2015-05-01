package application;

import java.util.LinkedList;
import java.util.Queue;

/**
 * interface containing the methods to allow both the Doctor and the TriageNurse
 * to categorise/recategorise a patient's condition
 * 
 * @author Hannah, Clare, Catherine
 *
 */

public interface ICategorise {

	/**
	 * method to initially categorise the patient when they arrive to the A and
	 * E - once the patient is categorised they are automatically added to the
	 * queue
	 * 
	 * @return
	 */
	public boolean categorisePatient(LinkedList<Patient> allPatients,
			LinkedList<Patient> patientQueue, Patient patient, Triage triage)
			throws HospitalPASException;

	/**
	 * method to change the category of the patient and automatically change
	 * their position in the queue - to be used by Triage Nurse and Doctor
	 * 
	 * @return
	 */
	public boolean recategorisePatient(LinkedList<Patient> patientQueue,
			Patient patient, Triage triage) throws HospitalPASException;

	/**
	 * method to add the patient to the a and e queue once they have been
	 * triaged
	 * 
	 * @param patientQueue
	 * @param patient
	 * @return
	 */
	public boolean putPatientIntoQueue(LinkedList<Patient> patientQueue,
			Patient patient);

}
