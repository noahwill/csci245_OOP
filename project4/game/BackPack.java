package game;

import java.util.HashMap;
import java.util.Set;

/**
 * Class to model an individual's current inventory.
 * @author superorganism
 */
public class BackPack {
	/**
	 * ArrayList of items in BackPack.
	 */
	private HashMap<String,Item> pack = new HashMap<String,Item>();
	
    /**
     * Method to add an item.
     * @param adding The item to add.
     */
	public boolean addToPack(Item adding) {
		if (adding.canCarry()) {
    		pack.put(adding.getItemName(),adding);
    		Game game = Game.getInstance();
    		if (pack.keySet().containsAll(game.getWhaleitems()))
    			game.addCommand("whale", new Whale());
    		return true;
		}
		return false;
	}
	
	/**
	 * Fetch item from BackPack.
	 * @param item The string of the item to get.
	 * @return The item object.
	 */
	public Item getItem(String item) {return pack.get(item);}
	
	/**
	 * @return The set of item names, the keys in the map.
	 */
	public Set<String> getItemList () {return pack.keySet();}
}