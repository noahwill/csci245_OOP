package game;

import java.util.Set;

/**
 * Allows the player to see what is in their inventory.
 * @author SUPERORGANISM
 *
 */
public class Inventory extends Command {
	
	/**
	 * Prints the items in a player's bag if there are any.
	 * @param p the player in the game.
	 */
	public void execute(Player p) {
		Set<String> items = p.getPack().getItemList();
		if (!items.isEmpty()) {
			System.out.printf("\n\tItems in backpack include:\t\n\n\t%s\n",items);
		}
		else
			System.out.printf("\n\tYour backpack is empty.\n");
	}
}