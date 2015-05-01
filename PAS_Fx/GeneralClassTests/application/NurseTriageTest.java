package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NurseTriageTest {
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
	 * testing constructor with valid arguments
	 */
	@Test
	public void testNurseTriageConstructor() {
		NurseTriage nurseTriage = new NurseTriage(validTitle, validFirstName,
				validLastName, validGender, validStaffID, validPassword);
		assertNotNull(nurseTriage);
		assertEquals(validGender, nurseTriage.getGender());
		assertEquals(validTitle, nurseTriage.getTitle());
		assertEquals(validFirstName, nurseTriage.getFirstName());
		assertEquals(validLastName, nurseTriage.getLastName());
		assertEquals(validStaffID, nurseTriage.getStaffID());
		assertEquals(validPassword, nurseTriage.getPassword());
	}

	@Test
	public void testNurseTriageDefaultConstructor() {
		NurseTriage nurseTriage = new NurseTriage();
		assertNotNull(nurseTriage);
	}

	@Test
	public void testFindPatientByNhsNumber() {
		fail("Not yet implemented");
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

	@Test
	public void testAllocateJDoeDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindPatientNeededToBeTriage() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindPatientNeededToBeAltered() {
		fail("Not yet implemented");
	}

}
