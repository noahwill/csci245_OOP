package equal;

/**
 * Equals Strategy when in the Full State and the operation pressed from the
 * Memory State was subtraction.
 * @author noahwill
 *
 */
public class SubtractEquals implements EqualsStrategy {

	public SubtractEquals() {}
	
	/**
	 * Returns the difference of input and memory.
	 */
	public String equals(String input, String memory) {
		double result = Double.parseDouble(input) - Double.parseDouble(memory);
		return Double.toString(result);
	}
	
}