package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReceptionistTest {
	// test data
	String validTitle, invalidTitle, validFirstName, InvalidFirstName,
			validLastName, invalidLastName, validPassword, InvalidPassword;
	char validGender, invalidGender;
	int validStaffID, invalidStaffID;

	@Before
	public void setUp() throws Exception {
		validTitle = "ValidTitle";
		invalidTitle = null;
		validFirstName = "ValidFirstName";
		InvalidFirstName = null;
		validLastName = "ValidLastName";
		invalidLastName = null;
		validPassword = "ValidPassword";
		InvalidPassword = null;
		validGender = 'F';
		invalidGender = 'Y';
		validStaffID = 1001;
		invalidStaffID = -1;
	}

	@Test
	public void testReceptionistDefaultConstructor() {
		Receptionist receptionist = new Receptionist();
		assertNotNull(receptionist);
	}


	/**
	 * testing  constructor with valid arguments
	 */
	@Test
	public void testReceptionistConstructor() {
		Receptionist receptionist = new Receptionist(validTitle, validFirstName, validLastName,
				validGender, validStaffID, validPassword);
		assertNotNull(receptionist);
		assertEquals(validGender, receptionist.getGender());
		assertEquals(validTitle, receptionist.getTitle());
		assertEquals(validFirstName, receptionist.getFirstName());
		assertEquals(validLastName, receptionist.getLastName());
		assertEquals(validStaffID, receptionist.getStaffID());
		assertEquals(validPassword, receptionist.getPassword());
	}
	
	
	

	@Test
	public void testQueryPAS() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsPatientRegistered() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegisterPatientToAandE() {
		fail("Not yet implemented");
	}

}
