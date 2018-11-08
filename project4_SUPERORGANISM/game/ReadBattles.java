package game;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Reads the four different battle sequences into the game from Battles.txt.
 * @author SUPERORGANSIM
 *
 */
public class ReadBattles extends Reader {

	/**
	 * The map of different battles in the game.
	 */
	private static HashMap<String,ArrayList<Bout>> battles = new HashMap<String,ArrayList<Bout>>();
	
	/**
	 * 
	 * @param sourcefolder
	 */
	public ReadBattles(String sourcefolder) {
		super(sourcefolder);
	}

	/**
	 * Reads the battles into the game.
	 */
	public void read() {
		ArrayList<Bout> bouts = null;
		long time = 0;
		String comm = "";
		String desc = "";

		input = makeStream("Battles.txt");
		while (moveLine()) {
			if (hasChar('+')) {
				String creat = removeChar("+");
				bouts = new ArrayList<Bout>();
				battles.put(creat, bouts);
			}
			
			else if (hasChar('-')) {
				
				if (!desc.equals("")) {
					//Makes previous entry
					Bout instance = new Bout(time,comm,desc);
					bouts.add(instance);
					desc = "";
				}
				
				//Preps new entry.
				String addition = removeChar("-");
				String[] newstuff = addition.split(" ",2);
				time = Integer.parseInt(newstuff[0]);
				comm = newstuff[1];
				
			}
			else 
				desc = desc+"\n\t"+currentline+"\n";

		}
		input.close();
	}
	
	/**
	 * 
	 * @return the map of the battles in the game.
	 */
	public static HashMap<String, ArrayList<Bout>> getBattles() {return battles;}
}