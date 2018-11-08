package calc;

import java.text.DecimalFormat;

/**
 * Brain
 * 
 * Class that holds all of the methods and variables that enable the calculator to 
 * perform operations. 
 * 
 * @author noahwill
 *
 */
public class Brain {
	
	private static DecimalFormat df = new DecimalFormat("0.###");
	
	/**
	 * Fields to make the class Brain. Input1 is the initial input, operator stores the character of the operation
	 * to be performed, input0 is the memory of the calculator to allow for operations to be performed, result is 
	 * the number that is produced by the operation.
	 */
	private CalculatorFace face;
	private String         input1;
	private String         operator;
	private String         input0;
	private double 		   result;
	
	/**
	 * Constructor for class Brain.
	 * @param face
	 */
	public Brain(CalculatorFace face) {
		this.face = face;
	}
	
	/**
	 * Setter for input1. If input1 is null, someString will be added to an empty string.
	 * Otherwise, someString will be added to input1.
	 * @param someString
	 */
	public void setInput1(String someString) {
		if (input1 == null)
			input1 = someString;
		else
			input1 = input1 + someString;
		face.writeToScreen(input1);
	}
	
	/**
	 * Setter for input0, essentially the calculator memory. If input0 is null, someString 
	 * will be added to an empty string. Otherwise, someString will be added to input0.
	 * @param someString
	 */
	public void setInput0(String someString) {
		if (input0 == null)
			input0 = someString;
		else
			input0 = input0 + someString;
	} 
	
	/**
	 * Setter for operator. If operator is not null, the equals method will be called to complete the
	 * operation stored in memory. Input0 will be updated to be the result of the operation. 
	 * @param someString
	 */
	public void setOperator(String someString) {	
		if(operator != null) {
			equals();
			input0 = df.format(result);
			input1 = "";
			operator = someString;
		}
		else if (operator == null){
			operator = someString;
			input0 = input1;
			input1 = "";
		}
			
	}
	
	/**
	 * Method to add a decimal point to input1 if the decimal button is pressed.
	 * @param decimal
	 */
	public void decimalPoint(String decimal) {
		if (!input1.contains("."))
			input1 += decimal;
		face.writeToScreen(input1);
	}
	
	/**
	 * Method to clear the screen and memory of the calculator when the Clear button is pressed.
	 */
	public void clear() {
		input0 = null;
		operator = null;
		input1 = null;
		result = 0;		
		face.writeToScreen("");
	}
	
	/**
	 * Method to add/remove a minus sign from input1. 
	 * 
	 * If input1 is not null, and is not an empty string
	 * or the string "-" then it is converted to an integer, made negative, and saved back to a string. 
	 * Input1 is written to the screen.
	 * 
	 * If input1 is null, but there is a number in memory, input0 will be converted to an integer, made 
	 * negative, and saved back to a string. Otherwise, input1 will be a minus sign. Input0 is written 
	 * to the screen.
	 * 
	 * Otherwise it is assumed that input1 is null, so it is saved as the string "-" and written to the screen.
	 * 
	 * This is still not perfect...
	 */
	
	public void plusMinus() {
		if (input1 != null && input1.contains(".")) {
			switch(input1) {
			case "-.": input1 = ".";
				break;
			case ".": input1 = "-.";
				break;
			default: double n = Double.parseDouble(input1);
					 n = -n;
				     input1 = Double.toString(n);
					 break;
			}
				
				face.writeToScreen(input1);
		}
			
		else if (input1 == null && input0 != null && input0.contains(".")){
			double n = Double.parseDouble(input0);
			n = -n;
			input0 = Double.toString(n);
				
			face.writeToScreen(input0);
		}

		else if (input1 != null && !input1.contains(".")) {
			switch(input1) {
			case "-": input1 = "";
				break;
			case "": input1 = "-";
				break;
			default: int n = Integer.parseInt(input1);
					 n = -n;
					 input1 = Integer.toString(n);
					 break;
			}
				
				face.writeToScreen(input1);
		}
			
		else if (input1 == null && input0 != null && !input0.contains(".")){
			int n = Integer.parseInt(input0);
			n = -n;
			input0 = Integer.toString(n);
				
			face.writeToScreen(input0);
		}

		else {
			input1 = "-";
			face.writeToScreen(input1);
		}
	}
	
	/**
	 * Method to do the actual math performed by the calculator. If the operator is not null, that is the operator
	 * button has been pressed, the appropriate operation will be performed on the number in memory (input0) and the 
	 * number on the screen (input1). The operation will be reset to null and the result will be formatted and written
	 * to the screen. 
	 * 
	 * If the operator is null, that is the operator button has not been pressed a few cases must be accounted for. If
	 * input1 and input0 are not null, they are simply added together, saved to input0, and written to the screen. Otherwise,
	 * if input1 is not null, then its value is saved to input0 and is written to the screen.
	 * 
	 * At the end of the method, in order to ensure that consecutive operations may be performed on the given result,
	 * input0 is set to null, and input1 is set to the formatted result.
	 */
	public void equals() {
		result = 0; 
	
		if (operator != null) {
			switch(operator) {
			case "+": result += Double.parseDouble(input0) + Double.parseDouble(input1);
				 break;
			case "-": result += Double.parseDouble(input0) - Double.parseDouble(input1);
				 break;
			case "*": result += Double.parseDouble(input0) * Double.parseDouble(input1);
				 break;
			case "/": result += Double.parseDouble(input0) / Double.parseDouble(input1);
				break;
			case "" : result += Double.parseDouble(input0) + Double.parseDouble(input1);
					break;
			}
	
			operator = null;
			
			face.writeToScreen(df.format(result));
		}
		
		else if (operator == null) {
			if (input1 != null && input0 != null) {
				result += Double.parseDouble(input0) + Double.parseDouble(input1);
				
				input0 = df.format(result);
				input1 = null;
				
				face.writeToScreen(input0);
			}
			else if (input1 != null){

				input0 = input1;
				input1 = null;
				
				face.writeToScreen(input0);
			}	
		}
		
		input0 = null;
		input1 = df.format(result);
	}
	
}
