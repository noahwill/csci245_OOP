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
public abstract class OperatorListener implements ActionListener {
	
	protected Brain brain;
	
	/**
	 * Constructor for the class OperatorListener.
	 * @param brain
	 */
	public OperatorListener(Brain brain) {
		this.brain = brain;
	}
	
	/**
	 * Action performed method for the OperatorListener.
	 */
	public abstract void actionPerformed(ActionEvent e);
	
}
