package application;

/**
 * Class containing the details for the Hospital Manager
 *
 */

public class HospitalManager extends Staff implements IHospitalManager {

	/**
	 * instance variable for the hospital manager contact number to send SMS Alerts to 
	 */
	private int contactNum;
	
	/**
	 * instance variable for the hospital manager email address to send email alerts to
	 */
	private String email;

	/**
	 * default constructor for Hospital Manager
	 */
	public HospitalManager() {

	}

	/**
	 * Constructor with arguments for Hospital manager
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param staffID
	 * @param password
	 * @param contactNum
	 * @param email
	 */
	public HospitalManager(String title, String firstName, String lastName,
			char gender, int staffID, String password, int contactNum,
			String email) {
		super(title, firstName, lastName, gender, staffID, password);
		this.contactNum = contactNum;
		this.email = email;
	}

	/**
	 * method to get contact number
	 * @return
	 */
	public int getContactNum() {
		return contactNum;
	}
	
	/**
	 * method to set contact number
	 */
	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}

	/**
	 * method to get the email address for the Hospital manager
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * method to set the email address for the Hospital manager
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void viewAllStaff() {
		// TODO Auto-generated method stub
		
	}


	
}
