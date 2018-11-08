package game;

import java.io.*;
import java.util.*;

/**
 * Abstract Class to read in data to be used by the game.
 * All classes follow a similar format, reading lines and
 * filling data accordingly.
 * @author SUPERORGANISM
 */
public abstract class Reader {
	
	protected String currentline;
	protected String[] words;
	protected Scanner input;
	protected String sourcefolder;
	
	public Reader(String source) {
		sourcefolder = source;
	}
	
	public Reader() {}
	
	public abstract void read();
	
	protected Scanner makeStream(String filename) {
		InputStream stream = 
				this.getClass().getClassLoader().getResourceAsStream(filename);
		Scanner scanner = new Scanner(stream);
		//Jumps to after occurrence of <<<Data>>>
		input = scanner;
	    while (moveLine() && !currentline.equals("<<<Data>>>"));
		return scanner;
    }

    protected boolean hasChar(Character ... chars) {
	    char currentchar = currentline.charAt(0);
	    List<Character> charlist = Arrays.asList(chars);
	    return charlist.contains(currentchar);
    }
	protected boolean moveLine() {
        if (!input.hasNextLine())
			return false;
		currentline = input.nextLine();
		words = currentline.split(" ",2);
		if (currentline.equals(""))
        	moveLine();
		return true;
	}
	protected String removeChar(String a) {
		return currentline.replace(a, "");
	}
}
