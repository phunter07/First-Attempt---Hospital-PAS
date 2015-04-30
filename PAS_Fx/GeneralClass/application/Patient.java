package application;

/**
 * Class containing the details of the Patient class to create the object to be used throughout the program 
 */

/**
 * importing the date class from java.util to set the times the patient enters and leaves a and e
 */
import java.util.Date;
import java.util.Random;

public class Patient extends Person {

	/**
	 * integer to allow the Triage nurse to allocate an unconscious patient an
	 * emergency NHSNumber
	 */
	private int emergencyNHSNumber;

	/**
	 * declaration of variable NHS number
	 */
	private int nhsNumber;

	/**
	 * declaration of variable address
	 */
	private String address;

	/**
	 * declaration of variable blood group
	 */
	private String bloodGroup;

	/**
	 * declaration of variable contact number
	 */
	private String contactNum;

	/**
	 * declaration of variable triageCategory
	 */
	private int triage;

	/**
	 * declaration of allergies
	 */
	private String allergies;

	/**
	 * declaration date arriveTime to take in the current date and time of when
	 * the patient enters the queue - after being triaged
	 */
	private Date timePatientJoinsQueue;

	/**
	 * declaration of date leaveTime to take in the current date and time of
	 * when the patient leaves the queue and enters a treatment room
	 */
	private Date leaveTime;

	/**
	 * declaration of instance variable to calculate the waiting time of the
	 * patient in the queue
	 */
	private long waitingTime;

	/**
	 * declaration of if the patient is pulledOutOfRoom
	 */
	private boolean pulledOutOfRoom;

	/**
	 * default constructor
	 */
	public Patient() {

	}

	/**
	 * constructor with arguments
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param nhsNumer
	 * @param bloodGroup
	 * @param contactNum
	 * @param timePatientJoinsQueue
	 * @param leaveTime
	 */
	public Patient(String title, String firstName, String lastName,
			char gender, int nhsNumber, String bloodGroup, String contactNum,
			Date timePatientJoinsQueue, Date leaveTime) {
		super(title, firstName, lastName, gender);
		this.nhsNumber = nhsNumber;
		this.bloodGroup = bloodGroup;
		this.contactNum = contactNum;
		this.timePatientJoinsQueue = timePatientJoinsQueue;
		this.leaveTime = leaveTime;
	}

	/**
	 * method to get the Triage Category of the patient
	 * 
	 * @return
	 */
	public int getTriage() {
		return triage;
	}

	/**
	 * method to get the NHSNumber of the patient
	 * 
	 * @return
	 */
	public int getNhsNumber() {
		return nhsNumber;
	}

	/**
	 * 
	 * method to set the NHSNumber of the patient
	 * 
	 * @param
	 */
	public void setNhsNumber(int nhsNumer) {
		this.nhsNumber = nhsNumer;
	}

	/**
	 * method to get the patients blood group
	 * 
	 * @return
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * method to set the patients blood group
	 * 
	 * @param string
	 */
	public void setBloodGroup(String string) {

		this.bloodGroup = string;
	}

	/**
	 * method to get the patients contact number
	 * 
	 * @return
	 */
	public String getContactNum() {
		return contactNum;
	}

	/**
	 * method to set the patients contact number
	 * 
	 * @param contactNum
	 */
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	/**
	 * method to get the patients allergies
	 * 
	 * @return
	 */
	public String getAllergies() {
		return allergies;
	}

	/**
	 * method to set the allergies
	 * 
	 * @param allergies
	 */
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	/**
	 * method to get the patients address
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * method to set the patients address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * method to get the arrival time of the patient into the queue
	 * 
	 * @return
	 */
	public Date getTimePatientJoinsQueue() {
		return timePatientJoinsQueue;
	}

	/**
	 * method to set the arrival time of the patient into the queue
	 * 
	 * @param arriveTime
	 */
	public void setTimePatientJoinsQueue(Date timePatientJoinsQueue) {
		this.timePatientJoinsQueue = timePatientJoinsQueue;
	}

	/**
	 * method to get the time the patient leaves the queue
	 * 
	 * @return
	 */
	public Date getLeaveTime() {
		return leaveTime;
	}

	/**
	 * method to set the time the patient leaves the queue
	 * 
	 * @param leaveTime
	 */
	public void setLeaveTime(Date leaveTime) {

		this.leaveTime = leaveTime;
	}

	/**
	 * method to get the waiting time of patient
	 * 
	 * @return double waitingTime
	 */

	/**
	 * @return the waitingTime
	 */
	public Long getWaitingTime() {
		if (this.getTimePatientJoinsQueue() != null) {
			this.waitingTime = new Date().getTime()
					- this.getTimePatientJoinsQueue().getTime();
		} else {
			this.waitingTime = 0;
		}
		return this.waitingTime;
	}

	/**
	 * method to get the triage category of the patient as a string
	 * 
	 * @return
	 */
	public int getTriageCategory() {

		return triage;
	}

	/**
	 * method to set the triage category of the patient as a string`
	 * 
	 * @param triageAsString
	 */
	public void setTriageCategory(Triage triageCategory) {

		switch (triageCategory) {
		case EMERGENCY:
			triage = Triage.EMERGENCY.getLevel();
			break;
		case URGENT:
			triage = Triage.URGENT.getLevel();
			break;
		case SEMI_URGENT:
			triage = Triage.SEMI_URGENT.getLevel();
			break;
		case NON_URGENT:
			triage = Triage.NON_URGENT.getLevel();
			break;
		default:
			triage = 0;
		}
	}

	/**
	 * method to return the boolean if the patient is pulled out of the
	 * Treatment room
	 * 
	 * @return
	 */
	public boolean isPulledOutOfRoom() {
		return pulledOutOfRoom;
	}

	/**
	 * method to set the boolean if the patient is puled out of the room
	 * 
	 * @param pulledOutOfRoom
	 */
	public void setPulledOutOfRoom(boolean pulledOutOfRoom) {
		this.pulledOutOfRoom = pulledOutOfRoom;
	}

	/**
	 * method to get the emergency NHS Number for the unconscious patient
	 * 
	 * @return
	 */
	public int getEmergencyNHSNumber() {
		return emergencyNHSNumber;
	}

	/**
	 * method to set the emergency NHS number for the unconscious patient
	 * 
	 * @param emergencyNHSNumber
	 */
	public void setEmergencyNHSNumber(int emergencyNHSNumber) {

		Random randomNHSNumber = new Random();

		for (int loop = 0; loop <= Limits.PATIENT_LIMIT_IN_PAS; loop++) {
			emergencyNHSNumber = (randomNHSNumber.nextInt(8000) + 1000);
		}
		this.emergencyNHSNumber = emergencyNHSNumber;
	}

	/**
	 * method to override the toString() method to display the Patient details
	 * used within the GUI
	 */
	@Override
	public String toString() {
		return "Patient [nhsNumber=" + nhsNumber + ", address=" + address
				+ ", bloodGroup=" + bloodGroup + ", contactNum=" + contactNum
				+ ", triage=" + triage + ", allergies=" + allergies
				+ ", timePatientJoinsQueue=" + timePatientJoinsQueue
				+ ", leaveTime=" + leaveTime + ", waitingTime=" + waitingTime
				+ ", pulledOutOfRoom=" + pulledOutOfRoom + "]" + "\n";
	}

}
