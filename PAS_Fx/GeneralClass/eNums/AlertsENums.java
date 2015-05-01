package eNums;

/**
 * Enums containing all the details for the Alerts messages to be sent to the
 * relevant members of staff
 * 
 *
 */

public enum AlertsENums {

	SMSALERTONCALLTEAM(
			"On Call Team Needed in A and E. Queue capacity has reached the maximum"), ALERTMANAGERONCALLFULLYENGAGED(
			"On Call team fully engaged.  Patients being redirected"), ALERTMANAGERWAITINGTIME(
			"Two or more patients have been waiting over 30 minutes"), SMSUSERNAME(
			"hospitalsender@outlook.com"), SMSHASHKEY(
			"41b6105030728d7adeb182a5c5700c8343b9d307"), SMSSENDER(
			"hospitalPAS"), SMSCONNECTION("https://api.txtlocal.com/send/?"), EMAILSUBJECTMESSAGE(
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
