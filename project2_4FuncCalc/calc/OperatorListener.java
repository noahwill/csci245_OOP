package calc;

import java.awt.event.*;


/**
 * OperatorListener
 * 
 * Connects to the operator {+, -, *, /} buttons on the calculator
 * and calls the .setOperator method of the class Brain.
 * 
 * @author noahwill
 *
 */
public class OperatorListener implements ActionListener {

	private String operator;
	private Brain brain;
	
	/**
	 * Constructor for the class OperatorListener.
	 * @param operator
	 * @param brain
	 */
	public OperatorListener(String operator, Brain brain) {
		this.operator = operator;
		this.brain = brain;
	}
	
	
	/**
	 * Action performed method for the OperatorListener.
	 */
	public void actionPerformed(ActionEvent e) {
		brain.setOperator(operator);
	}
}