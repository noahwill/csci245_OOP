package calc;

import decimal.*;
import equal.*;
import plusminus.*;
import state.*;

/**
 * Class to handle the calculator state and perform the appropriate operations. 
 * @author noahwill
 *
 */
public class Brain {
	
	private CalculatorFace face;
	private String         result = "";
	
	/**
	 * Constructor for class Brain. Initializes the decimal and plus minus strategies and the calculator states.
	 * @param face
	 */
	public Brain(CalculatorFace face) {
		this.face  = face;
		this.dec   = new NotDEC();
		this.plmn  = new NotPLMN();
		this.state = BlankState.getInstance();
	}
	
	/**
	 * Clear the screen and memory of the calculator when the Clear button is pressed.
	 * Defaults the memory in each calculator state.
	 */
	public void clear() {
		dec      = new NotDEC();
		plmn     = new NotPLMN();
		state    = BlankState.getInstance();
		
		BlankState .getInstance().defaultInMem();
		ScreenState.getInstance().defaultInMem();
		MemoryState.getInstance().defaultInMem();
		FullState  .getInstance().defaultInMem();
		
		result = "";
		face.writeToScreen("");
	}
	
	/**********************************************************************************/

	private DecimalStrategy dec;
	private DecimalStrategy[] decStrategies = new DecimalStrategy[] { new NotDEC(), new DEC() };
	
	/**
	 * Setter for the plus minus state.
	 * @param plmn
	 */
	public void setDEC(DecimalStrategy dec) { this.dec = dec; }
	
	/**
	 * Sets the result and state input to the result of the current decimal strategy. 
	 * Sets the decimal strategy to the next strategy.
	 * Writes result to screen.
	 */
	public void decimal() {
		this.result = dec.decimalPoint(result);
		state.setInput(result);
		setDEC(decStrategies[dec.getNextDEC()]);
		face.writeToScreen(result);
	}
	
	/**********************************************************************************/
	
	private PlusMinusStrategy plmn;
	private PlusMinusStrategy[] plmnStrategies = new PlusMinusStrategy[] { new NotPLMN(), new PLMN() };
	
	/**
	 * Setter for the plus minus state.
	 * @param plmn
	 */
	public void setPLMN(PlusMinusStrategy plmn) { this.plmn = plmn; }
	
	/**
	 * Sets the result and state input to the result of the current plus minus strategy. 
	 * Sets the plus minus strategy to the next strategy.
	 * Writes result to screen.
	 */
	public void plmn() {
		this.result = plmn.plusMinus(result);
		state.setInput(result);
		setPLMN(plmnStrategies[plmn.getNextPLMN()]);
		face.writeToScreen(result);
	}
	
	/**********************************************************************************/

	private EqualsStrategy[] eqStrats = new EqualsStrategy[] { new EmptyEquals(), new AddEquals(), 
			new SubtractEquals(), new MultiplyEquals(), new DivideEquals() };
	
	/**
	 * Finishes the expression in the current state and assigns the result. Called when the equals button is pressed.
	 * Defaults the state input and memory. 
	 */
	public void equals () {
		String result = eqStrats[state.getEQ()].equals(state.getInput(), state.getMemory());
		this.result = result;
		state.defaultInMem();
		setState(state.getEquals());
	}
	
	/**********************************************************************************/
	
	private CalculatorState state;
	
	/**
	 * Array to hold the four static states the calculator may be in.
	 */
	private CalculatorState[] states = new CalculatorState[] { 
			BlankState .getInstance(), 
			ScreenState.getInstance(), 
			MemoryState.getInstance(), 
			FullState  .getInstance() };
	
	/**
	 * Getter for the calculator state.
	 * @return
	 */
	public CalculatorState getState() {
		return state;
	}
	
	/**
	 * Setter for the state.
	 * @param i passed from the current state to dictate which state to move 
	 * to after a button has been pressed.
	 */
	public void setState(int i) {
		this.state = states[i];
		face.writeToScreen(result);
	}
	
	/**********************************************************************************/
	
	/**
	 * Setter for result.
	 * @param someString
	 */
	public void setResult(String someString) {
		this.result = state.updateInput(someString);
		state.defaultInMem();
		setState(state.getNumber());
	}
	
	/**
	 * Getter for Result.
	 * @return
	 */
	public String getResult() { return this.result; }
	
	/**
	 * Performs addition in the current state. Called when the plus button is pressed. 
	 */
	public void add() {
		state.add();
		this.result = state.getInput();
		setState(state.getOperator());
	}
	
	/**
	 * Performs subtraction in the current state. Called when the minus button is pressed. 
	 */
	public void subtract() {
		state.subtract();
		this.result = state.getInput();
		setState(state.getOperator());
	}
	
	/**
	 * Performs multiplication in the current state. Called when the multiply button is pressed. 
	 */
	public void multiply() {
		state.subtract();
		this.result = state.getInput();
		setState(state.getOperator());
	}

	/**
	 * Performs division in the current state. Called when the divide button is pressed. 
	 */
	public void divide() {
		state.divide();
		this.result = state.getInput();
		setState(state.getOperator());
	}
}
