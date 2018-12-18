package plusminus;

/**
 * Strategy for plusminus before the plus minus button has been pressed.
 * @author noahwill
 *
 */
public class NotPLMN implements PlusMinusStrategy {
	
	/**
	 * The next strategy is PLMN indicated by 0.
	 */
	private int nextPLMN = 1;
	
	/**
	 * Constructor for NotPLMN.
	 */
	public NotPLMN() {}

	/**
	 * Adds a negative to the beginning of the input string.
	 */
	public String plusMinus(String input) { return "-" + input; }

	/**
	 * Gets the next PLMN strategy.
	 */
	public int getNextPLMN() { return this.nextPLMN; }
}
