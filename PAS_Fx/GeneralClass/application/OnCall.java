package application;

import java.util.LinkedList;

public class OnCall {

	private boolean onCallEngaged1=false;
	
	private boolean onCallEngaged2=false;

	private InSitu inSitu;

	private Patient patient;


	/**
	 * method to check if there are emergency patients waiting to be treated
	 * inSitu if the onCall team have been called and if there are none the
	 * onCall team begin treating patients from the Queue
	 */
	public void checkInSituForEmergencyPatients() {
		if ((onCallEngaged1 == true) && (inSitu.checkEmergencyPatient() == false)&&(onCallEngaged2 == true)) {
			InSitu.controlInSitu(GUIMain.patientQueue, patient);
		} else {
			treatEmergency();
		}
	}
	
	public void treatEmergency(){
		inSitu.getPatient();
		inSitu.setPatient(null);
	}

	public boolean isOnCallEngaged1() {
		return onCallEngaged1;
	}

	public void setOnCallEngaged1(boolean onCallEngaged1) {
		this.onCallEngaged1 = onCallEngaged1;
	}

	public boolean isOnCallEngaged2() {
		return onCallEngaged2;
	}

	public void setOnCallEngaged2(boolean onCallEngaged2) {
		this.onCallEngaged2 = onCallEngaged2;
	}
}
