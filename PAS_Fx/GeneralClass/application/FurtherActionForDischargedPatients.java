package application;

/**
 * ENums to hold the further action for patients who have been discharged from A
 * and E - to be set by the Doctor. A reflection of how the system could be
 * extended. These will be written to file and stored in the patients records
 *
 */

public enum FurtherActionForDischargedPatients {

	DECEASED("Patient has passed away"), REFERRED(
			"This patient has been referred"), WARDS(
			"Patient recovering in wards"), THEATRE(
			"Patient transferred to theatre"), DISCHARGED("Patient treated");

	
	private String furtherAction;
	
	
	private FurtherActionForDischargedPatients(String furtherAction) {
		this.furtherAction = furtherAction;
	}

	public String getFurtherAction() {
		return furtherAction;
	}

	public void setFurtherAction(String furtherAction) {
		this.furtherAction = furtherAction;
	}

}

