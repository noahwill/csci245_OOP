package listener;

import java.awt.event.ActionEvent;

import calc.Brain;

public class EqualListener extends OperatorListener {

	/**
	 * Constructor for EqualListener.
	 * @param brain
	 */
	public EqualListener(Brain brain) {
		super(brain);
	}

	public void actionPerformed(ActionEvent e) {
		brain.equals();
	}

}
