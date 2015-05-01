package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoctorTest {

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
	public void testDoctorDefaultConstructor() {
		Doctor doctor = new Doctor();
		assertNotNull(doctor);
	}

	/**
	 * testing  constructor with valid arguments
	 */
	@Test
	public void testDoctorConstructor() {
		Doctor doctor = new Doctor(validTitle, validFirstName, validLastName,
				validGender, validStaffID, validPassword);
		assertNotNull(doctor);
		assertEquals(validGender, doctor.getGender());
		assertEquals(validTitle, doctor.getTitle());
		assertEquals(validFirstName, doctor.getFirstName());
		assertEquals(validLastName, doctor.getLastName());
		assertEquals(validStaffID, doctor.getStaffID());
		assertEquals(validPassword, doctor.getPassword());
	}
	

	@Test
	public void testCategorisePatient() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecategorisePatient() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutPatientIntoQueue() {
		fail("Not yet implemented");
	}

}
