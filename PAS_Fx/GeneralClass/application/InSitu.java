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
			if (patient.getTriageCategory() == Triage.NON_URGENT.getLevel()) {
				
				//remove patient from queue
				patientQueue.remove(patient);
				//need to write patient leaving time to file 
			}
		}

	}

}
