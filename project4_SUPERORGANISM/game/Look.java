package game;

/**
 * Allows the player to look around the room.
 * @author SUPERORGANISM
 *
 */
public class Look extends Command {

	/**
	 * Prints the description of the current room.
	 * @param p the player in the game.
	 */
	public void execute(Player p) {
		System.out.printf(p.getCurrentRoom().getDescription());
	}
}