package game;

/**
 * Executes the Unlock command tied to the Key.
 * @author SUPERORGANISM
 *
 */
public class Unlock extends Command {

	/**
	 * Adds the link between Floor 1 and Floor 2.
	 */
	public void execute(Player p) {
		Room currentRoom = p.getCurrentRoom();
		String currentTitle = currentRoom.getTitle();
		Room temp = currentRoom.getDir().get("west");
		String westtitle = "";
		if (temp != null)
			westtitle = temp.getTitle();
		
		Game g = Game.getInstance();
		Room floor2Entrance = g.getFloor(2).getRoom("entrance");
		
		if (currentTitle.equals("an antechamber") && westtitle.equals("Ballroom")) {
			System.out.printf("\n\tThe door opens to the smell of freshly hatched starfish.\n");
			currentRoom.addDir("up", floor2Entrance);
		}
		
		else { System.out.println("\n\tThere's no door to unlock here."); }
	}
}