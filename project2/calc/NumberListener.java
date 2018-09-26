package calc;

import java.awt.event.*;

public class NumberListener implements ActionListener{
	
	private NumberListener previous;
	private String num;
	private CalculatorFace face;
	private String repeat;
	private NumberListener next;
	
	
	public NumberListener(NumberListener previous, String num, CalculatorFace face, NumberListener next) {
		this.previous = previous;
		this.num = num;
		this.face = face;
		this.repeat = "";
		this.next = next;
	}
	

	public void actionPerformed(ActionEvent e) {
		repeat = repeat + num;
		face.writeToScreen(repeat);
	}


	public String getRepeat() {
		return repeat;
	}


	public NumberListener getPrevious() {
		return previous;
	}


	public NumberListener getNext() {
		return next;
	}


	public void setNext(NumberListener next) {
		this.next = next;
	}

}
