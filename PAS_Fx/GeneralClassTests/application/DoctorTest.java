package application;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import eNums.Triage;

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
		Doctor doctor = new Doctor();
		Patient patient = new Patient();
		Triage triage = Triage.SEMI_URGENT;
		LinkedList<Patient> patientQueue  = new LinkedList<Patient>();
		LinkedList<Patient> allPatients = new LinkedList<Patient>();
		
		try {
			doctor.categorisePatient(allPatients, patientQueue, patient, triage);
		} catch (HospitalPASException e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testRecategorisePatient() {
		Doctor doctor = new Doctor();
		Patient patient = new Patient();
		Triage triage = Triage.EMERGENCY;
		LinkedList<Patient> patientQueue  = new LinkedList<Patient>();
		LinkedList<Patient> allPatients = new LinkedList<Patient>();
		
		try {
			doctor.categorisePatient(allPatients, patientQueue, patient, triage);
		} catch (HospitalPASException e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testPutPatientIntoQueue() {
		boolean inQueue = true;
		Patient patient = new Patient();
		LinkedList<Patient> patientQueue  = new LinkedList<Patient>();
		
		Doctor doctor = new Doctor();
		doctor.putPatientIntoQueue(patientQueue, patient);
		assertTrue(inQueue);
		
	}

	@Test
	public void testPutPatientIntoQueueFalse() {
		boolean inQueue = false;
		Patient patient = new Patient();
		LinkedList<Patient> patientQueue  = new LinkedList<Patient>();
		
		Doctor doctor = new Doctor();
		doctor.putPatientIntoQueue(patientQueue, patient);
		assertFalse(inQueue);
		
	}
}
