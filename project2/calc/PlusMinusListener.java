package calc;

import java.awt.event.*;

/**
 * PlusMinusListener
 * 
 * Connects to the plus/minus {+/-} button on the calculator
 * and calls the plusMinus method of the class Brain.
 * 
 * @author noahwill
 *
 */
public class PlusMinusListener implements ActionListener{
	
	private Brain brain; 

	/** 
	 * Constructor for the PlusMinusListener class. 
	 * @param brain
	 */
	public PlusMinusListener(Brain brain) {
		this.brain = brain;
	}
	
	/**
	 * Action performed method of the PlusMinusListener class.
	 */
	public void actionPerformed(ActionEvent e) {
		brain.plusMinus();
	}

}
