package equal;

/**
 * Interface to handle what the equals button does. 
 * @author noahwill
 */
public interface EqualsStrategy {

	/**
	 * Method that will return the appropriate result of an operation done 
	 * when equals is pressed.
	 * @param input
	 * @param memory
	 * @return
	 */
	public String equals(String input, String memory);
}
