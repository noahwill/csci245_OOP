package game;
/**
 * Class for a creature object to be placed in a room.
 * @author SUPERORGANISM
 */
public class Creature {

	private String name;
	private String description; 
	private Item loot;
	private String dirBlocked;

	/**
	 * Constructor to create a creature.
	 * @param name Name of the creature.
	 * @param description Description of the creature.
	 * @param direction Direction blocked by the creature.
	 * @param loot Item dropped when creature falls.
	 */
	public Creature(String name, String description, String direction, Item loot) {
		this.name = name;
		this.description = description;
		this.dirBlocked = direction;
		this.loot = loot;
	}

	/**
	 * @return Name of the creature.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return Description of the creature.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return Item dropped when creature falls.
	 */
	public Item getLoot() {
		return loot;
	}
	
	/**
	 * @return The direction that is blocked by the creature.
	 */
	public String getDirBlocked() {
		return dirBlocked;
	}
}
