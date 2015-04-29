package application;

/**
 * interface to be implemented by the receptionist to allow the receptionist to be registered by a and e
 */

import java.util.List;

import application.HospitalPASException;


public interface IReceptionist {
	

	/**
	 * Method to query the database and get and set the patients details
	 * 
	 * @param patient
	 * @return
	 */
	public boolean queryPAS(Patient patient);
	
	
	/**
	 * Method to check if the patient has already been registered to A and E by
	 * the receptionist
	 * 
	 * @param patientList
	 * @param patient
	 * @return
	 */
	public boolean isPatientRegistered(List<Patient> patientList,
			Patient patient);
	

	/**
	 * method to allow the receptionist to register the patient to a and e by pulling their details from the database
	 * @param patientList
	 * @param patient
	 * @throws HospitalPASException
	 */
	public void registerPatientToAandE(List<Patient> patientList,Patient patient) throws HospitalPASException;

}

