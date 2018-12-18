package equal;

/**
 * Equals Strategy when in the Full State and the operation pressed from the
 * Memory State was division.
 * @author noahwill
 *
 */
public class DivideEquals implements EqualsStrategy {

	public DivideEquals() {}
	
	/**
	 * Returns the quotient of input and memory.
	 */
	public String equals(String input, String memory) {
		double result = Double.parseDouble(input) / Double.parseDouble(memory);
		return Double.toString(result);
	}
	
}