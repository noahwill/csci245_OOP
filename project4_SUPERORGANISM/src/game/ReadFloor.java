package game;

import java.util.*;

/**
 * Class to read in data to be used by the game.
 * @author superorganism
 */
public class ReadFloor extends Reader {
    
	public ReadFloor(ArrayList<Floor> floors,String source) {
		super(source);
		this.floors = floors;
	}

	private HashMap<String,Room> rooms;
	private ArrayList<Floor> floors;
	private static ArrayList<String> filenames = ReadInit.getFilenames();
	private HashSet<String> directions = ReadInit.getInstance().getDirections();
	private HashMap<String,Item> items = new HashMap<String,Item>();
	
	public void read() {
		//Adding floor object corresponding to indexed filenames String
		//to floors ArrayList.
		int floorcount = filenames.size();
		for (int i = 0;i<floorcount;i++)
			floors.add(i,make(filenames.get(i)));
		
		//Linking together the floors.
		
		for (int i = 0;i<floorcount;i++) {
			if (i<floorcount-1)
				floors.get(i).setNextFloor(floors.get(i+1));
			if (i>0)
				floors.get(floorcount-i).setPrevFloor(floors.get(floorcount-1-i));
		}
	}
	
    private Floor make(String filename) {
        input = makeStream(filename);
        Floor newfloor = new Floor();
        rooms = newfloor.getRooms();
        
        makeRooms();
        fillRooms();
        
        input.close();
        return newfloor;
    }
    
    private void makeRooms() {
        String currentdesc = "";
        String roomname = null;
        String title = null;
        while (moveLine() && !currentline.equals("<<Directions,Creatures>>")) {
        	if (currentline.equals("<<Rooms>>"));
        	else if (hasChar('-','#')) {
        		
        		//Makes last room before preparing for the next one.
        		if (!currentdesc.equals("")) {
        			rooms.put(roomname,new Room(title,currentdesc));
        			currentdesc = "";
        		}
        		
        		//Maze generation
        		if (hasChar('#')) {
        			String mazename = removeChar("#");
        			moveLine();
        			String enterdir = words[0];
        			Room connection = rooms.get(words[1]);
        			moveLine();
        			String mazedesc = "\n\t"+currentline;
        			int length = input.nextInt();
        			int difficulty = input.nextInt();
        			rooms.putAll(new Maze(enterdir,connection,length,difficulty,mazename,mazedesc).getEnds(mazename));
        		}
        		
        		//Normal generation
        		if (hasChar('-')) {
	        		roomname = removeChar("-");
	        		moveLine();
	        		if (!currentline.equals(""))
	        			title = currentline;
        		}
        	}
        	
        	//Tags on to description of current room.
        	else
        		currentdesc += "\n\t"+currentline+" ";
        }
    }
    
    @SuppressWarnings({ "unchecked"})
	private void fillRooms() {
        Room currentroom = null;
        String roomname = null;
		while (moveLine()) {
			
			//Changes which room to be editing.
        	if (hasChar('+')) {
        		roomname = removeChar("+");
        		currentroom = rooms.get(roomname);
        	}
        	
        	//Adds directional reference to current room based on line.
        	else if (words.length>1 && directions.contains(words[0])) {
	        	String destination = words[1];
	        	if (rooms.containsKey(destination))
	        		currentroom.addDir(words[0],rooms.get(destination));
        	}
        	
        	//Generates creature.
        	else if (words[0].equals("creature")) {
        		String title = words[1];
        		moveLine();
        		String desc = "\n\t"+currentline;
        		moveLine();
        		String dir = null;
        		Item item = null;
        		if (words.length>1) {
	    			item = items.get(words[1]);
	        	if (directions.contains(words[0]))
	        		dir = words[0];
        		}
        		if (directions.contains(currentline))
	        		dir = currentline;
        		currentroom.setCreature(new Creature(title,desc,dir,item));
        	}
        	
        	//Generates item.
        	else if (words[0].equals("item")) {
	    		String title = words[1];
	    		moveLine();
	    		boolean carry = true;
	    		carry = !words[0].equals("static");
	    		String desc = "\n\t"+words[1];
	    		if (carry)
	    			desc = "\n\t"+currentline;
	    		moveLine();
	    		if (!currentline.equals("noability")) {
		    		String commandname  = words[0];
		    		try {
		    			Class<Command> classe = (Class<Command>) Class.forName("game."+words[1]);
			    		Command command = classe.newInstance();
			    		Item newitem = new Item(title,desc,carry,commandname,command);
						currentroom.setItem(newitem);
						items.put(title,newitem);
					} 
		    		catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		    			System.out.println(e);
		    		}
	    		}
	    		else {
	    			currentroom.setItem(new Item(title,desc,carry,null,null));
	    		}
        	}
        }
    }
}
