package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Class to create a set of rooms with random directions between.
 * @author SUPERORGANSIM
 *
 */
public class Maze extends Room {

	private static HashMap<String,String> directions = new HashMap<String,String>();
	private static ArrayList<String> cardinals = new ArrayList<String>();
	private static int directioncount;
	
	static {
		directions.put("north","south");
		directions.put("east","west");
		directions.put("up","down");
		
		/**
		 * Adds directions in the other direction.
		 */
		HashSet<String> setofkeys = new HashSet<String>();
		setofkeys.addAll(directions.keySet());
		for (String key : setofkeys) {
			directions.put(directions.get(key),key);
		}
		cardinals.addAll(directions.keySet());
		directioncount = cardinals.size();
	}
	private Random rand = new Random();
	private Room entrance;
	private Room exit;
	@SuppressWarnings("unused")
	private int challenge;
	
	/**
	 * 
	 * @param count Number of rooms in the maze.
	 * @param difficulty Number of convolutions in the directions.
	 * @param title Name of each Room.
	 * @param description Description of each room.
	 */
	public Maze(String enterdir,Room connection,int count,int difficulty,String title, String description) {
		super(title, description);
		
		//tweak difficulty
		if (difficulty>6)
			difficulty = 6;
		if (difficulty<1)
			difficulty = 1;
		this.challenge = difficulty;
		
		basicMaze(enterdir,connection,count,title,description);
	}
	
	private void basicMaze(String enterdir,Room connection,int count,String title, String description) {
		Room[] maze = new Room[count];
    	for (int i=0;i<count;i++)
    		maze[i] = new Room(title,description);
    	
    	entrance = maze[0];
    	entrance.addDir(directions.get(enterdir),connection);
    	exit = maze[count-1];
    	
    	for (int i=0;i<count;i++) {
    		Room current = maze[i];
    		Room next;
    		if (i<count-1)
    			next = maze[i+1];
    		else
    			next = maze[0];
    		String way;
    		if (i==0)
    			way = "west";
    		else
    			way = randomDirection();
    		current.addDir(way,next);
    		next.addDir(directions.get(way), current);
    	}
    	
        for (Room current : maze) {
        	
        	//While less than three doors in the given room.
        	while (current.getDir().size()<3) {
        		
        		//Chooses destination, randomly but last choice has to connect to an incorporated maze.
        		Room destination;
        		Set<String> dirs;
	            Set<String> destdirs;
	            Set<String> destrevdirs;
	            Set<String> totaldirections = new HashSet<String>(cardinals);
	            Set<String> reprdirections;
        		do { 
        			destination = maze[rand.nextInt(count)];
	        		dirs = current.getSetofDir();
		            destdirs = destination.getSetofDir();
		            destrevdirs = new HashSet<String>();
		            for (String dir : destdirs)
	            		destrevdirs.add(directions.get(dir));
		            reprdirections = new HashSet<String>();
		            reprdirections.addAll(dirs);
		            reprdirections.addAll(destrevdirs);
        		} while (totaldirections.equals((reprdirections)));
        		
            	//Randomized direction.
            	String way;
            	
            	//Pick a random direction until neither room has direction already filled.
            	do {
            		way = cardinals.get(rand.nextInt(directioncount));
            	}	while (dirs.contains(way) ||
            			destrevdirs.contains(way));
	        	current.addDir(way,destination);
	        	destination.addDir(directions.get(way),current);
        	}
        	entrance.addDir(directions.get(enterdir),connection);
        }
	}
	/*
	private void buildroom(Room current) {
		int circular = rand.nextInt(1);
		int outward = rand.nextInt(difficulty);
		int totaldoors = 0;
	}
	*/
	/**
	 * Method to create the maze.
	 */
	/*
	private void makeMaze(String enterdir,Room connection,int count,int difficulty,String title, String description) {
    	
    	incorporatedrooms.add(maze[0]);
    	entrance = maze[count];
        for (Room current : maze) {
        	int doorcount = rand.nextInt(difficulty);
        	
        	//For each door to be generated.
        	for (int i=0;i<=doorcount;i++) {
        		
        		//Chooses destination, randomly but last choice has to connect to an incorporated maze.
        		Room destination;
        		Set<String> dirs;
	            Set<String> destdirs;
	            Set<String> destrevdirs;
	            Set<String> totaldirections = new HashSet<String>(cardinals);
	            Set<String> reprdirections;
        		do {
	        		if (i<doorcount)
	        			destination = maze[rand.nextInt(count)];
	        		else {
	        			int nextroomindex = rand.nextInt(incorporatedrooms.size());
	        			destination = incorporatedrooms.get(nextroomindex);
	        		}
	        		dirs = current.getSetofDir();
		            destdirs = destination.getSetofDir();
		            destrevdirs = new HashSet<String>();
		            for (String dir : destdirs)
	            		destrevdirs.add(directions.get(dir));
		            reprdirections = new HashSet<String>();
		            reprdirections.addAll(dirs);
		            reprdirections.addAll(destrevdirs);
        		} while (totaldirections.equals((reprdirections)));
        		
        		//Adds new room to incorporated rooms.
        		if (!incorporatedrooms.contains(current))
        			incorporatedrooms.add(current);
        		
            	//Randomized direction.
            	String way;
            	
            	
            	//Pick a random direction until neither room has direction already filled.
            	do {
            		way = cardinals.get(rand.nextInt(directioncount));
            	}	while (dirs.contains(way) ||
            			destrevdirs.contains(way));
	        	current.addDir(way,destination);
	        	destination.addDir(directions.get(way),current);
        	}
        }
    }
	*/
	
	private String randomDirection() {
		return cardinals.get(rand.nextInt(directioncount));
	}
	
	public HashMap<String,Room> getEnds(String nameofmaze) {
		HashMap<String,Room> exits = new HashMap<String,Room>();
		exits.put(nameofmaze+" entrance",entrance);
		exits.put(nameofmaze+" exit",exit);
		return exits;
	}
}