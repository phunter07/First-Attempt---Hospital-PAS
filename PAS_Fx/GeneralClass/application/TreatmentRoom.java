package application;

/**
 * Class to set the values of the treatment rooms
 */

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class TreatmentRoom {

	/**
	 * variable to get the treatment room number
	 */
	private int roomNumber;

	/**
	 * boolean to indicate if the room is vacant
	 */
	private boolean vacant = true;

	/**
	 * Date to calculate the patient time into the treatment room
	 */
	private Date timeInTreatmentRoom;

	/**
	 * Date to calculate the patient time out of the treatment room
	 */
	private Date timeOutOfTreatmentRoom;

	/**
	 * boolean to show if patient treated
	 */
	public boolean patientTreated;

	/**
	 * instance var to declare the patient in the treatment room
	 */
	Patient patientInTreatmentRoom;

	public Date getTimeInTreatmentRoom() {
		return timeInTreatmentRoom;
	}

	public void setTimeInTreatmentRoom(Date timeInTreatmentRoom) {
		this.timeInTreatmentRoom = timeInTreatmentRoom;
	}

	public Date getTimeOutOfTreatmentRoom() {
		timeOutOfTreatmentRoom.setTime(timeInTreatmentRoom.getTime()
				+ TimeUnit.MINUTES.toMillis(Limits.TIME_IN_TREATMENT_ROOM));
		return timeOutOfTreatmentRoom;
	}

	public void setTimeOutOfTreatmentRoom(Date timeOutOfTreatmentRoom) {
		this.timeOutOfTreatmentRoom = timeOutOfTreatmentRoom;
		patientTreated = true;
	}

	public boolean isVacant() {
		return vacant;
	}

	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * method to allow extra time to be allocated to treatment rooms
	 */
	public void allocateExtraTime() {

		timeOutOfTreatmentRoom.setTime(timeOutOfTreatmentRoom.getTime()
				+ TimeUnit.MINUTES.toMillis(Limits.EXTENDED_TIME));

	}

	/**
	 * method to establish whether a treatment room is free
	 */
	public void findEmptyTreatmentRoom(Patient patient) {
		vacant = true;
		patient = null;
	}

	/**
	 * method to get the Traige Category of the patient in the Treatment room
	 * 
	 * @param patient
	 * @return
	 */
	public int getPatientTriageCategory(Patient patient) {

		return patient.getTriageCategory();
	}

	/**
	 * method to get the patient into the treatment treatment room
	 * 
	 * @param patientQueue
	 * @param patient
	 * @return
	 */
	public Patient getPatientInTreatmentRoom(Patient patient) {

		return patientInTreatmentRoom;
	}

	public void setPatientInTreatmentRoom(Patient patientInTreatmentRoom) {
		this.patientInTreatmentRoom = patientInTreatmentRoom;
	}

}