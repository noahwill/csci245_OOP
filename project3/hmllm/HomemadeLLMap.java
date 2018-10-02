package hmllm;

import java.util.Iterator;

/**
 * HomemadeLLMap
 * 
 * An implementation of the HomemadeMap class that uses
 * a completely-homemade linked list on the inside.
 * 
 * @author Thomas VanDrunen
 * CSCI 245, Wheaton College
 * June 30, 2014
 */

public class HomemadeLLMap implements HomemadeMap {

	private Node head;
	
	public HomemadeLLMap() {
		this.head = null;
	}
	
	public void addToStart(String key, String val) {
		head = new Node(key, val, head);
	}
	
	public int size() {
		int count = 0; 
		Node position = head;
		
		while (position != null) {
			count++;
			position = position.getLink();
		}
		return count;
	}
	
	/**
	 * Finds Node containing the given key.
	 * @param key
	 * @return node with the key
	 */
	public Node keyFinder(String key) {
		Node position = head;
		String keyFound;
		
		while (position != null) {
			keyFound = position.getKey();
			if (keyFound.equals(key))
				break;
			position = position.getLink();
		}
		return position;
	}
	
    /**
     * Test whether an association exists for this key.
     * @param key The key to remove
     * @return true if there is an association for this key, false otherwise
     */
    public boolean containsKey(String key) {
    	Node position = keyFinder(key);
    	if (position != null)
    			return true;
    	else	
    		return false;
    }
   

    /**
     * Add an association to the map.
     * @param key The key to this association
     * @param val The value to which this key is associated
     */
    public void put(String key, String val) {
    	
    	if (!containsKey(key)) {
    		head = new Node(key, val, head);
    	}

    	else {
    		Node position = keyFinder(key);
    		position.setVal(val);
    	}
    }  

    /**
     * Get the value for a key.
     * @param key The key whose value we're retrieving.
     * @return The value associated with this key, null if none exists
     */
    public String get(String key) {
    	return null;
    }

    /**
     * Get an iterator for all the keys in this map.
     * @return An iterator over the set of keys.
     */
    public Iterator<String> keyIterator() {
    	return null;
    }

    
    /**
     * Remove the association for this key.
     * @param key The key to remove
     */   
    public void remove(String key) {
    }


	
}
