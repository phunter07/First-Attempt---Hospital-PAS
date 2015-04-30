package application;

/**
 * Class containing the constants to be used within the system. It was decided
 * that these should not be ENums as a group because they are not a fixed set of
 * constants as the Requirements specification states that the A and E should be
 * able to be expanded
 * 
 * 
 */

public class Limits {

	/**
	 * Constant to set the Refresh time of the Thread (in miliseconds)
	 */
	public final static int REFRESHTIME = 1000;

	/**
	 * Constant to limit the number of patients in the PAS in order to control
	 * risks
	 */
	public final static int PATIENT_LIMIT_IN_PAS = 100;

	/**
	 * Constant to control the upper limit of the patient queue
	 */
	public static final int PATIENT_LIMIT_IN_QUEUE = 4;

	/**
	 * Constant in order to allow the patient waiting time to be converted to
	 * minutes
	 */
	public static final int MULTIPLY_MINUTES_TO_SECONDS = 60;

	/**
	 * Constant to determine the number of minutes a patient has been waiting in
	 * the queue before they have to be moved to the front
	 */
	public static final int MOVE_TO_FRONT_MINUTES = 2;

	/**
	 * Constant to set the upper limit of the waiting time in the queue in
	 * minutes
	 */
	public static final int UPPERMINUTES_QUEUE_LIMIT = 10;

	/**
	 * Constant for the Number of Treatment rooms within the Hospital
	 */
	public final static int NUMBERS_OF_ROOM = 5;

	/**
	 * Constant to set the time in the treatment room
	 */
	public final static int TIME_IN_TREATMENT_ROOM = 10;

	/**
	 * Constant to set the extended time to be allocated
	 */
	public final static int EXTENDED_TIME = 5;
}
