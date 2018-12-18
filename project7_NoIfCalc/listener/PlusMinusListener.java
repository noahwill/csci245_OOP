package listener;

import java.awt.event.ActionEvent;

import calc.Brain;

public class PlusMinusListener extends OperatorListener {

	/**
	 * Constructor for PlusMinusListener
	 * @param brain
	 */
	public PlusMinusListener(Brain brain) {
		super(brain);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		brain.plmn();
	}

}
