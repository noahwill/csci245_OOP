package calc;

import java.awt.event.*;

public class NumberListener implements ActionListener{
	
	private String num;
	private CalculatorFace face;
	private String repeat;
	
	
	public NumberListener(String num, CalculatorFace face) {
		this.num = num;
		this.face = face;
		this.repeat = "";
	}

	public void actionPerformed(ActionEvent e) {
		repeat = repeat + num;
		face.writeToScreen(repeat);
	}

}
