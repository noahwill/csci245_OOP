package state;

import java.text.DecimalFormat;

/**
 * Abstract Class to define the structure of the four calculator states.
 * @author noahwill
 *
 */
public abstract class CalculatorState {
	
	/**
	 * Array of the 4 calculator States.
	 */
	private CalculatorState[] states = new CalculatorState[] { 
			BlankState.getInstance(), ScreenState.getInstance(), MemoryState.getInstance(), FullState.getInstance() };
	
	/**
	 * The input in the state.
	 */
	protected String input = "";
	
	/**
	 * The memory in the state.
	 */
	protected String memory = "0";
	
	private int number;
	private int operator;
	private int equals;
	private int clear;
	private int eq;
	
	/**
	 * Constructor for Calculator State
	 * @param number - State to move to with the press of a number
	 * @param operator - State to move to with the press of an operator
	 * @param equals - State to move to with the press of the equals
	 * @param clear - State to move to with the press of the clear
	 * @param eq - Equals Strategy associated with the class 
	 */
	protected CalculatorState(int number, int operator, int equals, int clear, int eq) {
		this.number = number;
		this.operator = operator;
		this.equals = equals;
		this.clear = clear;
		this.eq = eq;
	}
	
	/**
	 * Decimal format for the result of an expression. 
	 */
	public static DecimalFormat df = new DecimalFormat("0.###");
	
	/**
	 * Method called when the plus button is pressed.
	 */
	public abstract void add();
	
	/**
	 * Method called when the minus button is pressed.
	 */
	public abstract void subtract();
	
	/**
	 * Method called when the multiply button is pressed.
	 */
	public abstract void multiply();
	
	/**
	 * Method called when the divide button is pressed.
	 */
	public abstract void divide();
	
	/**
	 * Method called when a number button is pressed.
	 * @return 
	 */
	public abstract String updateInput(String in);
	
	/**
	 * Returns the number of the State that is to be taken up when a number button is pressed.
	 */
	public int getNumber()   { return this.number; }
	
	/**
	 * Returns the number of the State that is to be taken up when an operator button is pressed.
	 */
	public int getOperator() { return this.operator; }
	
	/**
	 * Returns the number of the State that is to be taken up when the equals button is pressed.
	 */
	public int getEquals()   { return this.equals; }
	
	/**
	 * Returns the number of the State that is to be taken up when the clear button is pressed.
	 */
	public int getClear()    { return this.clear; }
	
	/**
	 * Returns the number of the equals strategy that is associated with this state.
	 * @return
	 */
	public int getEQ() { return this.eq; }
	
	/**
	 * Sets the number of the equals strategy associated with this state.
	 * @param eq
	 */
	public void setEQ(int eq) { this.eq = eq; }
	
	/**
	 * Getter for input.
	 * @return
	 */
	public String getInput() { return this.input; }
	
	/**
	 * Setter for input.
	 * @param input
	 */
	public void setInput(String input) { this.input = input; }
	
	/**
	 * Getter for memory.
	 * @return
	 */
	public String getMemory() { return this.memory; }
	
	/**
	 * Setter for memory.
	 * @param memory
	 */
	public void setMemory(String memory) { this.memory = memory; }
	
	/**
	 * Gets the state related to the integer given.
	 * @param i
	 * @return
	 */
	public CalculatorState getState(int i) { return states[i]; }

	/**
	 * Defaults the input and memory in the state.
	 */
	public void defaultInMem() { this.input = ""; this.memory = "0"; }
}