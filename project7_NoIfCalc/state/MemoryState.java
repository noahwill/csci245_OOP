package state;

/**
 * State 2, Handles the movement of the input to the memory and the action required to accept new input in the expression.
 * @author noahwill
 *
 */
public class MemoryState extends CalculatorState {

	/**
	 * Singleton instance of MemoryState.
	 */
	private static MemoryState memoryState = new MemoryState();
	
	/**
	 * Getter for the Singleton instance.
	 * @return
	 */
	public static MemoryState getInstance() { return memoryState; }
	
	/**
	 * Constructor for the memory state. Number Move: 3. Operator Move: 3. Equals Move: 2. Clear Move: 0.
	 */
	private MemoryState() { super(3, 3, 2, 0, 0); }
	
	/**
	 * Addition does nothing since there is only one number in memory.
	 */
	public void add() { FullState.getInstance().setEQ(1); FullState.getInstance().setMemory(memory); }
	
	/**
	 * Subtraction does nothing since there is only one number in memory.
	 */
	public void subtract() { FullState.getInstance().setEQ(2); FullState.getInstance().setMemory(memory); }

	/**
	 * Multiplication does nothing since there is only one number in memory.
	 */
	public void multiply() { FullState.getInstance().setEQ(3); FullState.getInstance().setMemory(memory); }

	/**
	 * Division does nothing since there is only one number in memory.
	 */
	public void divide() { FullState.getInstance().setEQ(4); FullState.getInstance().setMemory(memory); }

	/**
	 * Sets the input and memory for FullState.
	 */
	public String updateInput(String in) { 
		
		getState(getNumber()).setInput(in);
		getState(getNumber()).setMemory(memory);
		
		return in; 
	}
	
}