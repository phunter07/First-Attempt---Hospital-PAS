package application;

/**
 * JDoe interface to allocate emergency details to a patient who arrives while
 * unconscious. To be implemented by TriageNurse
 *
 */

public interface IJDoe {

	/**
	 * method to allocate a NHS Number to an unconscious patient - incrementing
	 * values
	 * 
	 * @return
	 */
	public void allocateDetailsJDoeNUM(Patient patient);


	
	
}
