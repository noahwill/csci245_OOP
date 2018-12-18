package equal;

/**
 * Equals strategy when in the Blank, Screen, and Memory State.
 * @author noahwill
 *
 */
public class EmptyEquals implements EqualsStrategy {

	public EmptyEquals() {}
	
	/**
	 * Returns the input.
	 */
	public String equals(String input, String memory) {
		return input;
	}
	
}