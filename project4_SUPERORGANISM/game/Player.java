package game;

public class Player {
    /**
     * The current room the user is in. This serves two
     * purposes-- it is our only permanent connection to
     * the rooms in this game (the other rooms are reachable
     * by traversing this room's "doors"-- and it maintains
     * the state by representing the user's current location.
     */
	private Room currentroom;
	
	/**
	 * The players pack.
	 */
	private BackPack pack = new BackPack();
	
	/**
	 * The game the player is in.
	 */
	private Game game;
	
	/**
	 * Initializes the game the player is in.
	 * @param g
	 */
	public Player(Game g) {
		currentroom = g.getStartingRoom();
		game = g;
	}
	
	/**
	 * Allows the player to pick up an item.
	 * @param adding
	 * @return whether or not the item was added to the bag.
	 */
	public boolean pickUp(Item adding) {
		if (pack.addToPack(adding)) {
			currentroom.setItem(null);
			if (adding.getSpecialCommand() != null) {
				game.addCommand(adding.getCommandName(), adding.getSpecialCommand());
			}
			return true;
		}
		return false;
	}
	
    /**
     * Move into a different room.
     */
    public void enterRoom(Room currentroom) {
    	if (currentroom != null)
    		this.currentroom = currentroom; 
    	else
    		System.out.println("\n\tYou can't go that direction here.");
    }
    
    /**
     * Returns pack.
     */
	public BackPack getPack() {
		return pack;
	}
    
    /**
     * Return the room in which the user is currently.
     */
	public Room getCurrentRoom() {return currentroom;}
}