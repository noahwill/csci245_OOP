package decimal;

/**
 * Interface to define methods for the decimal strategies.
 * @author noahwill
 *
 */
public interface DecimalStrategy {

	/**
	 * Performs the appropriate decimal operation.
	 * @param input
	 * @return
	 */
	public String decimalPoint(String input);

	/**
	 * Gets the next decimal strategy.
	 * @return
	 */
	public int getNextDEC();
}


