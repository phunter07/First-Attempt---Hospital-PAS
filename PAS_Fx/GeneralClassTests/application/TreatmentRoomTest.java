package application;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreatmentRoomTest {

	int roomNumber;
	boolean vacant, patientTreated;
	Date timeInTreatmentRoom, timeOutOfTreatmentRoom;
	Patient patientInTreatmentRoom;
	

	@Test
	public void testTreatmentRoomDefaultConstructor() {
		TreatmentRoom treatmentroom = new TreatmentRoom();
		assertNotNull(treatmentroom);
	}

	@Test
	public void testTimeInTreatmentRoom() {
		TreatmentRoom treatmentroom = new TreatmentRoom();
		Date expected = new Date();
		treatmentroom.setTimeInTreatmentRoom(expected);
		Date actual = treatmentroom.getTimeInTreatmentRoom();
		assertEquals(expected, actual);
	}

	@Test
	public void testIsVacant() {
		TreatmentRoom treatmentroom = new TreatmentRoom();
		vacant = true;
		treatmentroom.setVacant(true);
		treatmentroom.isVacant();
		assertTrue(vacant);
	}

	@Test
	public void testSetVacant() {
		fail("Not yet implemented");
	}

	@Test
	public void testRoomNumber() {
		TreatmentRoom treatmentroom = new TreatmentRoom();
		int expected = 1;
		treatmentroom.setRoomNumber(expected);
		int actual = treatmentroom.getRoomNumber();
		assertEquals(expected, actual);
	}

	@Test
	public void testAllocateExtraTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEmptyTreatmentRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPatientTriageCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPatientInTreatmentRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPatientInTreatmentRoom() {
		fail("Not yet implemented");
	}

	@Test
	public void testDischargePatient() {
		fail("Not yet implemented");
	}

}
