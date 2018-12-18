package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calc.Brain;

public class AddListener extends OperatorListener implements ActionListener {

	/**
	 * Constructor for  AddListener
	 * @param brain
	 */
	public AddListener(Brain brain) {
		super(brain);
	}

	public void actionPerformed(ActionEvent e) {
		brain.add();
	}

}
