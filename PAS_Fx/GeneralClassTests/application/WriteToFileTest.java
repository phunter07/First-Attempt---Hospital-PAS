package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WriteToFileTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWriteToFileDefaultConstructor() {
		WriteToFile writeToFile = new WriteToFile();
		assertNotNull(writeToFile);
	}

	@Test
	public void testWriteQueueToFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testPatientLeaveTimeToFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testExceptionsToFile() {
		fail("Not yet implemented");
	}

}
