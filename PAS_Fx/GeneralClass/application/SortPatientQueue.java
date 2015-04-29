package application;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * The comparator class is used to take in the details of the queue and compare
 * waiting times for all patients in the A and E queue. If a patient has been
 * waiting over 25 minutes they are automatically bumped to the top of the queue
 *
 */
public class SortPatientQueue {

	/**
	 * creating an instance of Manager Email alerts
	 */
	private ManagerEmailAlert managerEmailAlert;

	/**
	 * creating an instance of the SMSAlerts Class to be called
	 */
	private SMSAlerts smsAlerts;

	/**
	 * boolean to state if the on call team are engaged in situ
	 */
	public boolean OnCallEngaged = false;

	/**
	 * default constructor for SortPatientComparator Class
	 */
	public SortPatientQueue() {
	}

	/**
	 * Method to compare the argument of the Patients so that they can be
	 * ordered. It returns a negative integer, zero, or a positive integer if
	 * the first argument is less than, equal to, or greater than the second,
	 * respectively. This will automatically move the patient who has been
	 * waiting 25minutes or more to the top of the queue
	 */
	/**
	 * method to allow a patient who has been waiting 25 minutes to be moved to
	 * top of queue
	 */
	public void movePatientToTopOfQueue(LinkedList<Patient> patientQueue) {

		// initialising long to get the patient time in the queue
		long patientTimeInQueue = 0;

		// long to calculate the current date and time
		long currentTime = new Date().getTime();

		// long for the difference between the current date and time and the
		// time the patient joined the queue
		long minutes = 0;

		for (int loop = 0; loop < patientQueue.size(); loop++) {
			patientTimeInQueue = patientQueue.get(loop)
					.getTimePatientJoinsQueue().getTime();
			minutes = TimeUnit.MILLISECONDS.toMinutes(currentTime
					- patientTimeInQueue);
			if (minutes <= Constants.MOVE_TO_FRONT_MINUTES
					* Constants.MULTIPLY_MINUTES_TO_SECONDS) {
				patientQueue.sort(new SortPatientComparator());

			} else {
				patient = patientQueue.get(loop);
				patientQueue.remove(loop);
				patientQueue.addFirst(patient);
			}

		}
	}

	/**
	 * method to send the SMS and Email Alert to the hospital manager if two
	 * patients have been waiting 30 minutes or more
	 * 
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public void thirtyMinuteManagerAlert(LinkedList<Patient> patientQueue)
			throws AddressException, MessagingException {

		// initialising long to get the patient time in the queue
		long patientTimeInQueue = 0;

		// long to calculate the current date and time
		long currentTime = new Date().getTime();

		// long for the difference between the current date and time and the
		// time the patient joined the queue
		long minutes = 0;

		// int to count the number of patients waiting 30 minutes
		int counter = 0;

		for (int loop = 0; loop < patientQueue.size(); loop++) {
			patientTimeInQueue = patientQueue.get(loop)
					.getTimePatientJoinsQueue().getTime();
			minutes = TimeUnit.MILLISECONDS.toMinutes(currentTime
					- patientTimeInQueue);
			if (minutes >= Constants.UPPERMINUTES_QUEUE_LIMIT
					* Constants.MULTIPLY_MINUTES_TO_SECONDS) {
				counter++;
				if (counter == 2) {
					managerEmailAlert
							.generateAndSendEmailPatientsWaitingThirtyMinutes();
					smsAlerts.sendSSMSManagerTwoPatientsWaitingThirtyMinutes();

				}

			}
		}

	}

	/**
	 * method to calculate the number of patients in the queue and to send an
	 * SMS to the onCall team should the queue capacity reach 10
	 */

	public boolean calculateQueueSize(LinkedList<Patient> patientQueue) {

		if (patientQueue.size() >= Constants.PATIENT_LIMIT_IN_QUEUE) {
			// if the queue is >= 10 then calling method to send non-emergency
			// patients to the nearest hospital
			// sendToNearestHospital(patientQueue, patient);
			// if the queue is >= 10 calling method to send SMS to OnCall team
			smsAlerts.sendSMSToOnCallTeam();
			return true;
		}
		return false;
	}

	/**
	 * method to redirect a non emergency patient to the nearest hospital if the
	 * queue reached maximum capacity
	 * 
	 * @param patient
	 */
	public void sendToNearestHospital(LinkedList<Patient> patientQueue,
			Patient patient) {

		// if statement to check if the Triage Category as an integer value is
		// equal to the Emergency level
		// if they patient is not an emergency patient they are redirected to
		// the nearest hospital - to be implemented in the calculate queue size
		// method
		if ((patientQueue.size() >= Constants.PATIENT_LIMIT_IN_QUEUE)
				&& (patient.getTriageCategory() != Triage.EMERGENCY.getLevel())
				&& (OnCallEngaged == true)) {
			// not sure where this should be shown - should it be a pop up on
			// Receptionist/triage Nurse Screen
			managerEmailAlert.sendSSMSManagerOnCallFullyEngaged();
			smsAlerts.sendSSMSManagerOnCallFullyEngaged();
		}

	}

	/**
	 * method to allocate an emergency patient to a room and remove the non
	 * emergency patient in the room
	 * 
	 * Also sorts the queue according to triageCategory
	 * 
	 * @param patient
	 * @return
	 */
	public boolean pushEmergencyPatientIntoTreatmentRoom(
			LinkedList<Patient> patientQueue, Patient patient,
			List<TreatmentRoom> treatmentRooms) {

		// boolean to check if a free treatment room is available
		boolean isRoomAvailable = false;

		// needs to be -1 as the array list of rooms begins with an index of 0
		int treatmentRoom = 0;

		// initialising the int to get the category of the patient currently in
		// the treatment room
		int currentPatientTriageCategory = 0;

		// date to get the current date and time
		Date currentTime = new Date();
		TreatmentRoom room = findEmptyTreatmentRoom(treatmentRooms);
		if (room != null) {
			room.setPatientInTreatmentRoom(patient);
			room.setVacant(false);
			return true;
		}

		// for loop to iterate through the treatment rooms and check if a
		// non-emergency patient can be removed to allow an emergency patient to
		// be put in - starts at 0 because the array list of treatment rooms
		// beings with an index of 0

		for (int loop = 0; loop < treatmentRooms.size(); loop++) {

			// get the room in the array list of treatment rooms that does not
			// contain an emergency patient. If the triage category of the
			// patient in the treatment room
			// if greater than the current patient's triage category then set
			// the reference of the treatmentRoom to the loop
			if (!(treatmentRooms.get(loop).getPatientTriageCategory(patient) == Triage.EMERGENCY
					.getLevel())) {
				// if statement to find the highest category in the treatment
				// room list and set the highest category of patient into the
				// patient room
				if (treatmentRooms.get(loop).getPatientInTreatmentRoom(patient)
						.getTriageCategory() > currentPatientTriageCategory) {
					treatmentRoom = loop;
					currentPatientTriageCategory = treatmentRooms.get(loop)
							.getPatientTriageCategory(patient);

					currentTime = treatmentRooms.get(loop)
							.getPatientInTreatmentRoom(patient)
							.getTimePatientJoinsQueue();

				} else if ((treatmentRooms.get(loop)
						.getPatientInTreatmentRoom(patient).getTriageCategory() == currentPatientTriageCategory)
						&& (treatmentRooms.get(loop)
								.getPatientInTreatmentRoom(patient)
								.getTimePatientJoinsQueue()
								.compareTo(currentTime) > 0)) {
					treatmentRoom = loop;
					currentPatientTriageCategory = treatmentRooms.get(loop)
							.getPatientTriageCategory(patient);
					currentTime = treatmentRooms.get(loop)
							.getPatientInTreatmentRoom(patient)
							.getTimePatientJoinsQueue();
				}
			}

		}

		if (treatmentRoom != 0) {
			patientQueue.addFirst(treatmentRooms.get(treatmentRoom)
					.getPatientInTreatmentRoom(patient));
			patientBeingTreated(patient, treatmentRoom, treatmentRooms);
			isRoomAvailable = true;
		}
		return isRoomAvailable;
	}

	/**
	 * method to allocate a patient to a treatment room from the queue
	 * 
	 * @param patient
	 */
	public boolean allocatePatientToTreatmentRoom(
			LinkedList<Patient> patientQueue, Patient patient,
			List<TreatmentRoom> treatmentRooms) {

		// for loop to iterate through the list of treatment rooms and find an
		// available treatment room
		if (patient != null) {
			for (int loop = 0; loop < treatmentRooms.size(); loop++) {
				// if statement to see if the treatment room is empty
				if (treatmentRooms.get(loop).isVacant() == true) {

					// removes the first patient from the queue
					patientQueue.poll();
					// setting the treatment room to occupied
					treatmentRooms.get(loop).setVacant(false);
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * method to add the patient to treatment room to allow them to be treated
	 * 
	 * @param patient
	 * @param roomNumber
	 */
	public void patientBeingTreated(Patient patient, int roomNumber,
			List<TreatmentRoom> treatmentRooms) {

		// gets the room number from the array list and the patient in the
		// treatment room to display their details of who is in what room
		treatmentRooms.get(roomNumber).setPatientInTreatmentRoom(patient);

	}

	/**
	 * method to send an emergency patient to another hospital if you cannot
	 * place them into a treatment room i.e. all treatment rooms are already
	 * filled with emergency patients
	 * 
	 * ******* put 15 minute timer in here for on call team *******
	 * 
	 * @param patient
	 * @return
	 */
	public boolean redirectEmergencyPatient(LinkedList<Patient> patientQueue,
			Patient patient, List<TreatmentRoom> treatmentRooms) {

		// if you are unable to put emergency patient into a treatment room then
		// alert on call team
		if (!pushEmergencyPatientIntoTreatmentRoom(patientQueue, patient,
				treatmentRooms)) {
			smsAlerts.sendSMSToOnCallTeam();
			OnCallEngaged = true;
			// maybe
			InSitu.controlInSitu(patientQueue, patient);
			return false;
		}
		return true;
	}

	public TreatmentRoom findEmptyTreatmentRoom(List<TreatmentRoom> rooms) {
		for (int loop = 0; loop < rooms.size(); loop++) {
			if (rooms.get(loop).isVacant() == true) {
				return rooms.get(loop);

			}
		}
		return null;
	}

}
