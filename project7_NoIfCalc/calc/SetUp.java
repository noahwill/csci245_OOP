package calc;

import listener.AddListener;
import listener.ClearListener;
import listener.DivListener;
import listener.DotListener;
import listener.MinusListener;
import listener.MultListener;
import listener.NumberListener;
import listener.PlusMinusListener;

/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Thomas VanDrunen
 * CS 245, Wheaton College
 * June 27, 2014
*/
public class SetUp {

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face 
	 */
	public static void setUpCalculator(CalculatorFace face) {
		
		Brain brain = new Brain(face);
		
		for(int i = 0; i < 10; i++) { face.addNumberActionListener(i, new NumberListener(Integer.toString(i), brain)); }
		
		face.addActionListener('+', new AddListener(brain));
		face.addActionListener('-', new MinusListener(brain));
		face.addActionListener('*', new MultListener(brain));
		face.addActionListener('/', new DivListener(brain));
		face.addActionListener('C', new ClearListener(brain));
		face.addActionListener('.', new DotListener(brain));
		face.addActionListener('=', new EqualsListener(brain));
		face.addActionListener((char) 177, new PlusMinusListener(brain));
	}
		
	
	
	/**
	 * This main method is for your testing of your calculator.
	 * It will *not* be used during grading. Any changes you make
	 * to this method will be ignored at grading.
	 */
	public static void main(String[] args) {
		setUpCalculator(new PlainCalculatorFace());
	}

}
