package calc;

import java.awt.event.ActionEvent;

public class AddListener extends OperatorListener {
	
	/**
	 * Constructor for an AddListener.
	 * @param brain
	 */
	public AddListener(Brain brain) {
		super(brain);
	}

	/**
	 * Action performed when the plus button is pressed.
	 */
	public void actionPerformed(ActionEvent e) { brain.add(); }

}
