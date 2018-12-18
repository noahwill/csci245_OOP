package calc;

import java.awt.event.ActionEvent;

public class MultListener extends OperatorListener {

	/**
	 * Constructor for the MultListener.
	 */
	public MultListener(Brain brain) {
		super(brain);
	}

	/**
	 * Action performed when the multiply button is pressed.
	 */
	public void actionPerformed(ActionEvent e) { brain.mult(); }

}
