package equal;

/**
 * Equals Strategy when in the Full State and the operation pressed from the
 * Memory State was addition.
 * @author noahwill
 *
 */
public class AddEquals implements EqualsStrategy {

	public AddEquals() {}
	
	/**
	 * Returns the sum of input and memory.
	 */
	public String equals(String input, String memory) {
		double result = Double.parseDouble(input) + Double.parseDouble(memory);
		return Double.toString(result);
	}
	
}