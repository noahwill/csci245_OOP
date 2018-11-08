package game;


/**
 * Abstract class to take an object and polymorphically perform an action of a type which extends Command.
 * @author SUPERORGANSIM
 *
 */
public abstract class Command {
	/**
	 * @param p The player in the game.
	 * @param secondhalf The string of anything typed after the first word.
	 */
	public void execute(Player p,String secondhalf) {
		execute(p);
	}
	/**
	 * Overloaded methods to accommodate simpler commands.
	 */
	public void execute(Player p) {
		execute();
	}
	
	/**
	 * Basic command method.
	 */
	public void execute() {
	}
}