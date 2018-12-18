package listener;

import java.awt.event.ActionEvent;

import calc.Brain;

public class MinusListener extends OperatorListener{

	/**
	 * Constructor for MinusListener.
	 * @param brain
	 */
	public MinusListener(Brain brain) {
		super(brain);
	}

	public void actionPerformed(ActionEvent e) {
		brain.subtract();
	}

}
