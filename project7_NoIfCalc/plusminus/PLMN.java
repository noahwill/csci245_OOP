package plusminus;

/**
 * Strategy for plusminus after the plus minus button has already been pressed.
 * @author noahwill
 *
 */
public class PLMN implements PlusMinusStrategy {
	
	/**
	 * The next strategy is notPLMN indicated by 0.
	 */
	private int nextPLMN = 0;
	
	/**
	 * Constructor for PLMN.
	 */
	public PLMN() {}

	/**
	 * Removes the minus from the beginning of the input string, ensures that that string will always be at least empty.
	 */
	public String plusMinus(String input) { return input.substring(1) + ""; }
	
	/**
	 * Gets the reference number to the next strategy.
	 */
	public int getNextPLMN() { return this.nextPLMN; }
}