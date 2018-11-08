package game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * PlayGame.java
 * 
 * Program to control the playing of this game.
 *
 * @author SUPERORGANISM
 * 
 * Adapted from: Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class PlayGame {
    
	private static int deaths = 0;
	
	/**
	 * Start of game sequence.
	 * @param args
	 */
    public static void main(String[] args) {
    	
    	if (deaths == 0)
        	Intro.play();
    	
        Game game = Game.getInstance();   // reference to the game object
        game.fillGame("data");
        Player player = new Player(game);
        while (!game.isOver()) 
            Parser.executeTurn(player);
        System.out.println("\n\tGame over.");
        
        deaths++;
        
        System.out.print("\n\tAgain? (y/n): ");
        
        String[] answers = {
    			"y","yes","n","no"
    		};
    		
    	Set<String> ans = new HashSet<String>(Arrays.asList(answers));
    		
    	String current = "";
    	while (!ans.contains(current))
    		current = new Scanner(System.in).nextLine().toLowerCase();
    	
    	System.out.println();
    		
    	if (current.equals("y") || current.equals("yes")) {
            System.out.printf("\n\tDeaths: %s\n\n", deaths);
    		PlayGame.main(args);
    	}
    }
}