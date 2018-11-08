package calc;

import java.awt.event.*;

/**
 * NumberListener
 * 
 * Connects to the number {1, 2, 3, 4, 5, 6, 7, 8, 9, 0} buttons on the calculator
 * and calls the setInput1 method of the class Brain.
 * 
 * @author noahwill
 *
 */
public class NumberListener implements ActionListener{
	
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
		brain.setInput1(num);
	}
}
