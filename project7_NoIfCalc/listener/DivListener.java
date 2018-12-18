package listener;

import java.awt.event.ActionEvent;

import calc.Brain;

public class DivListener extends OperatorListener {

	/**
	 * Constructor for DivListener
	 * @param brain
	 */
	public DivListener(Brain brain) {
		super(brain);
	}

	public void actionPerformed(ActionEvent e) {
		brain.divide();

	}
}
