package decimal;

/**
 * Decimal Strategy 1 - returns the current input.
 * @author noahwill
 *
 */
public class DEC implements DecimalStrategy {

	/**
	 * Constructor for DEC.
	 */
	public DEC() {}
	
	/**
	 * Returns the current input.
	 */
	public String decimalPoint(String input) { return input; }
	
	/**
	 * Returns 0 - the next decimal strategy.
	 */
	public int getNextDEC() { return 0; }

}