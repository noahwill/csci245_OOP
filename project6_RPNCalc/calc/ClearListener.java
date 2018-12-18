package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener {

	private Brain brain;
	
	/**
	 * Constructor for ClearListener.
	 */
	public ClearListener(Brain brain) {
		this.brain = brain;
	}

	/**
	 * Action performed when the clear button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		brain.clear();
	}

}
