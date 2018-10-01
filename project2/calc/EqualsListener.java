package calc;

import java.awt.event.*;

/**
 * EqualsListener
 * 
 * Connects to the equals {=} buttons on the calculator
 * and calls the .equals method of the class Brain.
 * 
 * @author noahwill
 *
 */
public class EqualsListener implements ActionListener {

	private Brain brain;
	
	/** 
	 * Constructor for the class EqualsListener.
	 * @param brain
	 */
	public EqualsListener(Brain brain) {
		this.brain = brain;
	}
	
	/**
	 * Action performed method for the class EqualsListener.
	 */
	public void actionPerformed(ActionEvent e) {
		brain.equals();
	}
	
}