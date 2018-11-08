package game;

/**
 * Item class. Each item behaves differently based on its unique special command.
 * @author SUPERORGANISM
 *
 */
public class Item {
	
	/**
	 * The item name.
	 */
	private String itemName;
	
	/**
	 * The item description
	 */
	private String description;
	
	/**
	 * Whether or not the item can be picked up.
	 */
	private boolean carry;
	
	/**
	 * The name of the command attached to the item.
	 */
	private String commandName;
	
	/**
	 * The command attached to the item.
	 */
	private Command specialCommand;
	
	/**
	 * Constructor for a new item.
	 * @param itemName
	 * @param description
	 * @param carry
	 * @param commandName
	 * @param specialCommand
	 */
	public Item(String itemName, String description, boolean carry, String commandName, Command specialCommand) {
		this.description = description;
		this.itemName = itemName;
		this.carry = carry;
		this.commandName = commandName;
		this.specialCommand = specialCommand;
	}
	
	/**
	 * @return WHether or not the item may be picked up.
	 */
	public boolean canCarry() {
		return carry;
	}

	/**
	 * 
	 * @return description
	 */
	public String getItemDescription() {
		return description;
	}

	/**
	 * 
	 * @return Item Name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * 
	 * @return Command Name
	 */
	public String getCommandName() {
		return this.commandName;
	}
	
	/**
	 * 
	 * @return Command
	 */
	public Command getSpecialCommand() {
		return this.specialCommand;
	}
}