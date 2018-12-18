package listener;

import java.awt.event.ActionEvent;

import calc.Brain;

public class MultListener extends OperatorListener {

	/**
	 * Constructor for MultListener.
	 * @param brain
	 */
	public MultListener(Brain brain) {
		super(brain);
	}

	public void actionPerformed(ActionEvent e) {
		brain.multiply();
	}

}
