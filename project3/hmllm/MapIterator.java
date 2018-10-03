package hmllm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator class for the HomemadeLLMap
 * @author noahwill
 *
 */
public class MapIterator implements Iterator<String> {
	
	private Node head;
	
	/**
	 * Constructor for the MapIterator
	 * @param head
	 */
	public MapIterator(Node head) {
		this.head = head;
	}
	
	/**
	 * Returns true if the list has a next object, false if not.
	 */
	public boolean hasNext() {
		if(head != null)
			return true;
		else
			return false;
	}

	/**
	 * Returns the key of the next object in the list if it exists. 
	 */
	public String next() {
		if(hasNext()) {
			String keyReturn = head.getKey();
			head = head.getLink();
			return keyReturn;
		}
		
		else 
			return null;
	}

}
