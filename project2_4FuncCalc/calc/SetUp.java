package calc;

/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Thomas VanDrunen
 * CS 245, Wheaton College
 * June 27, 2014
 * Updated by noahwill September 27, 2018
*/

public class SetUp {

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	public static void setUpCalculator(CalculatorFace face) {

		Brain brain = new Brain(face);
		
		for(int i = 0; i < 10; i++) {
			face.addNumberActionListener(i, new NumberListener(Integer.toString(i), brain));
		}
		
		face.addActionListener('+', new OperatorListener("+", brain));
		face.addActionListener('-', new OperatorListener("-", brain));
		face.addActionListener('*', new OperatorListener("*", brain));
		face.addActionListener('/', new OperatorListener("/", brain));
		
		face.addActionListener('.', new OtherListener(".", brain));
		face.addActionListener('C', new OtherListener("C", brain));
		face.addActionListener((char) 177, new PlusMinusListener(brain));
		
		face.addActionListener('=', new EqualsListener(brain));
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
