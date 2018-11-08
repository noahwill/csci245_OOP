package game;

import java.util.HashMap;

/**
 * Abstract Class that sets up the two rooms (entrance and antechamber)
 * that will be on each floor.
 * @author SUPERORGANSIM
 *
 */
public class Floor {

	private HashMap<String,Room> rooms = new HashMap<String,Room>();
	
	/**
	 * Constructor for the Floor class. Defaults names and descriptions for entrance and antechamber.
	 */
	public Floor() {
		rooms.put("entrance",new Room("a foyer", "\n\tIt seems like this aquarium was built to have a large echoing foyer on"
				+ "\n\teach floor. There is a set of stairs that leads down to a floor below"));
				
		rooms.put("antechamber",new Room("an antechamber", "\n\tThere is a door on the north wall. You get the feeling this room is just"
				+ "\n\ta stepping stone towards your goal..."));
	}
	
	/**
	 * Getter for any given room.
	 * @return
	 */
	public Room getRoom(String name) {return rooms.get(name);}
	
	/**
	 * Method to connect floors to the previous floor. 
	 * @param floor
	 */
	public HashMap<String, Room> getRooms() {
		return rooms;
	}
	
	/**
	 * Sets the rooms on the floor.
	 * @param rooms
	 */
	public void setRooms(HashMap<String, Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * Links the floor (this) to the floor below it.
	 * @param floor
	 */
	public void setPrevFloor(Floor floor) {
		Room prevAntechamber = floor.getRoom("antechamber");
		rooms.get("entrance").addDir("down", prevAntechamber);
	}
	
	/**
	 * Links the floor (this) to the floor above it.
	 * @param floor
	 */
	public void setNextFloor(Floor floor) {
		Room nextEntrance = floor.getRoom("entrance");
		rooms.get("antechamber").addDir("up", nextEntrance);
	}
}
