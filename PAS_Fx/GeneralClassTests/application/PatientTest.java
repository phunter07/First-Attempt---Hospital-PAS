package application;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PatientTest {

	// test data
	int validNhsNumber, invalidNhsNumber, validTriage, invalidTriage,
			validNHSNumber, invalidNHSNumber;
	String validAllergies, invalidAllergies, validAddress, invalidAddress,
			validBloodGroup, invalidBloodGroup, validContactNum, validTitle,
			invalidTitle, validLastName, invalidLastName, validFirstName,
			invalidFirstName, invalidContactNum;
	long validWaitingTime, invalidWaitingTime;
	boolean pulledOutOfRoom;
	Date TimePatientJoinsQueue, LeaveTime;
	char validGender, invalidGender;

	@Before
	public void setUp() throws Exception {
		TimePatientJoinsQueue = new Date();
		LeaveTime = new Date();

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
		pulledOutOfRoom = false;
		validGender = 'F';
		invalidGender = 'Y';
		validTitle = "ValidTitle";
		invalidTitle = null;
		validFirstName = "ValidFirstName";
		invalidFirstName = null;
		validLastName = "ValidLastName";
		validNHSNumber = 100;
		invalidNHSNumber = -1;

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
		Patient patient = new Patient(validTitle, validFirstName,
				validLastName, validGender, validNHSNumber, validBloodGroup,
				validContactNum, TimePatientJoinsQueue, LeaveTime);
		assertNotNull(patient);
		assertEquals(validGender, patient.getGender());
		assertEquals(validTitle, patient.getTitle());
		assertEquals(validFirstName, patient.getFirstName());
		assertEquals(validLastName, patient.getLastName());
		assertEquals(validNHSNumber, patient.getNhsNumber());
		assertEquals(validBloodGroup, patient.getBloodGroup());
		assertEquals(validContactNum, patient.getContactNum());
		assertEquals(TimePatientJoinsQueue, patient.getTimePatientJoinsQueue());
		assertEquals(LeaveTime, patient.getLeaveTime());
	}

	/**
	 * test of get/set NHS number
	 */
	@Test
	public void testSetNhsNumber() {
		Patient patient = new Patient();
		patient.setNhsNumber(validNHSNumber);
		assertEquals(validNHSNumber, patient.getNhsNumber());

	}

	/**
	 * test of get/set blood group
	 */
	@Test
	public void testSetGetBloodGroup() {
		Patient patient = new Patient();
		patient.setBloodGroup(validBloodGroup);
		assertEquals(validBloodGroup, patient.getBloodGroup());
	}

	/**
	 * test of get/set ContactNum
	 */
	@Test
	public void testSetGetContactNum() {
		Patient patient = new Patient();
		patient.setContactNum(validContactNum);
		assertEquals(validContactNum, patient.getContactNum());
	}

	/**
	 * test of get/set Allergies
	 */
	@Test
	public void testSetAllergies() {
		Patient patient = new Patient();
		patient.setAllergies(validAllergies);
		assertEquals(validAllergies, patient.getAllergies());
	}

	/**
	 * test of get/set Address
	 */
	@Test
	public void testSetAddress() {
		Patient patient = new Patient();
		patient.setAddress(validAddress);
		assertEquals(validAddress, patient.getAddress());
	}

	/**
	 * test of get/set TimePatientJoinsQueue
	 */
	@Test
	public void testSetTimePatientJoinsQueue() {
		Patient patient = new Patient();
		patient.setTimePatientJoinsQueue(TimePatientJoinsQueue);
		assertEquals(TimePatientJoinsQueue, patient.getTimePatientJoinsQueue());
	}

	/**
	 * test of get/set LeaveTime
	 */
	@Test
	public void testSetLeaveTime() {
		Patient patient = new Patient();
		patient.setLeaveTime(LeaveTime);
		assertEquals(LeaveTime, patient.getLeaveTime());
	}

	/**
	 * test IsPulledOutOfRoom out of room and setPulledOutOfRoom
	 */
	@Test
	public void testIsPulledOutOfRoom() {
		Patient patient = new Patient();
		patient.setPulledOutOfRoom(true);
		assertTrue(patient.isPulledOutOfRoom());
	}

}
