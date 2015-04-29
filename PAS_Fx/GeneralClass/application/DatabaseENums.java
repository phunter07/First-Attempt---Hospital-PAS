package application;

public enum DatabaseENums {
	
	DATABASEURL ("jdbc:mysql://web2.eeecs.qub.ac.uk/40108307"), DATABASECLASS ("com.mysql.jdbc.Driver"), DATABASEUSERNAME ("40108307"), DATABASEPASSWORD ("CZB6355"), 
	DATABASESTAFFSELECTQUERY ("select * from STAFF"), DATABASEONCALLTELEPHONESELECTQUERY ("select telephone from STAFF where staff_team=OnCall"), DATABASENURSETELEPHONESELECTQUERY ("select telephone from STAFF where staff_team=onCall and staff_role=nurse"), 
	DATABASESTAFFID ("STAFF_ID"), DATABASESTAFFTITLE ("TITLE"), DATABASESTAFFPASSWORD ("STAFF_PASSWORD"), DATABASESTAFFFIRSTNAME ("FIRST_NAME"), DATABASESTAFFLASTNAME ("LAST_NAME"), DATABASESTAFFROLE ("STAFF_ROLE"), 
	DATABASESTAFFTEAM ("STAFF_TEAM"), DATABASESTAFFEMAIL ("EMAIL_ADDRESS"), DATABASESTAFFTELEPHONE ("TELEPHONE"), DATABASEMANAGERTELEPHONESELECTQUERY ("select telephone from STAFF where staff_role=Hospital Manager"), 
	DATABASEMANAGEREMAILSELECTQUERY ("select email_address from STAFF where staff_role=Hospital Manager");
	
	private String database;

	private DatabaseENums(String database) {
		this.database = database;
	}

	public String getDatabase() {
		return database;
	}

	public void setAlert(String database) {
		this.database = database;
	}

}
