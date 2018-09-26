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
	
	public NumberListener naught = new NumberListener(null, )
	
	public static void setUpCalculator(CalculatorFace face) {

		NumberListener one = new NumberListener("1", face);
		face.addActionListener('1', one);
		
		NumberListener two = new NumberListener("2", face);
		face.addActionListener('2', two);
		
		NumberListener three = new NumberListener("3", face);
		face.addActionListener('3', three);
		
		NumberListener four = new NumberListener("4", face);
		face.addActionListener('4', four);
		
		NumberListener five = new NumberListener("5", face);
		face.addActionListener('5', five);
		
		NumberListener six = new NumberListener("6", face);
		face.addActionListener('6', six);
		
		NumberListener seven = new NumberListener("7", face);
		face.addActionListener('7', seven);
		
		NumberListener eight = new NumberListener("8", face);
		face.addActionListener('8', eight);
		
		NumberListener nine = new NumberListener("9", face);
		face.addActionListener('9', nine);
		
		NumberListener zero = new NumberListener("0", face);
		face.addActionListener('0', zero);
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
