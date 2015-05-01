package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HospitalManagerTest {

	// test data
	String validTitle, invalidTitle, validFirstName, invalidFirstName,
			validLastName, invalidLastName, validPassword, invalidPassword,
			validEmail, invalidEmail;
	char validGender, invalidGender;
	int validStaffID, invalidStaffID, validContactNum, invalidContactNum;

	@Before
	public void setUp() throws Exception {
		validTitle = "ValidTitle";
		invalidTitle = null;
		validFirstName = "ValidFirstName";
		invalidFirstName = null;
		validLastName = "ValidLastName";
		invalidLastName = null;
		validPassword = "ValidPassword";
		invalidPassword = null;
		validGender = 'F';
		invalidGender = 'Y';
		validStaffID = 1001;
		invalidStaffID = -1;
		validEmail = "ValidEmail";
		invalidEmail = null;
		validContactNum = 12345;
		invalidContactNum = -1;
	}

	@Test
	public void testHospitalManagerDefaultConstructor() {
		HospitalManager hospitalManager = new HospitalManager();
		assertNotNull(hospitalManager);
	}

	/**
	 * testing constructor with valid arguments
	 */
	@Test
	public void testhospitalManagerConstructor() {
		HospitalManager hospitalManager = new HospitalManager(validTitle,
				validFirstName, validLastName, validGender, validStaffID,
				validPassword, validContactNum, validEmail);
		assertNotNull(hospitalManager);
		assertEquals(validGender, hospitalManager.getGender());
		assertEquals(validTitle, hospitalManager.getTitle());
		assertEquals(validFirstName, hospitalManager.getFirstName());
		assertEquals(validLastName, hospitalManager.getLastName());
		assertEquals(validStaffID, hospitalManager.getStaffID());
		assertEquals(validPassword, hospitalManager.getPassword());
		assertEquals(validContactNum, hospitalManager.getContactNum());
		assertEquals(validEmail, hospitalManager.getEmail());
	}

	/**
	 * test getters and setters for Email
	 */
	@Test
	public void testEmail() {
		String expected = validEmail;
		HospitalManager hospitalManager = new HospitalManager();
		hospitalManager.setEmail(expected);
		String actual = hospitalManager.getEmail();
		assertEquals(expected, actual);
	}

	/**
	 * test getters and setters for contactNum
	 */
	@Test
	public void testContactNum() {
		int expected = validContactNum;
		HospitalManager hospitalManager = new HospitalManager();
		hospitalManager.setContactNum(expected);
		int actual = hospitalManager.getContactNum();
		assertEquals(expected, actual);
	}

}
