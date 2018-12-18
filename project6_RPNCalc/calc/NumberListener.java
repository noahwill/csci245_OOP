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
public class NumberListener extends OperatorListener {
	
	private String num;
	
	/**
	 * Constructor for the NumberListener class.
	 * @param num
	 * @param brain
	 */
	public NumberListener(String num, Brain brain) {
		super(brain);
		this.num = num;
	}

	/**
	 * Action performed when number button is pressed
	 */
	public void actionPerformed(ActionEvent e) { brain.updateScreen(num);}
}
