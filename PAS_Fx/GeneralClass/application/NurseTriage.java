package application;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * class containing the details of the TiageNurse
 *
 */

public class NurseTriage extends Staff implements INurseTriage, IJDoe {

	/**
	 * default constructor
	 */
	public NurseTriage() {

	}

	/**
	 * constructor with arguments to obtain the details of the Triage Nurse
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param staffID
	 * @param password
	 */
	public NurseTriage(String title, String firstName, String lastName,
			char gender, int staffID, String password) {
		super(title, firstName, lastName, gender, staffID, password);

	}

	/**
	 * method to allow the Triage Nurse to select a patient who needs to be
	 * assigned a Triage category
	 * 
	 * @param patientList
	 * @param nhsNumber
	 * @return
	 * @throws HospitalPASException
	 */
	public Patient findPatientByNhsNumber(List<Patient> patientList,
			String nhsNumber) throws HospitalPASException {
		try {
			int nhs = Integer.parseInt(nhsNumber);
			for (Patient patient : patientList) {

				if (patient.getNhsNumber() == nhs) {
					return patient;
				}
			}
		} catch (NumberFormatException e) {
			throw new HospitalPASException(ExceptionsEnums.NHSNUMBEREXCEPTION);
		}
		return null;
	}

	/**
	 * method to allow the Triage Nurse to assign a category to a patient
	 */
	@Override
	public boolean categorisePatient(LinkedList<Patient> allPatients,LinkedList<Patient> patientQueue,
			Patient patient, Triage triage) throws HospitalPASException {

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
				throw new HospitalPASException(
						ExceptionsEnums.QUEUELIMITEXCEEDED);
				
			}
		} else {
			throw new HospitalPASException(
					ExceptionsEnums.PATIENTALREADYTRIAGED);
		}
	}

	/**
	 * method to allow the triage nurse to recategorise the patient
	 * triageCategory
	 */
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

	/**
	 * method to add the patient to the a and e queue once they have been
	 * triaged
	 * 
	 * @param patientQueue
	 * @param patient
	 * @return
	 */
	@Override
	public boolean putPatientIntoQueue(LinkedList<Patient> patientQueue,
			Patient patient) {

		boolean inQueue = false;

		if (patientQueue.size() < Constants.PATIENT_LIMIT_IN_QUEUE) {
			// adds patient to queue
			patientQueue.add(patient);
			// sorts the patient queue by triage category
			patientQueue.sort(new SortPatientComparator());
			inQueue = true;
		}

		return inQueue;
	}

	@Override
	public void allocateDetailsJDoe(Patient patient) {

		if (patient.getFirstName().isEmpty() && patient.getLastName().isEmpty()) {
			Integer emergencyNhsNumber = new Integer(0000);
			emergencyNhsNumber = emergencyNhsNumber++;

			patient.setFirstName("J");
			patient.setLastName("Doe");
			patient.setNhsNumber(emergencyNhsNumber);

		}
	}

	/**
	 * method to allow a TriageNurse to extract the patient needed to be triage
	 * from all patient in PAS system
	 * 
	 * @author 
	 * @param emergencyPatient
	 * @param treatmentRooms
	 * @param patientQueue
	 * @return
	 */
	public void findPatientNeededToBeTriage(
			List<Patient> patientNeededToBeTriage, List<Patient> allPatientList) {
		for (Patient patient : allPatientList) {
			if (patient.getTriageCategory() == 0) {
				patientNeededToBeTriage.add(patient);
			}
		}
	}
	
	/**
	 * method to allow a TriageNurse to extract the patient needed to be altered
	 * from all patient in PAS system
	 * 
	 * @author 
	 * @param emergencyPatient
	 * @param treatmentRooms
	 * @param patientQueue
	 * @return
	 */
	public void findPatientNeededToBeAltered(
			List<Patient> patientNeededToBeAltered, List<Patient> allPatientList) {
		for (Patient patient : allPatientList) {
			if (patient.getTriageCategory() != 0) {
				patientNeededToBeAltered.add(patient);
			}
		}
	}

}
