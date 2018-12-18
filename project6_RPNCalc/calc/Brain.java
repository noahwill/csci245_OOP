package calc;

import java.util.Stack;

public class Brain {
	/**
	 * Stack to hold the numbers in the RPN sequence.
	 */
	private Stack<Integer> operands = new Stack<Integer>();
	
	/**
	 * Size of the stack.
	 */
	private int size = 0;
	
	/**
	 * The face of the calculator.
	 */
	private CalculatorFace face;
	
	/**
	 * What is to be printed on the screen.
	 */
	private String toScreen;
	
	/**
	 * The operands to be used in each individual calculation, whose result is pushed to the stack.
	 */
	private int operand0, operand1, toPush;
	
	/**
	 * Constructor for class Brain.
	 * @param face
	 */
	public Brain(CalculatorFace face) {
		this.face = face;
	}
	
	/**
	 * Displays on the screen the top element in the stack.
	 */
	public void peekToScreen() {
		face.writeToScreen(Integer.toString(operands.peek()));
	}
	
	/**
	 * Helper function to set the operands to do addition or subtraction when there is only 1 number on the stack.
	 */
	public void smallPlusMinusSet() {
		operand0 = operands.pop();
		if(toScreen != null)
			operand1 = Integer.parseInt(toScreen);
		else 
			operand1 = 0;
		toScreen = null;
	}
	
	/**
	 * Helper function to set the operands to do multiplication or division when there is only 1 number on the stack. 
	 */
	public void smallMultDivSet() {
		operand0 = operands.pop();
		if(toScreen != null)
			operand1 = Integer.parseInt(toScreen);
		else 
			operand1 = 1;
		toScreen = null;
	}
	
	/**
	 * Helper function to set the operands necessary to do math when there are more than 1 numbers on the stack.
	 */
	public void setOperands() {
		operand0 = operands.pop();
		operand1 = operands.pop();
		size--;
		toScreen = null;
	}

/*************************************************************************************************************/

	public void plusMinus() {
		if (toScreen != null) {
			int n = Integer.parseInt(toScreen);
			n = -n;
			toScreen = Integer.toString(n);
			
			face.writeToScreen(toScreen);
		}
	}
	
/*************************************************************************************************************/
	
	/**
	 * Method to clear the screen and memory of the calculator when the Clear button is pressed.
	 */
	public void clear() {
		toScreen = null;
		operands = new Stack<Integer>();
		size = 0;
		face.writeToScreen("");
	}

/*************************************************************************************************************/
	
	/**
	 * Method to push an operand onto the stack when the period button is pressed and there is a number on the screen
	 * @param onSceen
	 */
	public void operandPush() {
		if (toScreen == null) {}
		
		else {
			int toPush = Integer.parseInt(toScreen);
			operands.push(toPush);
			size++;
			peekToScreen();
			toScreen = null;
		}
	}
	
/*************************************************************************************************************/
	
	/**
	 * Method to update the current number on the screen
	 * @param input
	 * @param onScreen
	 */
	public void updateScreen(String input) {
		
		if (toScreen == null) {
			toScreen = input;
			face.writeToScreen(toScreen);
		}
		
		else {
			toScreen += input;
			face.writeToScreen(toScreen);
		}
	}
	
/*************************************************************************************************************/
	
	/** 
	 * Method to push the result of addition onto the stack
	 */
	public void add() {
		
		if (size == 0) {}
	
		else if (size == 1 || toScreen != null) {
			smallPlusMinusSet();
			toPush = operand0 + operand1;
			operands.push(toPush);
			peekToScreen();
		}
	
		else {
			setOperands();
			toPush = operand0 + operand1;
			operands.push(toPush);
			peekToScreen();
		}	
	}

/*************************************************************************************************************/
	
	/** 
	 * Method to push the result of subtraction onto the stack
	 */
	public void subtract() {
		
		if (size == 0) {}
	
		else if (size == 1 || toScreen != null) {
			smallPlusMinusSet();
			toPush = operand0 - operand1;
			operands.push(toPush);
			peekToScreen();
		}
		
		else {
			setOperands();
			toPush = operand0 - operand1;
			operands.push(toPush);
			peekToScreen();
		}
	}
	
/*************************************************************************************************************/
	
	/** 
	 * Method to push the result of division onto the stack
	 */
	public void div() {
		
		if (size == 0) {}
		
		else if (size == 1 || toScreen != null) {
			smallMultDivSet();
			toPush = operand0 / operand1;
			operands.push(toPush);
			peekToScreen();
		}
		
		else {
			setOperands();
			toPush = operand0 / operand1;
			operands.push(toPush);
			peekToScreen();
		}
	}

/*************************************************************************************************************/
	
	/** 
	 * Method to push the result of multiplication onto the stack
	 */
	public void mult() {
		
		if (size == 0) {}
		
		else if (size == 1 || toScreen != null) {
			smallMultDivSet();
			toPush = operand0 * operand1;
			operands.push(toPush);
			peekToScreen();
		}
		
		else {
			setOperands();
			toPush = operand0 * operand1;
			operands.push(toPush);
			peekToScreen();
		}	
	}
}
