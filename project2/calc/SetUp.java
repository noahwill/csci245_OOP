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
*/

public class SetUp {

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	
	
	public static void setUpCalculator(CalculatorFace face) {

		face.addActionListener('1', new NumberListener("1", face));
		face.addActionListener('2', new NumberListener("2", face));
		face.addActionListener('3', new NumberListener("3", face));
		face.addActionListener('4', new NumberListener("4", face));
		face.addActionListener('5', new NumberListener("5", face));
		face.addActionListener('6', new NumberListener("6", face));
		face.addActionListener('7', new NumberListener("7", face));
		face.addActionListener('8', new NumberListener("8", face));
		face.addActionListener('9', new NumberListener("9", face));
		face.addActionListener('0', new NumberListener("0", face));
		
		
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
