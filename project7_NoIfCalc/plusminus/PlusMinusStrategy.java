package plusminus;

/**
 * Interface for the plusminus strategies.
 * @author noahwill
 *
 */
public interface PlusMinusStrategy {
	
	/**
	 * Gets the next plus minus strategy.
	 * @return
	 */
	public int getNextPLMN();
	
	/**
	 * Performs the appropriate plus minus operation.
	 * @param input
	 * @return
	 */
	public String plusMinus(String input);
	
}
