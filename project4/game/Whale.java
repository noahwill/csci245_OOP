package game;

/**
 * Whale command is the game ender. The player turns into a whale.
 * @author SUPERORGANSIM
 *
 */
public class Whale extends Command {

	/**
	 * The player wins the game.
	 */
	public void execute(Player p) {
		Game.getInstance().finishGame("win");
	}
}