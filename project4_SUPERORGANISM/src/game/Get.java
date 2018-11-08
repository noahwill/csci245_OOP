package game;

/**
 * Class to model picking up an item.
 * @author SUPERORGANISM
 *
 */
public class Get extends Command {

	/**
	 * Allows the player to pick up an item as long as it is indicated in their command
	 * @param p the player in the game
	 * @param secondhalf the second half of the command, will indicate an item
	 */
	public void execute(Player p,String secondhalf) {
		if (secondhalf == "")
			secondhalf = "any nothings";
		Room room = p.getCurrentRoom();
		Item item = room.getItem();
		if (item!=null && item.getItemName().equals(secondhalf)) {
			if (!p.pickUp(item))
				System.out.printf("\n\t%s cannot be picked up, I'm afraid.\n",item.getItemName());
			else if (item.getItemName().equals("tail"))
				System.out.printf("\n\tYou pick up the gleaming whale tail: the mighty weapon, Lyngbakr. You return to the surface of the pool.\n");
			else
				System.out.printf("\n\tYou have picked up %s\n",item.getItemName());
		}
		else
			System.out.printf("\n\tI don't see %s anywhere.\n",secondhalf);
	}
}