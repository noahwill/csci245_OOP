package calc;

import java.awt.event.ActionEvent;

public class DivListener extends OperatorListener {

	/**
	 * Constructor for DivListener.
	 */
	public DivListener(Brain brain) {
		super(brain);
	}

	/**
	 * Action performed when the slash button is pressed.
	 */
	public void actionPerformed(ActionEvent e) { brain.div(); }

}
