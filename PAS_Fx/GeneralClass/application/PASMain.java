package application;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PASMain implements Runnable {

	/**
	 * create an instance of class room
	 */
	private TreatmentRoom treatmentRoom;
	
	/**
	 * creating an instance of the patient
	 */
	Patient patient;

	/**
	 * Array list of treatment rooms
	 */
	public ArrayList<TreatmentRoom> TreatmentRoomsList;

	/**
	 * linked list of patients within the a and e queue
	 */
	LinkedList<Patient> patientQueue;

	/**
	 * boolean to establish when the patient has finished treatment
	 */
	boolean finished = false;

	/**
	 * main method to launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		PASMain pas = new PASMain();
		pas.initialise();
		pas.testRun();
		pas.start();

	}

	/**
	 * method to start the thread for the whole system
	 */
	public void start() {
		System.out.println("Thread Starting..");
		Thread queueThread = new Thread(this);
		queueThread.start();
	}

	/**
	 * method to test the thread for the treatment rooms and return the patient
	 * in the room
	 */
	public void testRun() {

	}

	/**
	 * method to initialise variables
	 */
	public void initialise() {

		patientQueue = new LinkedList<Patient>();
		
		TreatmentRoomsList = new ArrayList<TreatmentRoom>(Constants.NUMBERS_OF_ROOM);
		
	}

	/**
	 * method to update the status of the treatment rooms
	 */
	public void updateTreatmentRoomsStatus(Patient patient) {
		Date currentDate = new Date();
		for (int loop = 0; loop < TreatmentRoomsList.size(); loop++) {
			if (TreatmentRoomsList.get(loop).getTimeOutOfTreatmentRoom().compareTo(currentDate) > 0)
				TreatmentRoomsList.get(loop).findEmptyTreatmentRoom(patient);
		}

	}

	/**
	 * final thread
	 */
	@Override
	public void run() {

		int i = 0;
		while (!finished) {

			try {
				Thread.sleep(5000);
				updateTreatmentRoomsStatus(patient);
				// movePatientToTopOfQueue(patientQueue, patient); ********** this needs fixed
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
			if (i > 10)
				finished = true;
		}

	}

}
