package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StaffTest {

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
	public void testStaffDefaultConstructor() {
		Staff staff = new Staff();
		assertNotNull(staff);
	}

	@Test
	public void testStaffStringStringStringCharIntString() {
		/**
		 * testing constructor with valid arguments
		 */
		Staff staff = new Staff(validTitle, validFirstName, validLastName,
				validGender, validStaffID, validPassword);
		assertNotNull(staff);
		assertEquals(validGender, staff.getGender());
		assertEquals(validTitle, staff.getTitle());
		assertEquals(validFirstName, staff.getFirstName());
		assertEquals(validLastName, staff.getLastName());
		assertEquals(validStaffID, staff.getStaffID());
		assertEquals(validPassword, staff.getPassword());
	}

	@Test
	public void testStaffID() {
		int expected = 1234;
		Staff staff = new Staff();
		staff.setStaffID(expected);
		int actual = staff.getStaffID();
		assertEquals(expected, actual);
	}

	@Test
	public void testPassword() {
		String expected = "password";
		Staff staff = new Staff();
		staff.setPassword(expected);
		String actual = staff.getPassword();
		assertEquals(expected, actual);
	}

	@Test
	public void testRole() {
		String expected = "Nurse";
		Staff staff = new Staff();
		staff.setRole(expected);
		String actual = staff.getRole();
		assertEquals(expected, actual);
	}

	@Test
	public void testEmail() {
		String expected = validEmail;
		Staff staff = new Staff();
		staff.setEmail(expected);
		String actual = staff.getEmail();
		assertEquals(expected, actual);
	}

	@Test
	public void testTelephone() {
		String expected = "1234567";
		Staff staff = new Staff();
		staff.setTelephone(expected);
		String actual = staff.getTelephone();
		assertEquals(expected, actual);
	}

	@Test
	public void testTeam() {
		String expected = "OnCall";
		Staff staff = new Staff();
		staff.setTeam(expected);
		String actual = staff.getTeam();
		assertEquals(expected, actual);
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

}
