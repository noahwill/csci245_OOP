package hmllm;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MapIterator implements Iterator<String> {
	
	private Node head;
	private Node position;
	private Node previous;
	
	public boolean hasNext() {
		if(position != null)
			return true;
		else
			return false;
	}

	public String next() {
		
		if(hasNext()) {
			String keyReturn = position.getKey();
			previous = position;
			position = position.getLink();
			return keyReturn;
		}
		
		else 
			return null;
		
		
	}

}
