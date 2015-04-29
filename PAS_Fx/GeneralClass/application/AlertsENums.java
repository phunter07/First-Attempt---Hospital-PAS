package application;

/**
 * Enums for the Alerts messages to be sent to the relevant members of staff
 * 
 * @author Hannah
 *
 */

public enum AlertsENums {

	SMSALERTONCALLTEAM(
			"On Call Team Needed in A and E. Queue capacity has reached the maximum"), ALERTMANAGERONCALLFULLYENGAGED(
			"On Call team fully engaged.  Patients being redirected"), ALERTMANAGERWAITINGTIME(
			"Two or more patients have been waiting over 30 minutes"), SMSUSERNAME(
			"hospitalsender@gmail.com"), SMSHASHKEY(
			"6e85ab8f234b76500635d7078ec12f3dba92a970"), SMSSENDER(
			"HospitalPAS"), SMSCONNECTION("https://api.txtlocal.com/send/?"), EMAILSUBJECTMESSAGE(
			"Hospital Alert"), EMAILSENDER("hospitalsender@gmail.com"), EMAILSENDERPASSWORD(
			"validPassword"), EMAILSENDERSMTP("smtp.gmail.com"), SMS_USERNAME(
			"hospitalsender@gmail.com"), SMS_HASHKEY(
			"6e85ab8f234b76500635d7078ec12f3dba92a970"), SMS_SENDER(
			"HospitalPAS"), SMS_CONNECTION("https://api.txtlocal.com/send/?");

	private String alert;

	private AlertsENums(String alert) {
		this.alert = alert;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

}
