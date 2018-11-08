package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The
 * rooms are organized as a graph, and the Room objects
 * are nodes in the graph.
 *
 * @author SUPERORGANISM
 * 
 * Adapted from:
 * Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Game {
	
	/**
	 * Single instance of the game that is accessible anywhere.
	 */
	private static Game one_game;
	/**
	 * Boolean that indicates whether or not the game is over.
	 */
    private boolean over;
    /**
     * Stores the starting room.
     */
    private Room startingroom;
    /**
     * The map of directions available to the player.
     */
    private HashSet<String> directions = new HashSet<String>();
    /**
     * The map of whale items needed to win the game.
     */
    private HashSet<String> whaleitems = new HashSet<String>();
    /**
     * The map of commands available to the player.
     */
    private HashMap<String,Command> commands;
    /**
     * The list of floors in the game. 
     */
	private ArrayList<Floor> floors = new ArrayList<Floor>();
	
	/**
     * Constructor to set up the game.
	 * @throws IOException 
     */
	private Game() {}
     
	/**
	 * Fills the game with the data found in the files read in. Has some overwriting for a specific linking case that needs to 
	 * be rearranged.
	 * @param sourcefolder
	 */
    public void fillGame(String sourcefolder) {
    	commands = new HashMap<String, Command>();
    	ReadInit initinput = ReadInit.getInstance(sourcefolder);
    	initinput.read();
    	ReadFloor floorinput = new ReadFloor(floors,sourcefolder);
    	floorinput.read();
    	ReadFacts facts = new ReadFacts(sourcefolder);
    	facts.read();
    	
    	startingroom = floors.get(1).getRoom("entrance");

    	//A few pattern-breaking tweaks.
    	floors.get(1).getRoom("antechamber").getDir().remove("up");
    	floors.get(0).getRoom("antechamber").setDescription("\n\tIts dark down here. Some pipes must have burst or the tanks leaked because"
    			+ "\n\tthe whole basement seems to be flooded. You could probably swim, if that"
    			+ "\n\twere possible for humans at this point in future-history.");
    	floors.get(0).getRoom("antechamber").setTitle("the basement foyer");
    	
        over = false;
    }
    
    /**
     * Keeps track of whether this game is over or not.
     */
    public void addCommand(String commandName, Command specialCommand) {
    	commands.put(commandName, specialCommand);
    }
    
    /**
     * End the game, either by death or by whale.
     */
    public void finishGame(String condition) {
    	if (condition.equals("win")) {
    		System.out.printf("\n\tYou have become a whale! Onward to victory!\n");
    		int squidpoints = 0;
    		if (getFloor(2).getRoom("squidroom").getCreature() == null)
    			squidpoints++;
    		System.out.printf("\n\tSquid points: %s\n",squidpoints);
    	}
    	else
    		System.out.printf("\n\tYou have been killed by %s!\n",condition);
    	over = true;
    	}
    
    /**
     * @return map of commands.
     */
	public HashMap<String,Command> getCommands() { return commands; }
	
	/**
     * @return map of commands.
     */
    public Room getStartingRoom() {return startingroom;}
    
    /**
     * @return map of directions.
     */
    public HashSet<String> getDirections() {return directions;}
    
    /**
     * @return map of whale items.
     */
    public HashSet<String> getWhaleitems() {return whaleitems;}
    
    /**
     * @return the floor indicated by the input (0,1,2,3).
     */
    public Floor getFloor(int i) {return floors.get(i);}

	/**
     * @return whether or not the game is over.
     */
    public boolean isOver() { return over; }
    
    /**
     * @return the instance of the game.
     */
    public static Game getInstance() {
    	if (one_game == null)
    		one_game = new Game();
    	return one_game;
    }
}