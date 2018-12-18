package equal;

/**
 * Equals Strategy when in the Full State and the operation pressed from the
 * Memory State was multiplication.
 * @author noahwill
 *
 */
public class MultiplyEquals implements EqualsStrategy {

	public MultiplyEquals() {}
	
	/**
	 * Returns the product of input and memory.
	 */
	public String equals(String input, String memory) {
		double result = Double.parseDouble(input) * Double.parseDouble(memory);
		return Double.toString(result);
	}
	
}