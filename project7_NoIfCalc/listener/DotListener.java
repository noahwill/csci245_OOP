package listener;

import java.awt.event.ActionEvent;
import calc.Brain;

public class DotListener extends OperatorListener {

	/**
	 * Constructor for DotListener
	 * @param brain
	 */
	public DotListener(Brain brain) {
		super(brain);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.brain.decimal();

	}

}
