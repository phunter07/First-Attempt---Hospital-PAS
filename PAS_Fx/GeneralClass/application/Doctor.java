package application;

import java.util.LinkedList;

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
	public boolean categorisePatient(LinkedList<Patient> allPatients,LinkedList<Patient> patientQueue,  Patient patient, Triage triage)
			throws HospitalPASException {
		// creating an integer wrapper to all to check if the getTraigeCategory
				// is a null value
				Integer patientTriage = patient.getTriageCategory();

				// if statement to check if the triage category has not been set - and
				// if so sets triage category
				if (patientTriage == 0) {
					patient.setTriageCategory(triage);
					// method to automatically add patient to queue once they are
					// categorised by the triage nurse
					if (putPatientIntoQueue(patientQueue, patient)) {
						return true;
					} else {
						allPatients.remove(patient);
						new SMSAlerts().sendSMSToOnCallTeam();
						throw new HospitalPASException(
								ExceptionsEnums.QUEUELIMITEXCEEDED.getException());
						
					}
				} else {
					throw new HospitalPASException(
							ExceptionsEnums.PATIENTALREADYTRIAGED.getException());
				}
			}


	@Override
	public boolean recategorisePatient(LinkedList<Patient> patientQueue, Patient patient, Triage triage)
			throws HospitalPASException {
		if (patient != null) {
			patient.setTriageCategory(triage);
			// sorts the patient queue by triage category
						patientQueue.sort(new SortPatientComparator());
			return true;
		} else {
			throw new HospitalPASException(ExceptionsEnums.CANTRECOGNISEPATIENT.getException());
		}

	}


	@Override
	public boolean putPatientIntoQueue(LinkedList<Patient> patientQueue,
			Patient patient) {
		boolean inQueue = false;

		if (patientQueue.size() < Limits.PATIENT_LIMIT_IN_QUEUE) {
			// adds patient to queue
			patientQueue.add(patient);
			// sorts the patient queue by triage category
			patientQueue.sort(new SortPatientComparator());
			inQueue = true;
		}

		return inQueue;
	}

}