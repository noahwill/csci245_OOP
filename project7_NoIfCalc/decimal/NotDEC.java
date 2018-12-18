package decimal;

/**
 * Decimal Strategy 0 - returns the current input plus a decimal point.
 * @author noahwill
 *
 */
public class NotDEC implements DecimalStrategy {

	/**
	 * Constructor for NotDEC.
	 */
	public NotDEC() {}
	
	/**
	 * Returns the current input plus a decimal.
	 */
	public String decimalPoint(String input) { return input += "."; }

	/**
	 * Returns 1 - the next decimal strategy.
	 */
	public int getNextDEC() { return 1;	}

}