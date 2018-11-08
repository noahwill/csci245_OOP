package game;
import java.util.HashSet;
import java.util.Set;

/**
 * Prints the commands available to the player.
 * @author SUPERORGANISM
 *
 */
public class Help extends Command {
	
	/**
	 * Prints the commands available to the player
	 * @param p the player in the game
	 */
	public void execute(Player p) {
		Set<String> setOfCommands = Game.getInstance().getCommands().keySet();
		Set<String> setofDirections = Game.getInstance().getDirections();
		Set<String> todisplay = new HashSet<String>();
		
		todisplay.addAll(setOfCommands);
		todisplay.removeAll(setofDirections);
		
		Set<String> toremove = new HashSet<String>();
	
		String[] combat = {
			"slash","spear","smash"
		};
		
		Set<String> ccommands = new HashSet<String>();
		
		for (String s : todisplay) {
			if (s.length() == 1)
				toremove.add(s);
		}
		for (String s : combat)
			if (todisplay.contains(s))
				ccommands.add(s);
		
		todisplay.removeAll(toremove);
		todisplay.removeAll(ccommands);
		
		if (setOfCommands.contains("whale")) {
			todisplay.remove("whale");
			System.out.println("\n\tWhale Commands: [whale]");
		}
		
		System.out.print("\n\tGeneral Commands: " + todisplay + "\n");
		
		Set<String> dir = p.getCurrentRoom().getSetofDir();
		System.out.println("\tPossible Directions: " + dir);
		
		if (!ccommands.isEmpty())
			System.out.println("\tCombat Commands: " + ccommands);
	}
}