package calc;

import java.awt.event.*;

/**
 * OtherListener
 * 
 * Connects to two miscellaneous {., C} buttons on the calculator
 * and calls the decimalPoint or clear methods depending on which
 * button was pushed.
 * 
 * @author noahwill
 *
 */
public class OtherListener implements ActionListener{
	
	private String buttonName;
	private Brain brain;
	
	/**
	 * Constructor for OtherListener class.
	 * @param buttonName
	 * @param brain
	 */
	public OtherListener(String buttonName, Brain brain) {
		this.buttonName = buttonName;
		this.brain = brain;
	}

	/** 
	 * Action performed method for the OtherListener class.
	 */
	public void actionPerformed(ActionEvent e) {
		if (buttonName == ".")
			brain.decimalPoint(buttonName);
		else if (buttonName == "C")
			brain.clear();
	}
}
