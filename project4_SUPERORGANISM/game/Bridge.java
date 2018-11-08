package game;

/**
 * Extension of the Command class, the Bridge command allows a player to cross the gap on Floor 2.
 * @author SUPERORGANISM
 *
 */
public class Bridge extends Command {
	
	/**
	 * Executes the command to bridge the gap. A bridge only happens when the player is in the Shrine Room and
	 * has the harpoon and rope in their bag. If only the rope is in the bag, then the player receives a message
	 * to go and find it. If the player is not in the right room, they receive a message that they can't bridge there.
	 * @param p The player in the game.
	 */
	public void execute(Player p) {
		if (p.getCurrentRoom().getTitle().equals("Shrine Room"))
			if (p.getPack().getItem("harpoon") != null) {
				if (p.getCurrentRoom().getDir().get("east")==null) {
					System.out.printf("\n\tYou attach the rope to the harpoon and deftly throw it to make a bridge across"
							+ "\n\tthe chasm. You use your sword to cut the excess rope and tie of the end to take"
							+ "\n\tthe harpoon back.");
					p.getCurrentRoom().addDir("east",Game.getInstance().getFloor(2).getRoom("antechamber"));
				}
				else
					System.out.printf("\n\tThere's already a bridge here.");
			}
			else
				System.out.printf("\n\tI need something heavy to throw it across with.\n");
		else
			System.out.println("\n\tYou can't play bridge here, silly.");
	}
}