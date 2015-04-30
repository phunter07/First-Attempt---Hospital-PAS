package application;

import java.util.LinkedList;

public class OnCall {

	private boolean onCall;

	private InSitu inSitu;

	private Patient patient;

	public boolean isOnCall() {
		return onCall;
	}

	public void setOnCall(boolean onCall) {
		this.onCall = onCall;
	}

	/**
	 * method to check if there are emergency patients waiting to be treated
	 * inSitu if the onCall team have been called and if there are none the
	 * onCall team begin treating patients from the Queue
	 */
	public void checkInSituForEmergencyPatients() {
		if ((onCall == true) && (inSitu.checkEmergencyPatient() == false)) {
			InSitu.controlInSitu(GUIMain.patientQueue, patient);
		} else {
			treatEmergency();
		}
	}
	
	public void treatEmergency(){
		inSitu.getPatient();
		inSitu.setPatient(null);
	}
}
