package calc;

import java.awt.event.ActionEvent;

public class DotListener extends OperatorListener {

	/**
	 * Constructor for DotListener.
	 */
	public DotListener(Brain brain) {
		super(brain);
	}

	/**
	 * Action performed when the dot button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		brain.operandPush();
	}

}
