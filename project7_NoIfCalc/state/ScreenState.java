package state;

public class ScreenState extends CalculatorState {
	
	/**
	 * Singleton instance of ScreenState.
	 */
	private static ScreenState screenState = new ScreenState();

	/**
	 * Getter for the Singleton instance.
	 * @return
	 */
	public static ScreenState getInstance() {
		return screenState;
	}

	/**
	 * Constructor for the memory state. Number Move: 1. Operator Move: 2. Equals Move: 1. Clear Move: 0.
	 */
	private ScreenState() { super(1, 2, 1, 0, 0); }

	/**
	 * Sets the memory in MemoryState to the input in the ScreenState and defaults memory in ScreenState.
	 * Sets FullState input to a default 0 for the case of multiple operator inputs and FullState eq
	 * to 1 so that when the equals button is pressed, addition is performed.
	 */
	public void add() { 
		MemoryState.getInstance().setMemory(input);	
		FullState.getInstance().setInput("0");	
		FullState.getInstance().setEQ(1);
	}
	
	/**
	 * Sets the memory in MemoryState to the input in the ScreenState and defaults memory in ScreenState.
	 * Sets FullState input to a default 0 for the case of multiple operator inputs and FullState eq
	 * to 1 so that when the equals button is pressed, subtraction is performed.
	 */
	public void subtract() { 
		MemoryState.getInstance().setMemory(input);	
		FullState.getInstance().setInput("0");	
		FullState.getInstance().setEQ(2);
	}

	/**
	 * Sets the memory in MemoryState to the input in the ScreenState and defaults memory in ScreenState.
	 * Sets FullState input to a default 1 for the case of multiple operator inputs and FullState eq
	 * to 1 so that when the equals button is pressed, multiplication is performed.
	 */
	public void multiply() { 
		MemoryState.getInstance().setMemory(input);	
		FullState.getInstance().setInput("1");	
		FullState.getInstance().setEQ(3);
	}
	
	/**
	 * Sets the memory in MemoryState to the input in the ScreenState and defaults memory in ScreenState.
	 * Sets FullState input to a default 0 for the case of multiple operator inputs and FullState eq
	 * to 1 so that when the equals button is pressed, addition is performed.
	 */
	public void divide() { 
		MemoryState.getInstance().setMemory(input);
		FullState.getInstance().setInput("1");	
		FullState.getInstance().setEQ(4);
	}

	/**
	 * Updates the input.
	 */
	public String updateInput(String in) { this.input += in; return input; }
	
}