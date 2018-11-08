package game;

/**
 * Class to allows a player to dive in the Deep Pool in the basement. 
 * @author SUPERORGANISM
 *
 */
public class Dive extends Command {

	/**
	 * Executes the command to dive. If the player is in the Deep Pool room, they initiate the dive sequence
	 * where they find the whale tail at the bottom of the pool. If they are not in the room, then they recieve
	 * a message that they can't dive there. 
	 * @param p The player in the game.
	 */
	public void execute(Player p) {
		Room currentRoom = p.getCurrentRoom();
		
		if (currentRoom.getTitle().equals("Deep Pool")) {
			Item tail = new Item("tail", "A whale tail.", true, "smash", new Kill());
			
			String[] divewords = {
					"\n\tYou're diving deep! 1 fathom",
					"\n\t...",
					"\n\tYou're diving deep! 2 fathoms",
					"\n\t...",
					"\n\tYou're diving deep! 3 fathoms",
			};
			
			for (String s : divewords) {
				System.out.println(s);
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {}
			}
			
			currentRoom.setItem(tail);
			
			System.out.println("\n\tThere's another whale part down here!");
		}
		
		else { System.out.println("\n\tYou can't do that here..."); }
	}
}
