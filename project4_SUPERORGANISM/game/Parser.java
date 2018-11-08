package game;

import java.util.*;

/**
 * 
 * Class to interpret the user's commands
 * @author SUPERORGANISM
 */
public class Parser {
    /**
     * For user input from the keyboard.
     */
    private static Scanner keyboard;
    
    /**
     * What is currently on the display.
     */
    private static Display display;
    
    /**
     * Current battle, if any.
     */
    private static Battle currentbattle = null;
    
    /**
     * Static initializer
     */
    static {
        keyboard = new Scanner(System.in);
        display = new Display();
    }

    /**
     * Let the user make one "turn" at this game.
     * Give the user a description of the room, prompt for
     * a command, and interpret the command.
     * @param game A reference to the object representing the game.
     */
    
    public static void executeTurn(Player player) {
        // The room that the user is in.
        Room room = player.getCurrentRoom();
        Game g = Game.getInstance();
        HashMap<String, Command> map = Game.getInstance().getCommands();
        long time;

        //Announce room, creature and item.
        p("\tYou are in %s\n",room.getTitle());
        if (!room.isEntered()) {
        	room.setEntered(true);
        	p(room.getDescription());
        }
        
        //Battle sequence implementation
        if (room.getCreature() != null) {
        	if (currentbattle==null)
        		currentbattle = new Battle(player);
        	currentbattle.prepareBout();
        }
        else
        	currentbattle = null;
        
        //Item declaration
        if (room.getItem() != null)
        	p("\n\tThere is a %s in this room.\n",room.getItem().getItemName());
        p("\nYour move:  ");
        
        //Input and call to function.
    	time = getTime();
        
        String command = keyboard.nextLine().toLowerCase();  // user's command
        String rest = "";
        String segmented[] = command.split(" ",2);
    	command = segmented[0];
    	
    	//Battle if:
    	if (!g.getDirections().contains(command) && currentbattle != null)
    		currentbattle.executeBout(command,rest,getTime()-time);
    	
    	//Non-combat stuff
    	else {
	    	if (segmented.length>1)
	    		rest = segmented[1];
	    	
	        if (map.get(command) != null)
	        	map.get(command).execute(player,rest);
	        else
	        	p("\n\tI don't know how to %s.\n",command);
	        p("\n");
    	}
    	
    }
    
    /**
     * Special print, just makes our lives easier.
     * @param s
     * @param args
     */
    private static void p(String s,Object...args) {
    	display.printToScreen(s, args);
    }
    
    /**
     * @return Gets the amount of time in a fight. 
     */
    private static long getTime() {
    	return java.lang.System.currentTimeMillis();
    }
}