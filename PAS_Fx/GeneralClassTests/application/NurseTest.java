package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NurseTest {
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
	
	/**
	 * testing the default constructor
	 */
	@Test
	public void testNurseDefaultConstructor(){
		Nurse nurse = new Nurse();
		assertNotNull(nurse);
	}

	/**
	 * testing constructor with valid arguments
	 */
	@Test
	public void testNurseConstructor() {
		Nurse nurse = new Nurse(validTitle, validFirstName, validLastName,
				validGender, validStaffID, validPassword);
		assertNotNull(nurse);
		assertEquals(validGender, nurse.getGender());
		assertEquals(validTitle, nurse.getTitle());
		assertEquals(validFirstName, nurse.getFirstName());
		assertEquals(validLastName, nurse.getLastName());
		assertEquals(validStaffID, nurse.getStaffID());
		assertEquals(validPassword, nurse.getPassword());
	}

}
