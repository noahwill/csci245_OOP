package game;

/**
 * Class to define the parameters of success and failure of a battle sequence (a bout).
 * @author SUPERORGANISM
 */
public class Bout {
	/**
	 * Amount of time required for the player to respond, otherwise they are killed.
	 */
	private long timetorespond;
	/**
	 * The action required to progress in the bout, otherwise, if they are not running, the player is killed.
	 */
	private String requiredaction;
	/**
	 * The string printed when the enemy is defeated.
	 */
	private String successstring;
	
	/**
	 * Constructor for the Bout class.
	 * @param timetorespond
	 * @param requiredaction
	 * @param successstring
	 */
	public Bout(long timetorespond, String requiredaction, String successstring) {
		this.timetorespond = timetorespond;
		this.requiredaction = requiredaction;
		this.successstring = successstring;
	}
	
	/**
	 * @return timetorespond
	 */
	public long getTimetorespond() {
		return timetorespond;
	}
	
	/**
	 * @return requiredaction
	 */
	public String getRequiredaction() {
		return requiredaction;
	}
	
	/**
	 * @return successstring
	 */
	public String getSuccessstring() {
		return successstring;
	}
	
	public String toString() {
		return timetorespond + requiredaction + successstring;
	}
}
