package calc;

import java.awt.event.ActionEvent;

public class PlusMinusListener extends OperatorListener {

	/**
	 * Constructor for the PlusMinusListener
	 * @param brain
	 */
	public PlusMinusListener(Brain brain) {
		super(brain);
	}
	
	/**
	 * Action performed when the plus minus button is pressed
	 */
	public void actionPerformed(ActionEvent e) {
		brain.plusMinus();
	}

}
