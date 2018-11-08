package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Class to read in base initialization data.
 * @author superorganism
 */
public class ReadInit extends Reader {
	
	private static ReadInit one_read_init;
	private HashSet<String> localdirections;
	private HashSet<String> whaleitems = new HashSet<String>();
	private static ArrayList<String> localfilenames = new ArrayList<String>();
	private HashMap<String,Command> maincommands;
	
	
	private ReadInit(String source) {
		super(source);
		this.maincommands = Game.getInstance().getCommands();
		this.localdirections = Game.getInstance().getDirections();
		this.whaleitems = Game.getInstance().getWhaleitems();
	}
	
	private ReadInit() {
		super();
	}

	@Override
	public void read() {
		input = makeStream("Core.txt");
		
		makeDirections("-Floors-");
		makeFilenames("-Initial Commands-");
		makeInitialCommands("-Whale Items-");
		makeWhaleItems("-Next Section-");
		
	}

	private void makeDirections(String endpoint) {
		while (moveLine() && !currentline.equals(endpoint)) {
			localdirections.add(words[0]);
			maincommands.put(words[0], new Direction(words[0]));
			String[] otherforms = null;
			if (words.length != 1)
				otherforms = words[1].split(" ");
			for (String s : otherforms)
				maincommands.put(s, new Direction(words[0]));
		}
		
	}
	
	private void makeFilenames(String endpoint) {
		while (moveLine() && !currentline.equals(endpoint)) {
			localfilenames.add(Integer.parseInt(words[0]), words[1]);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void makeInitialCommands(String endpoint) {
		while (moveLine() && !currentline.equals(endpoint)) {
			try {
				Class<Command> classe = (Class<Command>) Class.forName("game."+words[1]);
				Command command = classe.newInstance();
				maincommands.put(words[0],command);
			} 
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.out.println(e);
			}
		}
	}
	private void makeWhaleItems(String endpoint) {
		while (moveLine() && !currentline.equals(endpoint)) {
			whaleitems.add(currentline);
		}
	}
	
	public static ArrayList<String> getFilenames() {return localfilenames;}
	
	public HashSet<String> getDirections() {return localdirections;}
	
	public static ReadInit getInstance(String source) {
		one_read_init = new ReadInit(source);
		return one_read_init;
	}
	public static ReadInit getInstance() {
		return one_read_init;
	}
}
