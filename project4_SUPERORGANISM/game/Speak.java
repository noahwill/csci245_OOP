package game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Allows the player to ponder the kind of whale they might want to be.
 * @author SUPERORGANSIM
 *
 */
public class Speak extends Command {
	
	/**
	 * Prints a kind of whale the player would like to be and removes that fact from the facts list.
	 */
	public void execute() {
		Random rand = new Random();
		ArrayList<String> facts = ReadFacts.getFacts();
		int index = (int) rand.nextInt(facts.size());
		System.out.printf("\n\tI would love to be a\n\n\t%s.\n\tThat may be my favorite kind of whale.\n",facts.get(index));
		facts.remove(index);
	}
}