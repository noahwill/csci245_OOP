package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calc.Brain;

public class NumberListener implements ActionListener {
	
	private String num;
	private Brain brain;
	
	/**
	 * Constructor for the NumberListener class.
	 * @param num
	 * @param brain
	 */
	public NumberListener(String num, Brain brain) {
		this.num = num;
		this.brain = brain;
	}

	/**
	 * Action performed method of the NumberListener class. 
	 */
	public void actionPerformed(ActionEvent e) {
		brain.setResult(num);
		brain.setState(brain.getState().getNumber());
		brain.getState().setInput(brain.getResult());
		
	}
}
