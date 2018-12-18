package calc;

import java.awt.event.ActionEvent;

public class MinusListener extends OperatorListener {

	/**
	 * Constructor for the MinusListener.
	 */
	public MinusListener(Brain brain) {
		super(brain);
	}

	/**
	 * Action performed when the minus button is pressed.
	 */
	public void actionPerformed(ActionEvent e) { brain.subtract(); }
	
}
