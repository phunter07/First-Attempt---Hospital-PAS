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
			"hmcdade767@gmail.com"), SMSHASHKEY(
			"64007dc125b1e33d8204dd6c6aaf10ce83c12fb7"), SMSSENDER(
			"HospitalPAS"), SMSCONNECTION("https://api.txtlocal.com/send/?"), EMAILSUBJECTMESSAGE(
			"Hospital Alert"), EMAILSENDER("hospitalsender@gmail.com"), EMAILSENDERPASSWORD(
			"validPassword"), EMAILSENDERSMTP("smtp.gmail.com");

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
