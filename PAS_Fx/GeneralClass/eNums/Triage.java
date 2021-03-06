package eNums;

/**
 * the enum represents 4 types of triage
 *
 */
public enum Triage {
	EMERGENCY("emergency", 1), URGENT("urgent", 2), SEMI_URGENT("semi_urgent",
			3), NON_URGENT("non_urgent", 4);
	private final String triage;

	private final int level;

	Triage(String triage, int level) {
		this.triage = triage;
		this.level = level;
	}

	public String getTriage() {
		return triage;
	}

	public int getLevel() {
		return level;
	}
}
