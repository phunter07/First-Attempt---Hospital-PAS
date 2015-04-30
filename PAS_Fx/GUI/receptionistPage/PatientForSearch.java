/**
 * @author Paul 40133443
 */

package receptionistPage;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class PatientForSearch {
	private final StringProperty title;
	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty nhsNumber;
	private final StringProperty address;
	private final StringProperty bloodGroup;
	private final StringProperty contactNumber;
	private final StringProperty triageCategory;
	private final StringProperty waitingTime;
	

	public PatientForSearch(String nhsNumber, String firstName,
			String lastName, String title, String address, String contactNumber,
			String bloodGroup, String triageCategory, String waitingTime) {
		this.nhsNumber = new SimpleStringProperty(nhsNumber);
		this.title = new SimpleStringProperty(title);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.address = new SimpleStringProperty(address);
		this.contactNumber = new SimpleStringProperty(contactNumber);
		this.bloodGroup = new SimpleStringProperty(bloodGroup);
		this.triageCategory = new SimpleStringProperty(triageCategory);
		this.waitingTime = new SimpleStringProperty(waitingTime);
	}

	

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	public String getNhsNumber() {
		return nhsNumber.get();
	}

	public void setNhsNumber(String nhsNumber) {
		this.nhsNumber.set(nhsNumber);
	}

	public StringProperty nhsNumberProperty() {
		return nhsNumber;
	}

	public String getAddress() {
		return address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
	}

	public StringProperty addressProperty() {
		return address;
	}

	public String getBloodGroup() {
		return bloodGroup.get();
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup.set(bloodGroup);
	}

	public StringProperty bloodGroupProperty() {
		return bloodGroup;
	}

	public String getContactNumber() {
		return contactNumber.get();
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber.set(contactNumber);
	}

	public StringProperty contactNumberProperty() {
		return contactNumber;
	}



	public String getTitle() {
		return title.get();
	}
	
	public void setTitle (String title){
		this.title.set(title);
	}
	
	public StringProperty titleProperty(){
		return title;
	}


	public String getTriageCategory() {
		return triageCategory.get();
	}
	
	public void setTriageCategory (String triageCategory) {
		this.triageCategory.set(triageCategory);
	}
	
	public StringProperty triageCategoryProperty(){
		return triageCategory;
	}

	public String getWaitingTime(){
		return waitingTime.get();
	}

	public void setWaitingTime(String waitingTime){
		this.waitingTime.set(waitingTime);
	}
	
	public StringProperty waitingTimeProperty() {
		return waitingTime;
	}

}
