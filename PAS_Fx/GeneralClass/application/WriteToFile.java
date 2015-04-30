package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.LinkedList;

public class WriteToFile {

	public WriteToFile() {

	}

	/**
	 * method to write queue to file and time-stamp the queue each time it is
	 * written to file
	 * 
	 * @param patientQueue
	 * @throws FileNotFoundException
	 */
	public void writeQueueToFile(Object obj) throws FileNotFoundException {
		// try catch incase file not found or cannot be created
		try {
			// new FileOutputStream and ObjectOutputStream to create/update file
			// and write queue to file
			FileOutputStream fileOutputStream = new FileOutputStream(
					"QueueFinal.txt", false);
			ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
			// writing new date to file
			oos.writeObject(new Date().toString());
			oos.writeObject("\n");
			// writing patient queue to file
			oos.writeObject(obj.toString());
			// closing the object output stream
			oos.close();
			// catch block printing exception message
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method to write queue to file and time-stamp the leave time each time it is
	 * written to file
	 * 
	 * @param patientQueue
	 * @throws FileNotFoundException
	 */
	public void patientLeaveTimeToFile(Object obj) throws FileNotFoundException {
		// try catch incase file not found or cannot be created
		try {
			// new FileOutputStream and ObjectOutputStream to create/update file
			// and write queue to file
			FileOutputStream fileOutputStream = new FileOutputStream(
					"PatientTiming.txt", false);
			ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
			// writing new date to file
			oos.writeObject(new Date().toString());
			oos.writeObject("\n");
			// writing patient queue to file
			oos.writeObject(obj.toString());
			// closing the object output stream
			oos.close();
			// catch block printing exception message
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method to write queue to file and time-stamp the leave time each time it is
	 * written to file
	 * 
	 * @param patientQueue
	 * @throws FileNotFoundException
	 */
	public void ExceptionsToFile(Object obj) throws FileNotFoundException {
		// try catch incase file not found or cannot be created
		try {
			// new FileOutputStream and ObjectOutputStream to create/update file
			// and write queue to file
			FileOutputStream fileOutputStream = new FileOutputStream(
					"PASExceptions.txt", false);
			ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
			// writing new date to file
			oos.writeObject(new Date().toString());
			oos.writeObject("\n");
			// writing patient queue to file
			oos.writeObject(obj.toString());
			// closing the object output stream
			oos.close();
			// catch block printing exception message
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
