package game;

/**
 * Wrapper class for a special printf.
 * @author SUPERORGANISM
 *
 */
public class Display {
	
	/**
	 * Prints the given format string with the objects to be formatted to it. 
	 * @param s the format string.
	 * @param args the arguments to be formatted.
	 */
	public void printToScreen(String s,Object ...args) {
		System.out.printf(s, args);
	}
}