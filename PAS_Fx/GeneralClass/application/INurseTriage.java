package application;

import java.util.LinkedList;
import java.util.List;

public interface INurseTriage {
	
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
			String nhsNumber) throws HospitalPASException;
	
	/**
	 * method to allow the Triage Nurse to assign a category to a patient
	 * @throws HospitalPASException 
	 */
	public boolean categorisePatient(LinkedList<Patient> allPatients,LinkedList<Patient> patientQueue, Patient patient, Triage triage) throws HospitalPASException;
	
	/**
	 * method to allow the triage nurse to recategorise the patient triageCategory  
	 * @throws HospitalPASException 
	 */
	public boolean recategorisePatient(Patient patient, Triage triage) throws HospitalPASException;
	
	/**
	 * method to add the patient to the a and e queue once they have been triaged
	 * @param patientQueue
	 * @param patient
	 * @return
	 */
	public boolean putPatientIntoQueue(LinkedList <Patient> patientQueue, Patient patient);

}
