package listener;

import java.awt.event.ActionEvent;

import calc.Brain;

public class ClearListener extends OperatorListener {

	/**
	 * Constructor for ClearListener
	 * @param brain
	 */
	public ClearListener(Brain brain) {
		super(brain);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		brain.clear();

	}

}
