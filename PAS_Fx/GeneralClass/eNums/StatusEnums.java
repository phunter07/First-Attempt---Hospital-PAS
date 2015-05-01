package eNums;

public enum StatusEnums {

	STATUSONE("Average waiting time lower than 10 minutes", 1), STATUSTWO(
			"Average waiting between 10 and 20 minutes", 2), STATUSTHREE(
			"Average Waiting time between 20 and 30 minutes", 3), STATUSFOUR(
			"Patients ", 4);

	private final String status;

	private final int level;

	StatusEnums(String status, int level) {
		this.status = status;
		this.level = level;
	}

	public String getStatus() {
		return status;
	}

	public int getLevel() {
		return level;
	}
}
