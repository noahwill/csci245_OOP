package game;

import java.util.HashMap;
import java.util.Set;

/**
 * Room.java
 * 
 * Class to model a room in the game.
 *
 * @author SUPERORGANISM
 * 
 * Adapted from: Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Room {
	
	/**
	 * A HashMap of directions in a particular room.
	 */
	private HashMap<String,Room> dir = new HashMap<String, Room>();
	
	/**
	 * The Creature object contained within the room.
	 */
	private Creature creature;
	
	/**
	 * The item contained within the room.
	 */
	private Item item;
	
	/**
	 * The title of this room.
	 */
	private String title;
	
	/**
	 * A description of this room.
	 */
	private String description;
	
	/**
	 * Whether or not a room has been entered before.
	 */
	private boolean entered;
	
	/**
	 * If, there is a creature, this is the room that it blocks. 
	 */
	private Room blocked;

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
	public Room(String title, String description) {
		this.title = title;
		this.description = description+"\n";
		entered = false;
		//this.dir = doors;
	}

	/**
	 * Applies a specific direction and destination room to calling object's direction.
	 */
	public void addDir(String direction, Room room) {
		dir.put(direction,room);
	}
	
	/**
	 * Removes a direction and its destination from the room
	 */
	public void rmDir(String direction) {
		dir.remove(direction);
	}
	
	/**
	 * Returns the HashMap of directions and the rooms they are related to.
	 * @return
	 */
	public HashMap<String,Room> getDir() {
		return dir;
	}
	
	/**
	 * Returns the set of directions out of the room. 
	 * @return
	 */
	public Set<String> getSetofDir() {
		Set<String> setOfDir = dir.keySet();
		return setOfDir;
	}
	
	/**
	 * Returns the description of the room.
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/** 
	 * Sets the description for the room. 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description+"\n\t";
	}

	/**
	 * Returns the title of the room.
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title of the room.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Returns the creature in the room.
	 * @return
	 */
	public Creature getCreature() {
		return creature;
	}
	
	/**
	 * @param player
	 * @return The room that is blocked by the creature.
	 */
	public Room getBlocked() {
		return blocked;
	}
	
	/**
	 * Sets the direction that a creature in the room blocks. 
	 * Removes the association between the current room and the blocked room
	 * @param player in the game
	 */
	public void setBlocked(Player player) {
		Creature c = player.getCurrentRoom().getCreature();
		String dirBlocked = c.getDirBlocked();
		this.blocked = player.getCurrentRoom().getDir().get(dirBlocked);
	}
	
	/**
	 * Sets the creature in the room.
	 * @param creature
	 */
	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	/**
	 * Gets the Item in the room.
	 * @return
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Sets the item in the room.
	 * @param item
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * @return whether or not the room has been entered.
	 */
	public boolean isEntered() {
		return entered;
	}
	
	/**
	 * Sets the room to entered.
	 * @param entered
	 */
	public void setEntered(boolean entered) {
		this.entered = entered;
	}
}