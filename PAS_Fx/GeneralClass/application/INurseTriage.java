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
	
	
	
}
