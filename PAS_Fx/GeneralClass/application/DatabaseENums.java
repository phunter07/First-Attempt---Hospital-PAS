package application;

public enum DatabaseENums {
	
	DATABASEURL ("jdbc:mysql://web2.eeecs.qub.ac.uk/40108307"), DATABASECLASS ("com.mysql.jdbc.Driver"), DATABASEUSERNAME ("40108307"), DATABASEPASSWORD ("CZB6355"), 
	DATABASESTAFFSELECTQUERY ("select * from STAFF"), DATABASENURSETELEPHONESELECTQUERY ("select telephone from STAFF where staff_team=onCall and staff_role='nurse'"), 
	DATABASESTAFFID ("STAFF_ID"), DATABASESTAFFTITLE ("TITLE"), DATABASESTAFFPASSWORD ("STAFF_PASSWORD"), DATABASESTAFFFIRSTNAME ("FIRST_NAME"), DATABASESTAFFLASTNAME ("LAST_NAME"), DATABASESTAFFROLE ("STAFF_ROLE"), 
	DATABASESTAFFTEAM ("STAFF_TEAM"), DATABASESTAFFEMAIL ("EMAIL_ADDRESS"), DATABASESTAFFTELEPHONE ("TELEPHONE"), DATABASEMANAGERTELEPHONESELECTQUERY ("select telephone from STAFF where staff_role='Hospital Manager'"), 
	DATABASEMANAGEREMAILSELECTQUERY ("select email_address from STAFF where staff_role='Hospital Manager'"),
	DATABASEONCALLDOCTORTELEHPONESELECTQUERY("select telephone from STAFF where staff_id='1006'"), DATABASEONCALLDOCTORTWOTELEHPONESELECTQUERY("select telephone from STAFF where staff_id='1005'"),DATABASEONCALLNURSETELEHPONESELECTQUERY("select telephone from STAFF where staff_id='1002'"),
	DATABASEONCALLNURSETWOTELEHPONESELECTQUERY("select telephone from STAFF where staff_id='1003'"),DATABASEONCALLNURSETHREETELEHPONESELECTQUERY("select telephone from STAFF where staff_id='1004'");

	private String database;

	private DatabaseENums(String database) {
		this.database = database;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

}