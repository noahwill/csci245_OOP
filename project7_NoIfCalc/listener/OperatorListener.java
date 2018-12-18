package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calc.Brain;

public abstract class OperatorListener implements ActionListener {

	protected Brain brain;
	
	/**
	 * Constructor for the class OperatorListener.
	 * @param operator
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
