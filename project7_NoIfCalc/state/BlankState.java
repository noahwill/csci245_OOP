package state;

/**
 * State 0, Default state that essentially does nothing except for handing the input off to the ScreenState.
 * @author noahwill
 *
 */
public class BlankState extends CalculatorState {

	/**
	 * Singleton instance of BlankState.
	 */
	private static BlankState blankState = new BlankState();
	
	/**
	 * Getter for Singleton instance of BlankState.
	 */
	public static BlankState getInstance() {
		return blankState;
	}
	
	private BlankState() { super(1, 0, 0, 0, 0); }
	
	/**
	 * Do nothing as there is neither an input or memory.
	 */
	public void add() { }
	
	/**
	 * Do nothing as there is neither an input or memory.
	 */
	public void subtract() { }

	/**
	 * Do nothing as there is neither an input or memory.
	 */
	public void multiply() { }

	/**
	 * Do nothing as there is neither an input or memory.
	 */
	public void divide() { }
	
	/**
	 * Updates the ScreenState input and returns that input.
	 */
	public String updateInput(String in) {
		ScreenState.getInstance().setInput(input + in);
		return ScreenState.getInstance().getInput();
	}
	
}