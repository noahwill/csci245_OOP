package game;

import java.util.Set;

/**
 * Allows the player to swim out into the basement.
 * @author SUPERORGANSIM
 *
 */
public class Swim extends Command{

	/**
	 * If the player tries to swim with a direction and the room they are going to contains the word pool,
	 * they move there. If not, they are told they can't swim there.
	 */
	public void execute(Player p, String secondhalf) {
		Room r = p.getCurrentRoom();
		CharSequence pool = "Pool";
		Room poolRoom = r.getDir().get(secondhalf);
		
		Set<String> dirs = r.getSetofDir();
		
		if (!dirs.contains(secondhalf) || secondhalf.equals(""))
			System.out.println("\n\tYou can't swim here!");
		
		else if (poolRoom.getTitle().contains(pool) && !secondhalf.equals("")) {
			Direction nextRoom = new Direction(secondhalf);
			nextRoom.execute(p);
		}
		
		else 
			System.out.println("\n\tYou can't swim here!");
	}

}
