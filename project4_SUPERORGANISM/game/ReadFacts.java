package game;

import java.util.ArrayList;


/**
 * Class to read in list of whale facts.
 * @author superorganism
 *
 */
public class ReadFacts extends Reader {

	private static ArrayList<String> facts = new ArrayList<String>();

	public ReadFacts(String sourcefolder) {
		super(sourcefolder);
    	ReadBattles battles = new ReadBattles(sourcefolder);
    	battles.read();
	}

	public void read() {
		input = makeStream("Facts.txt");
		while (moveLine()) {
			facts.add(currentline);
		}
		input.close();
	}
	
	public static ArrayList<String> getFacts() {return facts;}
}