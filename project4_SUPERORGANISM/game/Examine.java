package game;

/**
 * Class to model examination of one of an eligible set of items.
 * @author SUPERORGANISM
 *
 */
public class Examine extends Command {

	/**
	 * Prints the object that corresponds to secondhalf.
	 */
	public void execute(Player p,String secondhalf) {		
		if (secondhalf == "")
			secondhalf = "any nothings";
		Room room = p.getCurrentRoom();
		Item item = room.getItem();
		Creature creature = room.getCreature();
		String desc = "";
		
		/**
		 * If player is examining a creature in the room.
		 */
		if (creature!=null) {
			if (creature.getName().equals(secondhalf))
				desc = creature.getDescription();
		}
		
		/**
		 * If player is examining an item in the room.
		 */
		if (item!=null) {
			if (item.getItemName().equals(secondhalf))
				desc = item.getItemDescription();
		}
		
		/**
		 * If player examines carried item.
		 */
		if (p.getPack().getItem(secondhalf) != null)
			if (p.getPack().getItem(secondhalf).getItemName().equals(secondhalf))
				desc = p.getPack().getItem(secondhalf).getItemDescription();
		
		/**
		 * If nothing is found.
		 */
		if (desc == "")
			System.out.printf("\n\tI don't see %s anywhere.\n",secondhalf);
		else
			System.out.printf("%s\n",desc);
	}
}