package state;

/**
 * State 3, Handles the actual operations on input and memory.
 * @author noahwill
 *
 */
public class FullState extends CalculatorState {
	
	/**
	 * Singleton instance of FullState.
	 */
	private static FullState fullState = new FullState();

	/**
	 * Getter for the Singleton instance.
	 * @return
	 */
	public static FullState getInstance() {
		return fullState;
	}
	
	/**
	 * Constructor for the full state. Number Move: 3. Operator Move: 2. Equals Move: 2. Clear Move: 0.
	 */
	private FullState() { super(3, 2, 2, 0, 0); }
	
	/**
	 * Performs addition for the input and memory. Sets the memory in the memory state as that is the next state.
	 */
	public void add() { 
		String result = Double.toString(Double.parseDouble(this.input) + Double.parseDouble(this.memory));
		MemoryState.getInstance().setMemory(result);
		this.input = result;
	}
	
	/**
	 * Performs subtraction for the input and memory. Sets the memory in the memory state as that is the next state.
	 */
	public void subtract() { 
		String result = Double.toString(Double.parseDouble(this.input) - Double.parseDouble(this.memory));
		MemoryState.getInstance().setMemory(result);
		this.input = result;
	}

	/**
	 * Performs multiplication for the input and memory. Sets the memory in the memory state as that is the next state.
	 */
	public void multiply() { 
		String result = Double.toString(Double.parseDouble(this.input) * Double.parseDouble(this.memory));
		MemoryState.getInstance().setMemory(result);
		this.input = result;
	}

	/**
	 * Performs division for the input and memory. Sets the memory in the memory state as that is the next state.
	 */
	public void divide() { 
		String result = Double.toString(Double.parseDouble(this.input) / Double.parseDouble(this.memory));
		MemoryState.getInstance().setMemory(result);
		this.input = result;
	}
	
	/**
	 * Updates the input.
	 */
	public String updateInput(String in) { this.input += in; return input; }
}