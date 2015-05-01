package application;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PatientTest {

	// test data
	int validEmergencyNHSNumber, invalidEmergencyNHSNumber, validNhsNumber,
			invalidNhsNumber, validTriage, invalidTriage;
	String validAllergies, invalidAllergies, validAddress, invalidAddress,
			validBloodGroup, invalidBloodGroup, validContactNum,
			invalidContactNum;
	long validWaitingTime, invalidWaitingTime;
	boolean pulledOutOfRoom;
	Date TimePatientJoinsQueue, LeaveTime;
	
	
	@Before
	public void setUp() throws Exception {
		TimePatientJoinsQueue = new Date();
		LeaveTime = new Date();

		validEmergencyNHSNumber = 999;
		invalidEmergencyNHSNumber = -1;
		validNhsNumber = 1000;
		invalidNhsNumber = -1;
		validTriage = 1;
		invalidTriage = 6;
		validAllergies = "ValidAllergy";
		invalidAllergies = null;
		validAddress = "ValidAddress";
		invalidAddress = null;
		validBloodGroup = "ValidBloodGroup";
		invalidBloodGroup = null;
		validContactNum = "ValidContactNum";
		invalidContactNum = null;
		validWaitingTime = 10;
		invalidWaitingTime = -1;
		pulledOutOfRoom = true;

	}

	/**
	 * default constructor
	 */
	@Test
	public void testPatientDefaultConstructor() {
		Patient patient = new Patient();
		assertNotNull(patient);
	}

	@Test
	public void testPatientStringStringStringCharIntStringStringDateDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTriage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNhsNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBloodGroup() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetContactNum() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAllergies() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTimePatientJoinsQueue() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLeaveTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTriageCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsPulledOutOfRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPulledOutOfRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmergencyNHSNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
