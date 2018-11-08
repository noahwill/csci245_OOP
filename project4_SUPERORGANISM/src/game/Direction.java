package game;

/**
 * Class to generate objects that handle all directional motion.
 * @author SUPERORGANISM
 *
 */
public class Direction extends Command {
	/**
	 * The direction indicated by the player's input. Saved here to ensure the correct move is made. 
	 */
	String word;
	
	/**
	 * Constructor to make a Direction object.
	 * @param word Direction to move.
	 */
	public Direction(String word) {
		this.word = word;
	}
	
	/**
	 * Moves player in the direction specified by String word in the current room.
	 */
	public void execute(Player p) {
		Room room = p.getCurrentRoom();
		Game g = Game.getInstance();
		
		if (room.getDir().containsKey(word) && 
				room.getDir().get(word).getTitle().equals("Drippy Pool")) {
    		if (!p.getPack().getItemList().contains("flippers"))
    			g.finishGame("drowning");
			else
				p.enterRoom(room.getDir().get(word.toLowerCase()));
		}
		
    	else	p.enterRoom(room.getDir().get(word.toLowerCase()));
	}
}