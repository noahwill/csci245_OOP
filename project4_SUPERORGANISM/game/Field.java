package game;

/**
 * Class to create a set of rooms either in a grid or with random parameters.
 * @author SUPERORGANISM
 *
 */
public class Field extends Room {

	private Room[][] field;
	
	/**
	 * 
	 * @param width Length of horizontal access.
	 * @param height Height of vertical access.
	 * @param title Name of each Room.
	 * @param description Description of each room.
	 */
	public Field(int width, int height, String title, String description) {
		super(title, description);
		this.field = makeField(width, height, title, description);
	}
	
	/**
	 * Method to create the field.
	 */
	private Room[][] makeField(int width, int height, String title, String description) {
    	Room[][] field = new Room[width][height];
    	for (int i=0;i<width;i++) {
    		for (int j=0;j<height;j++) {
    			field[i][j] = new Room(title,description);
        	}
        }
        for (int i=0;i<width;i++) {
        	for (int j=0;j<height;j++) {
        		Room current = field[i][j];
        		if (j<height-1)
        			current.addDir("north", field[i][j+1]);
        		if (i<width-1)
        			current.addDir("east", field[i+1][j]);
        		if (j>0)
        			current.addDir("south", field[i][j-1]);
        		if (i>0)
        			current.addDir("west", field[i-1][j]);
        	}
        }
        return field;
    }
	
	/**
	 * @return The Field object.
	 */
	public Room[][] getField() { return this.field; }
}
